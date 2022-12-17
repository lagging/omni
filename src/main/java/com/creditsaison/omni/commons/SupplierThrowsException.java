package com.creditsaison.omni.commons;

public interface SupplierThrowsException<T, E extends Throwable> {
    T get() throws E;
}
