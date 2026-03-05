package com.zp.manage_system.service;

import com.zp.manage_system.dao.SysDictionaryRepository;
import com.zp.model.system.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:08
 * Version : v1.0.0
 * Description: TODO
 */
@Service
public class SysDictionaryService {
    @Autowired
    SysDictionaryRepository sysDictionaryRepository;

    /**
     * 查询所有数据字典内容
     *
     * @return
     */
   public List<SysDictionary> queryAll() {
        return sysDictionaryRepository.findAll();
    }

    /**
     * 根据dType查询数据字典
     *
     * @param dType 数据字典dType
     * @return
     */
   public SysDictionary findBydType(String dType) {
        return sysDictionaryRepository.findBydType(dType);
    }


}
