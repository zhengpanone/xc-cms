package com.zp.model.course;

import lombok.Data;

import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:53
 * Version : v1.0.0
 * Description: TODO
 */
@Data
public class CategoryNode extends Category {
    List<CategoryNode> children;
}
