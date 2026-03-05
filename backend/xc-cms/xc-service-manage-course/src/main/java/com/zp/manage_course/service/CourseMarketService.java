package com.zp.manage_course.service;

import com.zp.manage_course.dao.CourseMarketRepository;
import com.zp.model.course.CourseMarket;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author : zhengpanone
 * Date : 2024/5/1 16:12
 * Version : v1.0.0
 * Description: TODO
 */
@Service
public class CourseMarketService {
    @Autowired
    private CourseMarketRepository courseMarketRepository;

    //根据课程id获取课程营销信息
    public CourseMarket getCourseMarketById(String courseId) {
        Optional<CourseMarket> optional = courseMarketRepository.findById(courseId);
        return optional.orElse(null);
    }

    public void updateCourseMarket(String courseId, CourseMarket courseMarket) {
        CourseMarket one = getCourseMarketById(courseId);
        if (one != null) {
            one.setCharge(courseMarket.getCharge());
            one.setPrice(courseMarket.getPrice());
            one.setQq(courseMarket.getQq());
            one.setValid(courseMarket.getValid());
            one.setStartTime(courseMarket.getStartTime());
            one.setEndTime(courseMarket.getEndTime());
        } else {
            // 添加课程营销信息
            one = new CourseMarket();
            BeanUtils.copyProperties(courseMarket, one);
            one.setId(courseId);
        }
        courseMarketRepository.save(one);

    }

}
