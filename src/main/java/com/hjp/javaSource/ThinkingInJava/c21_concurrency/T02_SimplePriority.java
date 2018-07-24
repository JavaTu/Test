package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjp 2018/7/23 14:13
 * 多线程：优先级的简单应用
 **/
public class T02_SimplePriority implements Runnable{

    private int priority;

    private int countdown = 5;

    private volatile double d;

    public T02_SimplePriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":  " + countdown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true){
            for (long i=0; i<100000000; i++){
                d += (Math.PI + Math.E)/(double) i;
                if (i % 10000 == 0) Thread.yield();
            }
            System.out.println(this);
            if (--countdown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new T02_SimplePriority(Thread.MIN_PRIORITY));
        exec.execute(new T02_SimplePriority(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
/*Output :
Thread[pool-1-thread-1,1,main]:  5
Thread[pool-1-thread-2,10,main]:  5
Thread[pool-1-thread-2,10,main]:  4
Thread[pool-1-thread-1,1,main]:  4
Thread[pool-1-thread-2,10,main]:  3
Thread[pool-1-thread-1,1,main]:  3
Thread[pool-1-thread-2,10,main]:  2
Thread[pool-1-thread-1,1,main]:  2
Thread[pool-1-thread-2,10,main]:  1
Thread[pool-1-thread-1,1,main]:  1
 */