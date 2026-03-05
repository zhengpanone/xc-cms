package com.zp.manage_course.dao;

import com.github.pagehelper.Page;
import com.zp.model.course.CourseBase;
import com.zp.model.course.CourseInfo;
import com.zp.model.course.request.CourseListRequest;
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

    Page<CourseBase> findCourseList();
    //分页查询课程信息
    Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);

}
