package com.dream.blog.commom.utils;

import com.alibaba.fastjson.annotation.JSONField;
import com.dream.blog.commom.enums.ResponseCode;

import java.io.Serializable;

/**
 * =======================
 * 类名: Result
 * 描述：
 * 作者：dream colors
 * 日期：2020/7/15 0:28
 * 版本：1.0
 * =======================
 **/
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -4577255781088498763L;

    //  是否成功
    private Boolean success;

    // 响应状态
    private Integer code;

    // 响应消息
    private String message;

    // 响应数据
    private T data;

    private ResponseResult() {
    }

    private ResponseResult(Integer code, Boolean success) {
        this.code = code;
        this.success = success;
    }

    private ResponseResult(Integer code, String msg, Boolean success) {
        this.code = code;
        this.message = msg;
        this.success = success;
    }

    private ResponseResult(Integer code, T data, Boolean success) {
        this.code = code;
        this.data = data;
        this.success = success;
    }

    private ResponseResult(Integer code, String msg, T data, Boolean success) {
        this.code = code;
        this.message = msg;
        this.data = data;
        this.success = success;
    }

    // @JsonIgnore  // jackson
    @JSONField(serialize = false)
    public boolean isSuccess() {
        return this.code.equals(ResponseCode.SUCCESS.getCode());
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Boolean getSuccess () {
        return success;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(), true);
    }

    public static <T> ResponseResult<T> success(String msg) {
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(), msg, true);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(), data, true);
    }

    public static <T> ResponseResult<T> success(String msg, T data) {
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(), msg, data, true);
    }

    public static <T> ResponseResult<T> error() {
        return new ResponseResult<T>(ResponseCode.ERROR.getCode(), false);
    }

    public static <T> ResponseResult<T> error(String errorMessage) {
        return new ResponseResult<T>(ResponseCode.ERROR.getCode(), errorMessage, false);
    }

    public static <T> ResponseResult<T> error(T data) {
        return new ResponseResult<>(ResponseCode.ERROR.getCode(), data, false);
    }

    public static <T> ResponseResult<T> error(Integer code, String errorMessage) {
        return new ResponseResult<>(code, errorMessage, false);
    }

    public static <T> ResponseResult<T> error(Integer code, String msg, T data) {
        return new ResponseResult<>(code, msg, data, false);
    }
}
