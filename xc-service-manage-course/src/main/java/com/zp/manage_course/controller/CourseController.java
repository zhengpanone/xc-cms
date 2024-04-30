package com.zp.manage_course.controller;

import com.github.pagehelper.Page;
import com.zp.api.course.CourseControllerApi;
import com.zp.framework.response.CommonPage;
import com.zp.manage_course.service.CourseService;
import com.zp.model.course.CourseBase;
import com.zp.model.course.CourseInfo;
import com.zp.model.course.TeachPlan;
import com.zp.model.course.TeachPlanNode;
import com.zp.framework.response.CommonResult;
import com.zp.model.course.request.CourseListRequest;
import com.zp.model.request.QueryPageRequest;
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

    @DeleteMapping("/teachPlan/delete/{id}")
    @Override
    public CommonResult<?> deleteTeachPlanList(@PathVariable("id") String id) {
        courseService.deleteTeachPlan(id);
        return CommonResult.success();
    }

    @Override
    @PostMapping("/courseBase/add")
    public CommonResult<CourseBase> addCourseBase(@RequestBody CourseBase courseBase) {
        return CommonResult.success(courseService.addCourseBase(courseBase));
    }

    @Override
    @PostMapping("/courseBase/update/{courseId}")
    public CommonResult<?> updateCourseBase(@PathVariable("courseId") String courseId, @RequestBody CourseBase courseBase) {
        courseService.updateCourseBase(courseId,courseBase);
        return CommonResult.success();
    }

    @Override
    @GetMapping("/courseBase/{courseId}")
    public CommonResult<CourseBase> getCourseBaseById(@PathVariable("courseId") String courseId) {
        return CommonResult.success(courseService.getCourseById(courseId));
    }

    @Override
    @GetMapping("courseBase/list/{page}/{size}")
    public CommonResult<CommonPage<CourseInfo>> findCourseList(@PathVariable("page") int pageNum,
                                                               @PathVariable("size") int pageSize,
                                                               CourseListRequest courseListRequest) {
        Page<CourseInfo> coursePage = courseService.findCoursePage("1", pageNum, pageSize, courseListRequest);
        CommonPage<CourseInfo> courseInfoCommonPage = CommonPage.restPage(coursePage);
        return CommonResult.success(courseInfoCommonPage);
    }
}
