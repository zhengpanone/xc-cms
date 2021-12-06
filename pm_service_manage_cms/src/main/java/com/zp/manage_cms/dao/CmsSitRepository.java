package com.zp.manage_cms.dao;

import com.zp.model.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/06/25 17:59.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
public interface CmsSitRepository extends MongoRepository<CmsSite, String> {

}
