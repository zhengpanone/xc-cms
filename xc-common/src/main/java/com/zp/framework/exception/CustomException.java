package com.zp.framework.exception;

import com.zp.framework.response.IErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * CommonException 自定义异常类型
 *
 * @author zhengpanone
 * @since 2021-12-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException implements IErrorCode {
    private long code;
    // 提示信息
    private String message;
    public CustomException(IErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
