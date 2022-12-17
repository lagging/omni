package com.creditsaison.omni.commons;

public final class SuccessResponse<T> extends Response<T> {
    public SuccessResponse(T data) {
        super(1, data);
    }
}