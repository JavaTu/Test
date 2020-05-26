package com.hjp.javaSource.JUC;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ThreadTest
 * @Description: count++加锁方法
 * @Author: huangjp
 * @Date: 2020/5/18 16:00
 */
public class SimpleLockTest {

    public static void main(String[] args) {

        /*JUC.NoLock target = new JUC.NoLock();
        for (int i=0; i<5; i++){
            new Thread(target).start();
        }*/

        /*JUC.SyncLock target = new JUC.SyncLock();
        for (int i=0; i<5; i++){
            new Thread(target).start();
        }*/

        /*for (int i=0; i<5; i++){
            new Thread(new JUC.SyncLock()).start();
        }*/

        /*JUC.MyReetrantLock target = new JUC.MyReetrantLock();
        for (int i=0; i<5; i++){
            new Thread(target).start();
        }*/

    }
}

class NoLock implements Runnable{

    int count;

    @Override
    public void run() {
        count++;
        System.out.println(count);
    }
}

class SyncLock implements Runnable{

    int count;

    @Override
    public void run() {

        // 对象锁，相对于类锁来说锁更细，也就是说，如果两个对象，那么跟没加锁是一个效果，那么要怎么证明两个线程能同时进入一个方法呢？看输出
        /*synchronized (this){
            System.out.println("start:" + Thread.currentThread());
            System.out.println("end:" + Thread.currentThread());
            count++;
            System.out.println(this + "：" + count);
            System.out.println();
        }*/
        /**
         * output:
         * start:Thread[Thread-1,5,main]
         * end:Thread[Thread-1,5,main]
         * start:Thread[Thread-4,5,main]
         * end:Thread[Thread-4,5,main]
         * cn.iocoder.mall.user.application.controller.login.JUC.SyncLock@3aaa9cf2：1
         */

        // 类锁，即使两个不同的对象，也不能同时进入该方法
        synchronized (SyncLock.class){
            System.out.println("start:" + Thread.currentThread());
            count++;
            System.out.println(SyncLock.class + "：" + count);
            System.out.println("end:" + Thread.currentThread());
            System.out.println();
        }
        /**
         * output:
         * start:Thread[Thread-1,5,main]
         * class cn.iocoder.mall.user.application.controller.login.JUC.SyncLock：1
         * end:Thread[Thread-1,5,main]
         *
         * start:Thread[Thread-4,5,main]
         * class cn.iocoder.mall.user.application.controller.login.JUC.SyncLock：1
         * end:Thread[Thread-4,5,main]
         */

        // 参考：https://www.cnblogs.com/huansky/p/8869888.html，https://www.jianshu.com/p/70573cbb3d19

    }

}

class MyReetrantLock implements Runnable{

    int count;

    @Override
    public void run() {
        ReentrantLock lock = new ReentrantLock(true);
        try {
            lock.lock();
            count++;
            System.out.println(count);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
