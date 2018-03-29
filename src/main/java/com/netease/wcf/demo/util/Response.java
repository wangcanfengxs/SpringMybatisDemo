package com.netease.wcf.demo.util;

public class Response {
    String message;
    boolean result;
    int code;

    public Response(String message, boolean result, int code) {
        super();
        this.message = message;
        this.result = result;
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

}
