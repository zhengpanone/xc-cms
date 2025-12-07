package com.zp.xc.service.repository.primary;

import com.zp.xc.model.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrimaryRepository extends MongoRepository<CmsPage, String> {
}
