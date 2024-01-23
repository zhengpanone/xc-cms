package com.zp.exception;

import com.google.common.collect.ImmutableMap;
import com.zp.response.CommonResult;
import com.zp.response.IErrorCode;
import com.zp.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ExceptionCatch 异常捕获类
 *
 * @author zhengpanone
 * @since 2021-12-16
 */
// 控制器增强
@ControllerAdvice
public class ExceptionCatch {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    private static ImmutableMap<Class<? extends Throwable>, IErrorCode> EXCEPTIONS;
    // 定义异常类型所对应的错误代码
    protected static ImmutableMap.Builder<Class<? extends Throwable>,IErrorCode> builder = ImmutableMap.builder();

    @ExceptionHandler(CustomException.class)
    @ResponseBody
     public CommonResult<?> customException(CustomException customException){
        LOGGER.error("catch exception {}", customException.getMessage());
         return CommonResult.failed(customException);
     }
     @ExceptionHandler(Exception.class)
     @ResponseBody
     public CommonResult<?> exception(Exception exception){
         LOGGER.error("catch exception {}", exception.getMessage());
         if(EXCEPTIONS==null){
             EXCEPTIONS = builder.build(); // EXCEPTIONS 构建

         }
         IErrorCode resultCode = EXCEPTIONS.get(exception.getClass());
         if(resultCode!=null){
             return CommonResult.failed(resultCode);
         }
         return CommonResult.failed(ResultCode.SERVER_ERROR);
     }

     static {
        builder.put(HttpMessageNotReadableException.class,ResultCode.INVALID_PARAM);
     }
}
