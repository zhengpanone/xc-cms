package com.xc.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2024/9/26 22:05
 * Version : v1.0.0
 * Description: 分页响应
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    // 数据列表
    private List<T> items;

    //总记录数
    private long counts;

    //当前页码
    private long page;

    //每页记录数
    private long pageSize;
}
