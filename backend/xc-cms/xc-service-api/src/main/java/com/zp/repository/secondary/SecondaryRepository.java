package com.zp.repository.secondary;

import com.zp.model.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondaryRepository extends MongoRepository<CmsPage, String> {
}
