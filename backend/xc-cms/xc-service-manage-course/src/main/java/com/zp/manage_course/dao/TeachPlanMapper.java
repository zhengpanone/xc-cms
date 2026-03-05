package com.zp.manage_course.dao;

import com.zp.model.course.TeachPlanNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author : zhengpanone
 * Date : 2024/4/29 16:47
 * Version : v1.0.0
 * Description: TODO
 */
@Mapper
public interface TeachPlanMapper {
    //课程计划查询
    TeachPlanNode selectList(String courseId);
}
