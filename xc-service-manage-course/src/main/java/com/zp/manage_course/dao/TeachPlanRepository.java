package com.zp.manage_course.dao;

import com.zp.model.course.TeachPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 10:49
 * Version : v1.0.0
 * Description: TODO
 */
public interface TeachPlanRepository extends JpaRepository<TeachPlan, String> {

    List<TeachPlan> findByCourseIdAndParentId(String courseId, String parentId);
}
