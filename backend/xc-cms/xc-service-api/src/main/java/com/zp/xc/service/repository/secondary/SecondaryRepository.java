package com.zp.xc.service.repository.secondary;

import com.zp.xc.model.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondaryRepository extends MongoRepository<CmsPage, String> {
}
