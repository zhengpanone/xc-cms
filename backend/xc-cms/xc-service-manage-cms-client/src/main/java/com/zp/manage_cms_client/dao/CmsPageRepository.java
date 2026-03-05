package com.zp.manage_cms_client.dao;

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


}
