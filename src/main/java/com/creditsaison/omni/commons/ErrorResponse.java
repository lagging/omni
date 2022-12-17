package com.creditsaison.omni.commons;


import com.creditsaison.omni.util.exception.ErrorCode;

public final class ErrorResponse<T> extends Response<T> {

    public ErrorResponse(String message) {
        super(0, message);
    }

    public ErrorResponse(ErrorCode errorCode, String message) {
        super(0,errorCode, message);
    }

    public ErrorResponse(T message) {
        super(0, message);
    }

    public ErrorResponse() {
        super(0, "error");
    }
}

