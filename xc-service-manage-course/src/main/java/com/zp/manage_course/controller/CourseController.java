package com.zp.manage_course.controller;

import com.zp.api.course.CourseControllerApi;
import com.zp.manage_course.service.CourseService;
import com.zp.model.course.TeachPlanNode;
import com.zp.framework.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : zhengpanone
 * Date : 2024/4/29 16:56
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
@RequestMapping("/course")
public class CourseController implements CourseControllerApi {
    @Autowired
    CourseService courseService;
    //查询课程计划
    @Override
    @GetMapping("/teachPlan/list/{courseId}")
    public CommonResult<TeachPlanNode> findTeachPlanList(@PathVariable("courseId") String courseId) {
        TeachPlanNode teachPlanList = courseService.findTeachPlanList(courseId);
        return CommonResult.success(teachPlanList);
    }
}
