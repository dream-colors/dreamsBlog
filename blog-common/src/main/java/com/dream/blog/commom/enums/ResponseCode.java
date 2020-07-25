package com.dream.blog.commom.enums;

/**
 * =======================
 * 类名: ResponceCode
 * 描述：
 * 作者：dream colors
 * 日期：2020/7/15 0:35
 * 版本：1.0
 * =======================
 **/
public enum ResponseCode {

    SUCCESS(200),
    ERROR(500);

    private Integer code;

    ResponseCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
