package com.zp.manage_course.dao;

import com.zp.model.course.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:57
 * Version : v1.0.0
 * Description: TODO
 */
@Mapper
public interface CategoryMapper {
    CategoryNode findList();
}
