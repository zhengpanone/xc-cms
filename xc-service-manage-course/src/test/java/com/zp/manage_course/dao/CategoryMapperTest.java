package com.zp.manage_course.dao;

import com.zp.model.course.CategoryNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



/**
 * Author : zhengpanone
 * Date : 2024/4/30 14:08
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootTest
@Slf4j
class CategoryMapperTest {
    @Autowired
    CategoryMapper categoryMapper;

    @Test
    void findList() {
        CategoryNode list = categoryMapper.findList();
        log.info(list.toString());
    }
}