package com.creditsaison.omni.commons;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Failure<T> implements Try<T> {
    private Throwable throwable;

    public Failure(Throwable throwable) {
        this.throwable = throwable;
    }

    public boolean isSuccess() {
        return false;
    }

    public boolean isFailure() {
        return true;
    }

    public T get() {
        throw new RuntimeException(this.throwable);
    }

    public <R> Try<R> map(Function<? super T, R> fn) {
        return (Try<R>) this;
    }

    public <R> Try<R> flatMap(Function<? super T, Try<R>> function) {
        return (Try<R>) this;
    }

    public void forEach(Consumer<? super T> fn) {
    }

    public void forEachFailure(Consumer<Throwable> fn) {
        fn.accept(this.throwable);
    }

    public <R> Try<R> recover(Function<Throwable, R> fn) {
        Objects.requireNonNull(fn);
        try {
            return new Success(fn.apply(this.throwable));
        } catch (Throwable var3) {
            return new Failure(var3);
        }
    }

    public <R> Try<R> recoverMap(Function<Throwable, Try<R>> fn) {
        Objects.requireNonNull(fn);
        try {
            return (Try) fn.apply(this.throwable);
        } catch (Throwable var3) {
            return new Failure(var3);
        }
    }
}

