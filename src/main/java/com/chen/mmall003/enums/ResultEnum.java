package com.chen.mmall003.enums;

import lombok.Getter;

/**
 * 枚举
 * code 错误代码
 * msg 错误信息
 */
@Getter
public enum ResultEnum {
    STOCK_ERROR(1,"库存不足");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
