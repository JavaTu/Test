package com.hjp.javaSource.JUC;

/**
 * @author huangjp 2018/7/20 16:28
 * 中断处于等待中的线程，会抛出InterruptedException异常
 **/
public class InterruptWait extends Thread{

    private static Object lock = new Object();

    @Override
    public void run() {
        System.out.println("start");
        synchronized (lock){    //使用wait()方法时，当前对象比较拥有他自己的监视器（来源于JDK1.8 API中对Object的wait()方法的解释）
            try {
                lock.wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new InterruptWait();
        thread.start();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
/*
Output :
start
false
true
java.lang.InterruptedException
	at java.lang.Object.wait(Native Method)
	at java.lang.Object.wait(Object.java:502)
	at com.hjp.javaSource.JUC.InterruptWait.run(InterruptWait.java:15)
 */