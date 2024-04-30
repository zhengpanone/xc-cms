package com.zp.manage_system.dao;

import com.zp.model.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:07
 * Version : v1.0.0
 * Description: TODO
 */
public interface SysDictionaryRepository extends MongoRepository<SysDictionary, String> {

    SysDictionary findBydType(String dType);
}
