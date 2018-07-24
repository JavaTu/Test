package com.hjp.javaSource.ThinkingInJava.c21_concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangjp 2018/7/23 22:13
 * 如何解决同步块无法中断的问题？
 * 使用Lock。
 **/
public class T04_SynchronizedBlock2 implements Runnable{

    private Lock lock = new ReentrantLock();

    public T04_SynchronizedBlock2() {
        lock.lock();
    }

    private synchronized void f(){
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println("f()方法被中断");
        }
    }

    @Override
    public void run() {
        System.out.println("开始执行run()");
        f();
        System.out.println("执行结束");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new T04_SynchronizedBlock2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
/*Output :
开始执行run()
f()方法被中断
执行结束
 */