package com.hjp.javaSource.JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: DemoSemaphore
 * @Description: 信号灯，限流，想象成上高速前的闸口，只有那么几个，有效限流
 * @Author: huangjp
 * @Date: 2020/5/20 17:18
 */
public class DemoSemaphore {

    public static void main(String[] args) {
        Gateway gateway = new Gateway();
        ExecutorService requestPool = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++){
            requestPool.execute(new Thread(() -> gateway.receive()));
        }
        requestPool.shutdown();
    }
}

class Gateway {

    private Semaphore semaphore = new Semaphore(2, true);  // 最多并发2个线程，true代表公平锁，后来的需要排队（进入等待队列）

    void receive () {
        try {
            System.out.println("接收到请求，开始请求获得锁：" + Thread.currentThread().getName());
            semaphore.acquire();
            System.out.println("获得锁成功，开始处理请求：" + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.err.println("请求处理完毕，释放锁：" + Thread.currentThread().getName());
            semaphore.release();
        }
    }

}
