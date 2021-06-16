package com.hjp.javaSource.JUC;

import java.util.concurrent.Callable;

/**
 * 并发执行有返回值且有入参的线程
 * @param <P>
 * @param <V>
 */
public abstract class DemoCallable<P, V> implements Callable<V> {

    // 入参
    private final P param;

    public DemoCallable(P param) {
        this.param = param;
    }

    protected abstract V execute (P param);

    @Override
    public V call() {
        return execute(param);
    }
}
