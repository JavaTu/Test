package com.hjp.javaSource.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: JUC.DemoCyclicBarrier
 * @Description: 循环的障碍物（篱栅），满人就发车
 * @Author: huangjp
 * @Date: 2020/5/19 17:12
 * 参考：https://www.jianshu.com/p/333fd8faa56e
 */
public class DemoCyclicBarrier {

    public static void main(String[] args) {

        System.out.println("司机已到位，还要等五个人上车...");

        CyclicBarrier barrier = new CyclicBarrier(6, () -> System.out.println("人满了，发车咯"));

        ExecutorService personPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++){
            personPool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getId() + "已上车，进入等待...");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        personPool.shutdown();

        // 主线程的await要放在后面，防止线程执行到一半阻塞导致子线程无法执行成功
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("开车~");
    }
}
