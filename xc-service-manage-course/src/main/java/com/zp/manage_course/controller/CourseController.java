package com.zp.manage_course.controller;

import com.zp.api.course.CourseControllerApi;
import com.zp.manage_course.service.CourseService;
import com.zp.model.course.TeachPlan;
import com.zp.model.course.TeachPlanNode;
import com.zp.framework.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/teachPlan/add")
    @Override
    public CommonResult<TeachPlan> addTeachPlanList(@RequestBody TeachPlan teachPlan) {
        TeachPlan teachPlanNew = courseService.addTeachPlan(teachPlan);
        return CommonResult.success(teachPlanNew);
    }
}
