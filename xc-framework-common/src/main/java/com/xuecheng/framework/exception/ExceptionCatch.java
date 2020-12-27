package com.xuecheng.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:dashuai
 * @ClassName:ExceptionCatch
 * @Descirption: 异常捕获类
 * @date:2020/12/27 16:18
 */
@ControllerAdvice
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);
    //使用EXCEPTIONS存放异常类型和错误代码的映射，ImmutableMap的特点的一旦创建不可改变，并且线程安全
    private static ImmutableMap<Class<? extends Throwable>,ResultCode> EXCEPTIONS;
    //使用builder来构建一个异常类型和错误代码的异常
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();
    static {
        //在这里加入一些基础的异常类型判断
       builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);
    }
    //捕获 CustomException异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException){
        LOGGER.error("catch exception : {}\r\nexception: ",customException.getMessage(),customException);
        ResultCode resultCode = customException.getResultCode();
        ResponseResult responseResult = new ResponseResult(resultCode);
        return responseResult;
    }

    //捕获 Exception异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception){
        LOGGER.error("catch exception : {}\r\nexception: ",exception.getMessage(),exception);
        if (EXCEPTIONS == null){
            EXCEPTIONS = builder.build();
        }
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null){
            return new ResponseResult(resultCode);
        }else {
            //返回999异常
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }


    }
}
