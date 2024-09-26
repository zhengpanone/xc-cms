package com.xc.base.model;

import lombok.Data;

/**
 * Author : zhengpanone
 * Date : 2024/9/26 22:07
 * Version : v1.0.0
 * Description:
 */
@Data
public class RestResponse<T> {
    /**
     * 响应编码,0为正常,-1错误
     */
    private int code;

    /**
     * 响应提示信息
     */
    private String msg;

    /**
     * 响应内容
     */
    private T result;
}
