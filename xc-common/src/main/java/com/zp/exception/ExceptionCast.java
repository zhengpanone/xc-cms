package com.zp.exception;

import com.zp.response.IErrorCode;

/**
 * ExceptionCast 异常捕获类
 *
 * @author zhengpanone
 * @since 2021-12-16
 */
public class ExceptionCast {
    public static void cast(IErrorCode errorCode){
        throw new CustomException(errorCode);
    }
}
