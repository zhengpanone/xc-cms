package com.zp.manage_course.service;

import com.zp.manage_course.dao.CategoryMapper;
import com.zp.model.course.CategoryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:56
 * Version : v1.0.0
 * Description: TODO
 */
@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public CategoryNode findList() {
        return categoryMapper.findList();
    }
}
