package com.zp.manage_cms.dao;

import com.zp.model.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * CmsTemplateRepository
 *
 * @author zhengpanone
 * @since 2021-12-13
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String> {
}
