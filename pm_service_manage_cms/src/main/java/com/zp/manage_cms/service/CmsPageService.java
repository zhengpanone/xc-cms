package com.zp.manage_cms.service;

import com.zp.exception.ExceptionCast;
import com.zp.manage_cms.dao.CmsPageRepository;
import com.zp.model.cms.CmsPage;
import com.zp.model.cms.response.CmsCode;
import com.zp.model.cms.response.CmsPageResult;
import com.zp.model.request.QueryPageRequest;
import com.zp.response.CommonCode;
import com.zp.response.QueryResponseResult;
import com.zp.response.QueryResult;
import com.zp.response.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zheng
 */
@Service
public class CmsPageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    /**
     * 页面查询
     *
     * @param page             从1开始计数
     * @param size             页面大小
     * @param queryPageRequest 查询参数
     * @return QueryResponseResult
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        if (queryPageRequest == null) {
            queryPageRequest = new QueryPageRequest();
        }
        //自定义条件查询
        // 定义条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());

        //条件值对象
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

        //定义条件对象
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        //分页参数
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        page = page - 1;
        Pageable pageable = PageRequest.of(page, size);

        QueryResult queryResult = new QueryResult();
        //实现自定义条件并且分页查询
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 新增页面
     *
     * @param cmsPage cmsPage
     * @return CmsPageResult
     */
    public CmsPageResult add(CmsPage cmsPage) {
        /**
         * 校验页面
         * 根据页面名称、站点ID、页面webPath 查询唯一性
         * mongodb创建联合索引 db.cms_page.ensureIndex({siteId:1,pageName:1,pageWebPath:1},{unique:true});
         */
        CmsPage cmspage1 = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if(cmspage1!=null){
            ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        if (cmspage1 == null) {
            cmsPage.setPageId(null);
            cmsPageRepository.save(cmsPage);
            return new CmsPageResult(CommonCode.SUCCESS, cmsPage);
        }
        return new CmsPageResult(CommonCode.FAIL, null);
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
    public CmsPageResult update(String id, CmsPage cmsPage) {
        CmsPage one = this.findById(id);
        if (one != null) {
            one.setPageAliase(cmsPage.getPageAliase());
            one.setPageName(cmsPage.getPageName());
            one.setSiteId(cmsPage.getSiteId());
            one.setTemplateId(cmsPage.getTemplateId());
            one.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            one.setPageWebPath(cmsPage.getPageWebPath());
            cmsPageRepository.save(one);
            return new CmsPageResult(CommonCode.SUCCESS, one);
        }
        return new CmsPageResult(CommonCode.FAIL, null);
    }

    public ResponseResult delete(String id){
        Optional<CmsPage> byId = cmsPageRepository.findById(id);
        if(byId.isPresent()){
            cmsPageRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }

        return new ResponseResult(CommonCode.FAIL);
    }

}
