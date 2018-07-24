package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author huangjp 2018/7/23 14:43
 * 后台线程
 **/
public class T02_SimpleDeamon implements Runnable{
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + ":  " + this);
            }
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }finally {
            System.out.println("finally不总执行，是否执行取决于主线程是否结束，所以后台线程与主线程存在耦合关系");  //while(true)决定了后台线程一直循环执行，直到主线程结束，所以没有机会执行finally
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long timeout = 175;    //时间越长，输出越多，当时间为175时，后台线程刚好执行一次。
        for (int i=0; i<5; i++){
            Thread thread = new Thread(new T02_SimpleDeamon());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("All deamons started");
        TimeUnit.MILLISECONDS.sleep(timeout);
    }
}
/*Output :
All deamons started
Thread[Thread-4,5,main]:  com.hjp.javaSource.ThinkingInJava.c21_concurrency.T02_SimpleDeamon@546431f0
Thread[Thread-2,5,main]:  com.hjp.javaSource.ThinkingInJava.c21_concurrency.T02_SimpleDeamon@6f9777db
Thread[Thread-1,5,main]:  com.hjp.javaSource.ThinkingInJava.c21_concurrency.T02_SimpleDeamon@47a2a66c
Thread[Thread-0,5,main]:  com.hjp.javaSource.ThinkingInJava.c21_concurrency.T02_SimpleDeamon@3ec28870
Thread[Thread-3,5,main]:  com.hjp.javaSource.ThinkingInJava.c21_concurrency.T02_SimpleDeamon@710a3057
 */