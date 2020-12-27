package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @author:dashuai
 * @ClassName:ExceptionCast
 * @Descirption: 异常抛出类
 * @date:2020/12/27 16:17
 */
public class ExceptionCast {

    //使用静态方法抛出自定义异常
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
