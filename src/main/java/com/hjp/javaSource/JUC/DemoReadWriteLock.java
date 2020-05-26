package com.hjp.javaSource.JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: DemoReadWriteLock
 * @Description: 读写锁：增加读的效率，并且防止脏读
 * @Author: huangjp
 * @Date: 2020/5/20 16:07
 */
public class DemoReadWriteLock {

    public static void main(String[] args) {

        ReadWriteLock lock = new ReentrantReadWriteLock();
        ReadWriteManage manage = new ReadWriteManage(lock.readLock(), lock.writeLock());

        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(new Thread(() -> manage.write("写1")));
        for (int i=0; i<4; i++){
            pool.execute(new Thread(() -> manage.read()));
        }
        pool.execute(new Thread(() -> manage.write("写2")));
        for (int i=0; i<4; i++){
            pool.execute(new Thread(() -> manage.read()));
        }
        pool.shutdown();
    }
}

class ReadWriteManage {

    private String value = "我是初始值";

    private Lock readLock;

    private Lock writeLock;

    public ReadWriteManage(Lock readLock, Lock writeLock) {
        this.readLock = readLock;
        this.writeLock = writeLock;
    }

    String read () {
        String result;
        try {
            readLock.lock();
            System.out.println("线程：" + Thread.currentThread().getName() + "来读了！！！");
            result = value;
            Thread.sleep(1000);
            System.out.println("线程：" + Thread.currentThread().getName() + "读到了！！！");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            readLock.unlock();
        }
        return result;
    }

    void write (String newValue) {
        try {
            writeLock.lock();
            System.out.println("线程：" + Thread.currentThread().getName() + "来写了！！！");
            value = newValue;
            Thread.sleep(1000);
            System.out.println("线程：" + Thread.currentThread().getName() + "写完了！！！");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
