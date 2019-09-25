package com.hjp.javaSource.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用5个线程实现1+2+3+...+100 = 5050
 * 使用了CountDownLatch能够使一个或多个线程等待其他线程完成各自的工作后再执行，每次调用countDown()后减1
 * 参考：https://www.cnblogs.com/liun1994/p/7396026.html
 * https://www.jianshu.com/p/da9d051dcc3d
 * @author huangjp 2019/9/25 11:35 AM
 **/
public class CountDownLatchTest {

    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger result = new AtomicInteger(0);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(5);

        for (int i=0; i<5; i++){
            System.out.println(String.valueOf(i));
            pool.execute(() -> {
                for (int j=0; j<20; j++){
                    count.incrementAndGet();
                    result.addAndGet(count.get());
                }
                latch.countDown();
            });
        }

        pool.shutdown();
        System.out.println(count);
        System.out.println(result);
    }
}
