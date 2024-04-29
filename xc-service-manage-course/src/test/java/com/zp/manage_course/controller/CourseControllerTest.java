package com.zp.manage_course.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * Author : zhengpanone
 * Date : 2024/4/29 17:01
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest {
    @Autowired
    private CourseController courseController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }

    @Test
    void findTeachPlanList() throws Exception {
        String courseId = "4028e581617f945f01617f9dabc40000";
        mockMvc.perform(MockMvcRequestBuilders.get("/course/teachPlan/list/{courseId}", courseId))
                .andExpect(MockMvcResultMatchers.status().isOk())
        //.andExpect(MockMvcResultMatchers.content().string("id"+courseId))
        ;
    }
}