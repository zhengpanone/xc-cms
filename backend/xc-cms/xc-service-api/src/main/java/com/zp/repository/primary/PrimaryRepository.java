package com.zp.repository.primary;

import com.zp.model.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrimaryRepository extends MongoRepository<CmsPage, String> {
}
