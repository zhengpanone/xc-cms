package com.zp.manage_system.dao;

import com.zp.model.system.SysDictionary;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:24
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootTest
@Slf4j
class SysDictionaryRepositoryTest {
    @Autowired
    SysDictionaryRepository sysDictionaryRepository;

    @Test
    void findByDType() {
        SysDictionary byDType = sysDictionaryRepository.findBydType("200");
        log.info(byDType.toString());

    }
}