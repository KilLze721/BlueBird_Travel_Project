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

    /**
     * 构建成功响应结果，仅包含消息
     * @param msg 响应消息
     * @param <T> 数据类型
     * @return 包含消息的成功响应结果
     */
    public static <T> Result<T> success(String msg) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg(msg);
        return r;
    }

    /**
     * 构建成功响应结果，包含数据
     * @param data 响应数据
     * @param <T> 数据类型
     * @return 包含数据的成功响应结果
     */
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    /**
     * 构建错误响应结果
     * @param error 错误消息
     * @param <T> 数据类型
     * @return 包含错误信息的响应结果
     */
    public static <T> Result<T> error(String error) {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setMsg(error);
        return r;
    }
}