package com.zp.manage_cms_client.service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.zp.manage_cms_client.dao.CmsPageRepository;
import com.zp.manage_cms_client.dao.CmsSitRepository;
import com.zp.model.cms.CmsPage;
import com.zp.model.cms.CmsSite;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.Optional;

/**
 * Author : zhengpanone
 * Date : 2024/4/28 17:56
 * Version : v1.0.0
 * Description: TODO
 */
@Service
@Slf4j
public class PageService {
    @Resource
    CmsPageRepository cmsPageRepository;
    @Resource
    CmsSitRepository cmsSitRepository;
    @Resource
    GridFsTemplate gridFsTemplate;
    @Resource
    GridFSBucket gridFSBucket;

    /**
     * 保存html页面到服务器物理路径
     *
     * @param pageId
     */
    public void savePageToServerPath(String pageId) {
        // 根据pageId查询cmsPage
        CmsPage cmsPage = findCmsPageById(pageId);
        if (cmsPage == null) {
            log.warn("Page " + pageId + " not found");
            return;
        }
        String htmlFileId = cmsPage.getHtmlFileId();
        // 从gridFS中查询html文件
        InputStream inputStream = getFileById(htmlFileId);
        if (inputStream == null) {
            log.error("getFileById:{} input stream is null", htmlFileId);
            return;
        }
        // 得到站点物理路径
        CmsSite cmsSite = findCmsSiteById(cmsPage.getSiteId());
        if (cmsSite == null) {
            log.warn("Site " + cmsPage.getSiteId() + " not found");
            return;
        }
        String sitePhysicalPath = cmsSite.getSitePhysicalPath();
        String pagePath = sitePhysicalPath + cmsPage.getPagePhysicalPath() + cmsPage.getPageName();
        // 将html文件保存到服务器
        FileOutputStream fileOutputStream = null;
        try {

            fileOutputStream = new FileOutputStream(new File(pagePath));
            IOUtils.copy(inputStream, fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * 根据文件ID从gridFs中查询文件内容
     *
     * @param fileId
     * @return
     */
    public InputStream getFileById(String fileId) {
        // 文件对象
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        // 打开下载流
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        // 定义GridFsResource
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        try {
            return gridFsResource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据页面id查询页面信息
     *
     * @param pageId
     * @return
     */
    public CmsPage findCmsPageById(String pageId) {
        Optional<CmsPage> optional = cmsPageRepository.findById(pageId);
        return optional.orElse(null);
    }

    /**
     * 根据站点id查询站点信息
     *
     * @param siteId
     * @return
     */
    public CmsSite findCmsSiteById(String siteId) {
        Optional<CmsSite> optional = cmsSitRepository.findById(siteId);
        return optional.orElse(null);
    }
}
