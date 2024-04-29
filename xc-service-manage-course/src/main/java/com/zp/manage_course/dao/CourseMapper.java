package com.zp.manage_course.dao;

import com.zp.model.course.CourseBase;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author : zhengpanone
 * Date : 2024/4/29 15:32
 * Version : v1.0.0
 * Description: TODO
 */
@Mapper
public interface CourseMapper {

    CourseBase findCourseBaseById(String id);
}
