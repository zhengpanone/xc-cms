package com.zp.api.course;

import com.zp.model.course.TeachPlanNode;
import com.zp.framework.response.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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
}


