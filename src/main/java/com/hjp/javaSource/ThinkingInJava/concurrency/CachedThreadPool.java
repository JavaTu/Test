package com.hjp.javaSource.ThinkingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjp 2018-02-08 15:57
 **/
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("newCachedThreadPool" + Math.random());
                }
            });
        }
        exec.shutdown();    //退出线程池
    }
}
