package com.zp.manage_course.dao;

import com.zp.model.course.CourseBase;
import com.zp.model.course.CourseMarket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author : zhengpanone
 * Date : 2024/5/2 20:53
 * Version : v1.0.0
 * Description: TODO
 */
public interface CourseMarketRepository extends JpaRepository<CourseMarket, String> {
}
