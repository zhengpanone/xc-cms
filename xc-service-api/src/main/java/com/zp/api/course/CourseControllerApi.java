package com.zp.api.course;

import com.zp.framework.response.CommonPage;
import com.zp.model.course.*;
import com.zp.framework.response.CommonResult;
import com.zp.model.course.request.CourseListRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author : zhengpanone
 * Date : 2024/4/29 16:58
 * Version : v1.0.0
 * Description: TODO
 */
@Tag(name = "course-课程计划接口", description = "课程计划接口")
public interface CourseControllerApi {
    @Operation(summary = "课程计划查询")
    CommonResult<TeachPlanNode> findTeachPlanList(String id);

    @Operation(summary = "添加课程计划")
    CommonResult<TeachPlan> addTeachPlanList(TeachPlan teachPlan);

    @Operation(summary = "删除课程计划")
    CommonResult<?> deleteTeachPlanList(String id);

    @Operation(summary = "添加课程基本信息")
    CommonResult<CourseBase> addCourseBase(CourseBase courseBase);
    @Operation(summary = "查询课程类别")
    CommonResult<CommonPage<CourseInfo>> findCourseList(int pageNum, int pageSize, CourseListRequest courseListRequest);
    @Operation(summary = "查看课程基本信息")
    CommonResult<CourseBase> getCourseBaseById(String courseId);
    @Operation(summary = "更新课程基本信息")
    CommonResult<?> updateCourseBase(String courseId, CourseBase courseBase);
    @Operation(summary = "获取课程营销信息")
    CourseMarket getCourseMarketById(String courseId);
    @Operation(summary = "更新课程营销信息")
    CommonResult<?> updateCourseMarket(String courseId, CourseMarket courseMarket);
}


