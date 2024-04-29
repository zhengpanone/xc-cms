package com.zp.manage_course.service;

import com.zp.model.course.TeachPlanNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author : zhengpanone
 * Date : 2024/4/29 17:01
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootTest
@Slf4j
class CourseServiceTest {
    @Autowired
    CourseService courseService;

    @Test
    void findTeachPlanList() {
        TeachPlanNode teachPlanList = courseService.findTeachPlanList("4028e581617f945f01617f9dabc40000");
        log.info(teachPlanList.toString());
    }
}