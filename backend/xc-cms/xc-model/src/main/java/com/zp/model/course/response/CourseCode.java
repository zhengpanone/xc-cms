package com.zp.model.course.response;

import com.zp.framework.response.IErrorCode;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 20:57
 * Version : v1.0.0
 * Description: TODO
 */
public enum CourseCode implements IErrorCode {
    COURSE_DENIED_DELETE(false, 31001, "删除课程失败，只允许删除本机构的课程！"),
    COURSE_PUBLISH_PERVIEWISNULL(false, 31002, "还没有进行课程预览！"),
    COURSE_PUBLISH_CDETAILERROR(false, 31003, "创建课程详情页面出错！"),
    COURSE_PUBLISH_COURSEIDISNULL(false, 31004, "课程Id为空！"),
    COURSE_PUBLISH_VIEWERROR(false, 31005, "发布课程视图出错！"),
    COURSE_MEDIA_URLISNULL(false, 31101, "选择的媒资文件访问地址为空！"),
    COURSE_MEDIA_TEACHPLAN_GRADEERROR(false, 31106, "只允许选择第三级的课程计划关联视频"),
    COURSE_MEDIA_NAMEISNULL(false, 31102, "选择的媒资文件名称为空！");

    //操作是否成功
    boolean success;

    //操作代码
    int code;
    //提示信息
    String message;

    private CourseCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
