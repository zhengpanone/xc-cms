package com.zp.api.course;

import com.zp.framework.response.CommonResult;
import com.zp.model.course.CategoryNode;
import com.zp.model.course.TeachPlanNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:51
 * Version : v1.0.0
 * Description: TODO
 */
@Tag(name = "course-课程分类管理接口", description = "课程分类接口")
public interface CategoryControllerApi {
    @Operation(summary = "课程计划查询")
    CommonResult<CategoryNode> findList();
}
