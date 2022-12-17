package com.creditsaison.omni.commons;

public interface ConsumerThrowsException<T, E extends Throwable> {
    void accept(T var1) throws E;
}

