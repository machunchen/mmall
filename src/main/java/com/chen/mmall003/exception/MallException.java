package com.chen.mmall003.exception;

import com.chen.mmall003.enums.ResultEnum;

/**
 * unchecked 不用去处理，交给JVM去处理，继承 RuntimeException
 * checked，需要自己处理，继承 Exception
 */
public class MallException extends RuntimeException {
    public MallException(String error) {
        super(error);
    }
    public MallException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }
}
