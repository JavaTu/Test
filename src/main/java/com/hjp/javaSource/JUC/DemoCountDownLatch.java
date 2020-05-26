package com.hjp.javaSource.JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: JUC.DemoCountDownLatch
 * @Description: 计数器，类似Join，比Join灵活
 * @Author: huangjp
 * @Date: 2020/5/19 16:07
 * 参考：https://www.jianshu.com/p/e233bb37d2e6
 */
public class DemoCountDownLatch {

    public static void main(String[] args) {
        System.out.println("主线程开始执行...");

        CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程你等等啊，这里有两个子线程先执行，执行完了你再执行...");

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(() -> {
            System.out.println("插入线程一开始执行...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });

        pool.execute(() -> {
            System.out.println("插入线程二开始执行...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        pool.shutdown();

        // 主线程的await要放在后面，防止线程执行到一半阻塞导致子线程无法执行成功
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("子线程都执行完了，主线程你执行吧....");
    }
}
