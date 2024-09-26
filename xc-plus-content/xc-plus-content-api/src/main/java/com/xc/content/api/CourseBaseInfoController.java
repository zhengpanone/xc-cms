package com.xc.content.api;

import com.xc.base.model.PageParam;
import com.xc.base.model.PageResult;
import com.xc.model.po.CourseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : zhengpanone
 * Date : 2024/9/26 22:09
 * Version : v1.0.0
 * Description:
 */
@RequestMapping("/course")
@RestController
public class CourseBaseInfoController {
    @RequestMapping("/list")
    public PageResult<CourseBase> list(PageParam pageParam) {
        PageResult<CourseBase> result = new PageResult<CourseBase>();
        return result;
    }
}
