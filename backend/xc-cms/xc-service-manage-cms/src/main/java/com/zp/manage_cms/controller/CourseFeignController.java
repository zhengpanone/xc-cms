package com.zp.manage_cms.controller;

import com.zp.framework.response.CommonResult;
import com.zp.manage_cms.feign.CourseFeignService;
import com.zp.model.course.TeachPlanNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author : zhengpanone
 * Date : 2024/9/24 21:16
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
@RequestMapping("/cms/course")
public class CourseFeignController {
    @Resource
    private CourseFeignService courseFeignService;

    @GetMapping(value = "/consumer/{courseId}")
    public CommonResult<TeachPlanNode> getPaymentById(@PathVariable("courseId") String courseId) {
        return courseFeignService.findTeachPlanList(courseId);
    }
}
