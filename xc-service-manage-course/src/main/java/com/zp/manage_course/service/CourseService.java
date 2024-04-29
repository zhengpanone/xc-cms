package com.zp.manage_course.service;

import com.zp.manage_course.dao.TeachPlanMapper;
import com.zp.model.course.TeachPlanNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author : zhengpanone
 * Date : 2024/4/29 16:53
 * Version : v1.0.0
 * Description: TODO
 */
@Service
public class CourseService {
    @Autowired
    TeachPlanMapper teachPlanMapper;
    //查询课程计划
    public TeachPlanNode findTeachPlanList(String courseId){
        TeachPlanNode teachPlanNode = teachPlanMapper.selectList(courseId);
        return teachPlanNode;
    }
}
