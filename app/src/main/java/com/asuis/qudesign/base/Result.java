package com.asuis.qudesign.base;

/**
 * Created by 15988440973 on 2018/1/9.
 * desciption:
 */

public class Result<T> {
    private T data;
    private String code;
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
