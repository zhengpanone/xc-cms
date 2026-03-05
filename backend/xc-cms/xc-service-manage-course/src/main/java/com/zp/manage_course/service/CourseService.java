package com.zp.manage_course.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zp.framework.exception.ExceptionCast;
import com.zp.framework.response.CommonPage;
import com.zp.framework.response.CommonResult;
import com.zp.framework.response.ResultCode;
import com.zp.manage_course.dao.CourseBaseRepository;
import com.zp.manage_course.dao.CourseMapper;
import com.zp.manage_course.dao.TeachPlanMapper;
import com.zp.manage_course.dao.TeachPlanRepository;
import com.zp.model.course.CourseBase;
import com.zp.model.course.CourseInfo;
import com.zp.model.course.TeachPlan;
import com.zp.model.course.TeachPlanNode;
import com.zp.model.course.request.CourseListRequest;
import com.zp.model.course.response.CourseCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    TeachPlanRepository teachPlanRepository;
    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    CourseMapper courseMapper;

    //查询课程计划
    public TeachPlanNode findTeachPlanList(String courseId) {
        TeachPlanNode teachPlanNode = teachPlanMapper.selectList(courseId);
        return teachPlanNode;
    }

    /**
     * 添加课程计划
     *
     * @param teachPlan
     */
    @Transactional
    public TeachPlan addTeachPlan(TeachPlan teachPlan) {

        if (teachPlan == null || StringUtils.isEmpty(teachPlan.getCourseId()) || StringUtils.isEmpty(teachPlan.getpName())) {
            ExceptionCast.cast(ResultCode.INVALID_PARAM);
        }
        String courseId = teachPlan.getCourseId();
        String parentId = teachPlan.getParentId();
        if (StringUtils.isEmpty(parentId)) {
            // 获取课程的跟节点
            parentId = getTeachPlanRoot(courseId);
        }
        Optional<TeachPlan> parentTeachPlanOptional = teachPlanRepository.findById(parentId);
        TeachPlan parentTeachPlan = parentTeachPlanOptional.get();
        TeachPlan teachPlanNew = new TeachPlan();
        BeanUtils.copyProperties(teachPlan, teachPlanNew);
        teachPlanNew.setParentId(parentId);
        teachPlanNew.setGrade(String.valueOf(Integer.valueOf(parentTeachPlan.getGrade()) + 1));
        teachPlanRepository.save(teachPlanNew);
        return teachPlanNew;
    }

    /**
     * 删除课程计划
     *
     * @param id
     */
    public void deleteTeachPlan(String id) {
        teachPlanRepository.deleteById(id);
    }

    /**
     * 查询课程根节点，如果查询不到要自动添加根节点
     *
     * @param courseId
     * @return
     */
    private String getTeachPlanRoot(String courseId) {
        List<TeachPlan> teachPlanList = teachPlanRepository.findByCourseIdAndParentId(courseId, "0");
        if (CollectionUtils.isEmpty(teachPlanList)) {
            Optional<CourseBase> courseBase = courseBaseRepository.findById(courseId);
            if (courseBase.isPresent()) {
                return null;
            }
            // 查询不到，自动添加根节点
            TeachPlan teachPlan = new TeachPlan();
            teachPlan.setParentId("0");
            teachPlan.setGrade("1");
            teachPlan.setpName(courseBase.get().getName());
            teachPlan.setCourseId(courseId);
            teachPlan.setStatus("0");
            teachPlanRepository.save(teachPlan);

            return teachPlan.getId();
        }
        return teachPlanList.get(0).getId();
    }

    /**
     * 添加课程基本信息
     *
     * @param courseBase
     * @return
     */
    public CourseBase addCourseBase(CourseBase courseBase) {
        courseBase.setStatus("202002");
        courseBaseRepository.save(courseBase);
        return courseBase;
    }


    public Page<CourseInfo> findCoursePage(String companyId, int pageNum, int pageSize, CourseListRequest courseListRequest) {
        if (courseListRequest == null) {
            courseListRequest = new CourseListRequest();
        }
        //将公司id参数传入dao
        courseListRequest.setCompanyId(companyId);
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }
        //设置分页参数
        PageHelper.startPage(pageNum, pageSize);

        return courseMapper.findCourseListPage(courseListRequest);
    }

    public CourseBase getCourseById(String courseId) {
        Optional<CourseBase> optional = courseBaseRepository.findById(courseId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCourseBase(String courseId, CourseBase courseBase) {
        CourseBase one = getCourseById(courseId);
        if (one == null) {
            ExceptionCast.cast(CourseCode.COURSE_PUBLISH_COURSEIDISNULL);
        }
        one.setName(courseBase.getName());
        one.setUsers(courseBase.getUsers());
        one.setMt(courseBase.getMt());
        one.setSt(courseBase.getSt());
        one.setGrade(courseBase.getGrade());
        one.setStudyModel(courseBase.getStudyModel());
        one.setDescription(courseBase.getDescription());
        courseBaseRepository.save(one);
    }


}
