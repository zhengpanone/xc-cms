package com.zp.exception;

import com.google.common.collect.ImmutableMap;
import com.zp.response.CommonCode;
import com.zp.response.ResponseResult;
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

    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();

    @ExceptionHandler(CustomException.class)
    @ResponseBody
     public ResponseResult customException(CustomException customException){
        LOGGER.error("catch exception {}", customException.getMessage());
         ResultCode resultCode = customException.getResultCode();
         return new ResponseResult(resultCode);
     }
     @ExceptionHandler(Exception.class)
     @ResponseBody
     public ResponseResult exception(Exception exception){
         LOGGER.error("catch exception {}", exception.getMessage());
         if(EXCEPTIONS==null){
             EXCEPTIONS = builder.build(); // EXCEPTIONS 构建

         }
         ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
         if(resultCode!=null){
             return new ResponseResult(resultCode);
         }
         return new ResponseResult(CommonCode.SERVER_ERROR);
     }

     static {
        builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);
     }
}
