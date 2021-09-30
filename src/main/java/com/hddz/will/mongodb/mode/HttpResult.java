package com.hddz.will.mongodb.mode;

public class HttpResult<T> {

    private int code;

    private T data;
    private String msg;

    public HttpResult(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;

    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}