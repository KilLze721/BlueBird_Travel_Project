package com.bird.bluebirdproject.common;

/**
 * 通用返回结果类
 */
public class Result {
    private Integer code; // 状态码
    private String message; // 返回信息
    private Object data; // 数据

    public Result() {}

    public static Result success(Object data) {
        Result result = new Result();
        result.code = 200;
        result.message = "success";
        result.data = data;
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.code = 500;
        result.message = message;
        return result;
    }

    // Getters and Setters
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}