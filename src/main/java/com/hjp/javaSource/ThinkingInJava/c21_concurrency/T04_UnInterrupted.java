package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author huangjp 2018/7/23 21:15
 * 不可被中断的线程类型：IO、同步块
 * 针对IO这种情况：第18章的NIO提供了更人性化的I/O中断。
 * 针对同步字段这种情况：可以使用Lock，Lock提供了更人性化的lockInterruptibly()方法，这样同步块中的线程也能被中断。
 **/
public class T04_UnInterrupted {

    public static void main(String[] args) throws InterruptedException {
        test(new IOBlock(System.in));
        test(new SynchronizedBlock());
        TimeUnit.SECONDS.sleep(3);
        System.exit(0);
    }

    static void test(Runnable r) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);   //一定要加上这个，否则还没进入run()方法就终止了。
        System.out.println("开始给"+r.getClass().getName()+"发送中断命令");  //始终无法终止
        f.cancel(true);
    }
}
/*Output :
IOBlock 运行开始
开始给com.hjp.javaSource.ThinkingInJava.c21_concurrency.IOBlock发送中断命令
SynchronizedBlock 运行开始
开始给com.hjp.javaSource.ThinkingInJava.c21_concurrency.SynchronizedBlock发送中断命令
 */

class IOBlock implements Runnable{

    private InputStream in;

    IOBlock(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        System.out.println("IOBlock 运行开始");
        try {
            in.read();
        } catch (IOException e) {
            System.out.println("IO读取失败");
        }
        System.out.println("IOBlock 运行结束");
    }
}

class SynchronizedBlock implements Runnable{

    public SynchronizedBlock() {
        new Thread(){
            @Override
            public void run() {
                f();    //死锁
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("SynchronizedBlock 运行开始");
        f();
        System.out.println("SynchronizedBlock 运行结束");
    }

    private synchronized void f(){
        while (true) Thread.yield();
    }
}
