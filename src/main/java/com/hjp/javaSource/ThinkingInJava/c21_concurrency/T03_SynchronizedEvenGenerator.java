package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangjp 2018/7/23 17:30
 * 同步的多种方式
 **/
public class T03_SynchronizedEvenGenerator {

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        System.out.println(synchronizedDemo.next());
        LockDemo lockDemo = new LockDemo();
        System.out.println(lockDemo.next());
    }
}

class SynchronizedDemo{

    private int count = 1;  //注意私有

    synchronized int next(){
        try {
            ++count;
            return count;
        }finally {
            System.out.println("Synchronized end");
        }
    }

    void synchronizedCurObject(){
        synchronized (this){
            System.out.println("synchronized 当前实例");
        }
    }

    void synchronizedClass(){
        synchronized(SynchronizedDemo.class){
            System.out.println("Synchronized 当前类，也就是同步全局");
        }
    }
}

class LockDemo{

    private Lock lock = new ReentrantLock();

    private int count = 1;

    int next(){
        lock.lock();
        try {
            return ++count;
        }finally {
            System.out.println("Lock end");
            lock.unlock();
        }
    }
}
