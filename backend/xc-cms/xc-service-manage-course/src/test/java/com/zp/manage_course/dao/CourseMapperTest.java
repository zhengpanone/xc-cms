package com.zp.manage_course.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zp.model.course.CourseBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 12:28
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootTest
@Slf4j
class CourseMapperTest {
    @Autowired
    CourseMapper courseMapper;

    @Test
    void findCourseList() {
        PageHelper.startPage(1, 10);
        Page<CourseBase> courseList = courseMapper.findCourseList();
        log.info(courseList.toString());
    }
}