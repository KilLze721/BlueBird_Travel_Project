package com.bird.bluebirdproject.common;

import lombok.Data;

/**
 * 通用返回结果类
 */
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success(String msg) {
        Result<T> r = new Result<>();
        r.setCode(0);
        r.setMsg(msg);
        return r;
    }

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    public static <T> Result<T> error(String error) {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setMsg(error);
        return r;
    }
}