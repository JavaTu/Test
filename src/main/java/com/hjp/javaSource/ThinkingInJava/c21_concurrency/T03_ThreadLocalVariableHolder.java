package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author huangjp 2018/7/23 20:12
 * 线程本地存储：ThreadLocal
 **/
public class T03_ThreadLocalVariableHolder {

    private static ThreadLocal<Integer> value =
            new ThreadLocal<Integer>() {
                protected synchronized Integer initialValue() {
                    return 1;
                }
            };

    static void increment(){
        value.set(value.get()+1);
    }

    static int get(){
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i<5; i++) exec.execute(new AThread());
        TimeUnit.SECONDS.sleep(3);
        exec.shutdown();
    }
}

class AThread implements Runnable{

    @Override
    public void run() {
        T03_ThreadLocalVariableHolder.increment();
        System.out.println(Thread.currentThread().getName() + "'s value = " + T03_ThreadLocalVariableHolder.get());
    }
}

/*Output :
pool-1-thread-1's value = 2
pool-1-thread-2's value = 2
pool-1-thread-3's value = 2
pool-1-thread-4's value = 2
pool-1-thread-5's value = 2
 */
