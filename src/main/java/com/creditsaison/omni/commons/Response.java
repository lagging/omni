package com.creditsaison.omni.commons;


import com.creditsaison.omni.util.exception.ErrorCode;

import java.beans.ConstructorProperties;

public class Response<T> {
    private int statusCode;
    private ErrorCode errorCode;
    protected T data;

    private String statusMessage;
    private long serverTime = System.currentTimeMillis();

    public Response(int statusCode, String statusMessage) {
        this.setStatusCode(statusCode);
        this.setStatusMessage(statusMessage);
    }

    public Response(int statusCode,ErrorCode errorCode, String statusMessage) {
        this.setErrorCode(errorCode);
        this.setStatusCode(statusCode);
        this.setStatusMessage(statusMessage);
    }

    public Response(int statusCode, T data) {
        this.setStatusCode(statusCode);
        this.setData(data);
    }

    @ConstructorProperties({"statusCode", "data", "statusMessage"})
    public Response(int statusCode, T data, String statusMessage) {
        this.statusCode = statusCode;
        this.data = data;
        this.statusMessage = statusMessage;
    }

    public Response() {
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public T getData() {
        return this.data;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }
}

