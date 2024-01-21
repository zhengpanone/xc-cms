package com.zp.manage_cms.service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.zp.exception.ExceptionCast;
import com.zp.manage_cms.dao.CmsConfigRepository;
import com.zp.manage_cms.dao.CmsPageRepository;
import com.zp.manage_cms.dao.CmsTemplateRepository;
import com.zp.model.cms.CmsConfig;
import com.zp.model.cms.CmsPage;
import com.zp.model.cms.CmsTemplate;
import com.zp.model.cms.response.CmsResultCode;
import com.zp.model.request.QueryPageRequest;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * @author zheng
 */
@Service
public class CmsPageService {
    @Autowired
    CmsPageRepository cmsPageRepository;
    @Autowired
    CmsTemplateRepository cmsTemplateRepository;
    @Autowired
    private CmsConfigRepository cmsConfigRepository;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket gridFSBucket;

    /**
     * 页面查询
     *
     * @param page             从1开始计数
     * @param size             页面大小
     * @param queryPageRequest 查询参数
     * @return QueryResponseResult
     */
    public Page<CmsPage> findList(Integer page, Integer size, QueryPageRequest queryPageRequest) {
        if (queryPageRequest == null) {
            queryPageRequest = new QueryPageRequest();
        }
        // 自定义条件查询
        // 定义条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());

        // 条件值对象
        CmsPage cmsPage = new CmsPage();
        // 设置条件值
        if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        if (StringUtils.isNotEmpty(queryPageRequest.getPageId())) {
            cmsPage.setPageId(queryPageRequest.getPageId());
        }
        if (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        if (StringUtils.isNotEmpty(queryPageRequest.getPageName())) {
            cmsPage.setPageName(queryPageRequest.getPageName());
        }

        // 定义条件对象
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        // 分页参数
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        page= page -1;
        Pageable pageable = PageRequest.of(page, size);

        // 实现自定义条件并且分页查询
        return cmsPageRepository.findAll(example, pageable);

    }

    /**
     * 新增页面
     *
     * @param cmsPage cmsPage
     * @return CmsPageResult
     */
    public void add(CmsPage cmsPage) {
        /**
         * 校验页面
         * 根据页面名称、站点ID、页面webPath 查询唯一性
         * mongodb创建联合索引 db.cms_page.ensureIndex({siteId:1,pageName:1,pageWebPath:1},{unique:true});
         */
        CmsPage existCmsPage = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if (existCmsPage != null) {
            ExceptionCast.cast(CmsResultCode.CMS_ADDPAGE_EXISTSNAME);
        }
        cmsPage.setPageId(null);
        cmsPageRepository.save(cmsPage);
    }

    // 根据ID查找页面
    public CmsPage findById(String id) {
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            return cmsPage;
        }
        return null;

    }

    // 修改页面
    public String update(String id, CmsPage cmsPage) {
        String message = "";
        CmsPage one = this.findById(id);
        if (one != null) {
            one.setPageAliase(cmsPage.getPageAliase());
            one.setPageName(cmsPage.getPageName());
            one.setSiteId(cmsPage.getSiteId());
            one.setTemplateId(cmsPage.getTemplateId());
            one.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            one.setPageWebPath(cmsPage.getPageWebPath());
            one.setPageType(cmsPage.getPageType());
            one.setDataUrl(cmsPage.getDataUrl());
            cmsPageRepository.save(one);
            return message;
        }
        return message;
    }

    public String delete(String id) {
        String message ="";
        Optional<CmsPage> byId = cmsPageRepository.findById(id);
        if (byId.isPresent()) {
            cmsPageRepository.deleteById(id);
            return message;
        }

        return message;
    }


    // 根据Id查询cmsConfig
    public CmsConfig getConfigById(String id) {
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        if (optional.isPresent()) {
            CmsConfig cmsConfig = optional.get();
            return cmsConfig;
        }
        return null;
    }


    // 页面静态化方法
    public String getPageHtml(String pageId) {
        /**
         * 静态化程序获取Dataurl
         * 静态化程序远程请求DataUrl获取数据模型
         * 静态化程序获取页面模板信息
         * 执行页面静态化
         */
        // 获取数据模型
        Map model = getModelByPageId(pageId);
        if (model == null) {
            ExceptionCast.cast(CmsResultCode.CMS_GENERATEHTML_DATAISNULL);
        }
        // 获取页面模板信息
        String template = getTemplateByPageId(pageId);
        if (StringUtils.isEmpty(template)) {
            ExceptionCast.cast(CmsResultCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        // 执行静态化
        return generateHtml(template, model);
    }

    // 获取数据模型
    private Map getModelByPageId(String pageId) {
        CmsPage cmsPage = this.findById(pageId);
        if (cmsPage == null) {
            ExceptionCast.cast(CmsResultCode.CMS_PAGE_NOTEXISTS);
        }
        String dataUrl = cmsPage.getDataUrl();
        if (dataUrl == null) {
            // 页面Dataurl为空异常
            ExceptionCast.cast(CmsResultCode.CMS_GENERATEHTML_DATAURLISNULL);
        }
        // 通过restTemplate请求数据
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        return forEntity.getBody();
    }

    // 获取页面模板
    private String getTemplateByPageId(String pageId) {
        CmsPage cmsPage = this.findById(pageId);
        if (cmsPage == null) {
            ExceptionCast.cast(CmsResultCode.CMS_PAGE_NOTEXISTS);
        }
        String templateId = cmsPage.getTemplateId();
        if (StringUtils.isEmpty(templateId)) {
            ExceptionCast.cast(CmsResultCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        Optional<CmsTemplate> option = cmsTemplateRepository.findById(templateId);
        if (option.isPresent()) {
            CmsTemplate cmsTemplate = option.get();
            String templateFileId = cmsTemplate.getTemplateFileId();
            // 从GridFS获取文件
            GridFSFile gridfsFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(templateFileId)));
            // 打开一个下载流
            GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridfsFile.getObjectId());
            // 创建一个GridFsResource对象
            GridFsResource gridFsResource = new GridFsResource(gridfsFile, gridFSDownloadStream);
            // 从流中取数据
            try {
                String content = IOUtils.toString(gridFsResource.getInputStream(), "utf-8");
                return content;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    private String generateHtml(String templateContent, Map model) {
        // 创建配置对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 创建模板加载器
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("template", templateContent);

        // 配置模板加载器
        configuration.setTemplateLoader(stringTemplateLoader);

        try {
            // 获取模板
            Template template = configuration.getTemplate("template");
            // 调用API静态化
            return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;

    }

}
