package com.zp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 通用返回对象
 * @author zheng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;
    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static  CommonResult<?> success() {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static CommonResult<?> failed(IErrorCode errorCode){
        return new CommonResult<>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    /**
     * 失败返回结果
     */
    public static CommonResult<?> failed() {
        return failed(ResultCode.FAILED);
    }
}
