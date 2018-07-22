package com.hjp.javaSource.test;

/**
 * @author huangjp 2018/7/21 21:38
 * 1.和wait比较一下，为什么sleep被设计为Thread的一个静态方法（即只让当前线程sleep）？
 * 2.为什么sleep必须要传入一个时间参数，而不允许不限期地sleep？
 **/
public class Sleep extends Thread{

    @Override
    public void run() {
        System.out.println("start");
        synchronized (this) { // sleep() can use (or not) any synchronization resource
            try {
                this.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace(); // notify won't throw exception
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Sleep();
        thread.start();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
        }
        synchronized (thread) {
            System.out.println("Has sleep() released the lock!");
            thread.notify();
        }
    }
}
