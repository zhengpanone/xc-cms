package com.xc.model.dto;

import lombok.Data;

/**
 * Author : zhengpanone
 * Date : 2024/9/26 22:03
 * Version : v1.0.0
 * Description: 课程查询条件
 */
@Data
public class QueryCourseParamsDTO {
    //审核状态
    private String auditStatus;
    //课程名称
    private String courseName;
    //发布状态
    private String publishStatus;
}
