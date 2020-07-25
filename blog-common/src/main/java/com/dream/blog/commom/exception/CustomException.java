package com.dream.blog.commom.exception;

import java.io.Serializable;

/**
 * =======================
 * 类名: CustomerException
 * 描述：
 * 作者：dream colors
 * 日期：2020/7/15 0:51
 * 版本：1.0
 * =======================
 **/
public class CustomException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;
    private String msg;
    private int code = 500;

    public CustomException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CustomException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CustomException(int code,String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CustomException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
