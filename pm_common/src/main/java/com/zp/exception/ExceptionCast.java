package com.zp.exception;

import com.zp.response.ResultCode;

/**
 * ExceptionCast 异常捕获类
 *
 * @author zhengpanone
 * @since 2021-12-16
 */
public class ExceptionCast {
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
