package com.zp.manage_cms_client.dao;

import com.zp.model.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/06/25 17:59.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
public interface CmsSitRepository extends MongoRepository<CmsSite, String> {

}
