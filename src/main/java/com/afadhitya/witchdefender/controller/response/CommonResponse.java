package com.afadhitya.witchdefender.controller.response;

public class CommonResponse<T> {
    private T data;
    private Integer statusCode;

    public CommonResponse(T data, Integer statusCode) {
        this.data = data;
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
