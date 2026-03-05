package com.zp.manage_cms.feign;

import com.zp.framework.response.CommonResult;
import com.zp.model.course.TeachPlanNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author : zhengpanone
 * Date : 2024/9/24 21:11
 * Version : v1.0.0
 * Description:
 */
@FeignClient(value = "xc-service-manage-course")
public interface CourseFeignService {

    @GetMapping("/course/teachPlan/list/{courseId}")
    CommonResult<TeachPlanNode> findTeachPlanList(@PathVariable("courseId") String courseId);
}
