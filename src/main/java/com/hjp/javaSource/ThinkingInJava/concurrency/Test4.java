package com.hjp.javaSource.ThinkingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjp 2018-02-09 09:26
 **/
public class Test4 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0 ; i < 5; i++){
            exec.execute(new Test2(i));
        }
        Thread.yield();
        exec.shutdown();
    }
}
