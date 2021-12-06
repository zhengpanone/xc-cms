package com.zp.manage_cms.dao;

import com.zp.model.cms.CmsPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 类名为大驼峰+Repository
 * // 泛型第一个参数为模型,第二个为主键类型
 * @author zheng
 */
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {
    /**
     * 根据页面名称查询
     * @param pageName
     * @return
     */
    CmsPage findByPageName(String pageName);

    /**
     * 根据页面名称、站点id、页面webpath查询
     * @param pageName
     * @param siteId
     * @param pageWebPath
     * @return
     */
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName, String siteId, String pageWebPath);

    /**
     * 根据页面名称和别名查询
     * @param pageName
     * @param pageAliase
     * @return
     */
    CmsPage findByPageNameAndPageAliase(String pageName, String pageAliase);

    /**
     * 根据站点id和页面类型查询记录数
     * @param siteId
     * @param pageType
     * @return
     */
    int countBySiteIdAndPageType(String siteId, String pageType);

    /**
     * 根据站点id和页面类型分页查询
     * @param siteId
     * @param pageType
     * @param pageable
     * @return
     */
    Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);

}
