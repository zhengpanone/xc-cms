package com.xc.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author : zhengpanone
 * Date : 2024/9/26 22:00
 * Version : v1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParam {
    // 当前页
    private Long pageNo = 1L;
    // 每页记录数
    private Long pageSize = 10L;
}
