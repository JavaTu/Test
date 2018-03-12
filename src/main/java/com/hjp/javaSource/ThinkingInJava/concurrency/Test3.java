package com.hjp.javaSource.ThinkingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjp 2018-02-08 16:55
 **/
public class Test3{

    public static void main(String[] args) {
        //cache
        ExecutorService cache = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            cache.execute(new Test1());
        }
        Thread.yield();
        cache.shutdown();
        //fix
        ExecutorService fix = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++){
            fix.execute(new Test1());
        }
        Thread.yield();
        fix.shutdown();
        //single
        ExecutorService single = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++){
            single.execute(new Test1());
        }
        Thread.yield();
        single.shutdown();
    }
}
