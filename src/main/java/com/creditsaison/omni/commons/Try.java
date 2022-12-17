package com.creditsaison.omni.commons;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Try<T> {
    boolean isSuccess();

    boolean isFailure();

    T get();

    <R> Try<R> map(Function<? super T, R> var1);

    <R> Try<R> flatMap(Function<? super T, Try<R>> var1);

    <R> Try<R> recover(Function<Throwable, R> var1);

    <R> Try<R> recoverMap(Function<Throwable, Try<R>> var1);

    void forEach(Consumer<? super T> var1);

    void forEachFailure(Consumer<Throwable> var1);

    static <T> Try<T> with(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        SupplierThrowsException<T, Throwable> supplierThrowsException = supplier::get;
        return withThrowable(supplierThrowsException);
    }

    static <T, E extends Throwable> Try<T> withThrowable(SupplierThrowsException<T, E> ste) {
        Objects.requireNonNull(ste);

        try {
            return new Success(ste.get());
        } catch (Throwable var2) {
            return new Failure(var2);
        }
    }

    static <T, E extends Throwable> Try<T> withThrowable(ConsumerThrowsException<T, E> ste, T t) {
        Objects.requireNonNull(ste);
        SupplierThrowsException supplierWithException = () -> {
            ste.accept(t);
            return t;
        };

        try {
            return new Success(supplierWithException.get());
        } catch (Throwable var4) {
            return new Failure(var4);
        }
    }

    static <T> Try<T> with(Consumer<T> fn, T t) {
        Objects.requireNonNull(fn);
        Supplier<T> supplier = () -> {
            fn.accept(t);
            return t;
        };
        return with(supplier);
    }
}

