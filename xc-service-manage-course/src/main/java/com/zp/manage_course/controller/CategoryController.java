package com.zp.manage_course.controller;

import com.zp.api.course.CategoryControllerApi;
import com.zp.framework.response.CommonResult;
import com.zp.manage_course.service.CategoryService;
import com.zp.model.course.CategoryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:51
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
@RequestMapping("/category")
public class CategoryController implements CategoryControllerApi {
    @Autowired
    CategoryService categoryService;

    @Override
    @GetMapping("/list")
    public CommonResult<CategoryNode> findList() {
        return CommonResult.success(categoryService.findList());
    }
}
