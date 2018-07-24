package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * @author huangjp 2018/7/23 16:23
 * 捕获未捕到的异常：
 * 当run()方法中抛出一个异常的时候，main方法无法捕捉该异常，为了解决这个问题，推出了Thread.uncaughtExceptionHandler接口。
 * 使用Thread.setUncaughtExceptionHandler(UncaughtExceptionHandler eh)可以给线程增加一个异常处理器。
 * Thread.UncaughtExceptionHandler.uncaughtException()会在线程因未捕捉的异常而临近死亡时被调用。
 **/
public class T02_CaptrueUncaughtException {
    public static void main(String[] args) {
        HandlerThreadFactory factory = new HandlerThreadFactory();
        Thread thread = factory.newThread(new ExceptionThread());
        thread.start();
    }
}

class ExceptionThread implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return thread;
    }
}
/*Output :
caught java.lang.RuntimeException
 */