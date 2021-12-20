package com.zp.exception;

import com.zp.response.ResultCode;

/**
 * CommonException 自定义异常类型
 *
 * @author zhengpanone
 * @since 2021-12-16
 */
public class CustomException extends RuntimeException {
    ResultCode resultCode;
    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
    public ResultCode getResultCode(){
        return resultCode;
    }

}
