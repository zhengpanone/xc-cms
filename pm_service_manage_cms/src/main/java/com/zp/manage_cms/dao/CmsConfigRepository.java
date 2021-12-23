package com.zp.manage_cms.dao;

import com.zp.model.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * CmsConfigRepository
 *
 * @author zhengpanone
 * @since 2021-12-23
 */
public interface CmsConfigRepository extends MongoRepository<CmsConfig,String> {
}
