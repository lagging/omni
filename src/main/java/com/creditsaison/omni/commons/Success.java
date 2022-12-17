package com.creditsaison.omni.commons;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Success<T> implements Try<T> {
    private T object;

    public Success(T t) {
        this.object = t;
    }

    public boolean isSuccess() {
        return true;
    }

    public boolean isFailure() {
        return false;
    }

    public T get() {
        return this.object;
    }

    public <R> Try<R> map(Function<? super T, R> fn) {
        Objects.requireNonNull(fn);

        try {
            return new Success(fn.apply(this.object));
        } catch (Throwable var3) {
            return new Failure(var3);
        }
    }

    public <R> Try<R> flatMap(Function<? super T, Try<R>> function) {
        Objects.requireNonNull(function);

        try {
            return (Try) function.apply(this.object);
        } catch (Throwable var3) {
            return new Failure(var3);
        }
    }

    public void forEach(Consumer<? super T> fn) {
        fn.accept(this.object);
    }

    public void forEachFailure(Consumer<Throwable> fn) {
    }

    public <R> Try<R> recover(Function<Throwable, R> fn) {
        return (Try<R>) this;
    }

    public <R> Try<R> recoverMap(Function<Throwable, Try<R>> function) {
        return (Try<R>) this;
    }
}

