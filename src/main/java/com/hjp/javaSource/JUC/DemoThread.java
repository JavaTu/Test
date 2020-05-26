package com.hjp.javaSource.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * @author huangjp 2020/5/18 9:28 PM
 **/
public class DemoThread {

    public static void main(String[] args) {

        // Exchanger 两两交换
        /*Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            String s = "s1";
            try {
                exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1，" + s);
        }).start();

        new Thread(()->{
            String s = "s2";
            try {
                exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2，" + s);

        }).start();*/

        // CountDownLatch 计数器
        CountDownLatch latch = new CountDownLatch(20);
        latch.countDown();



    }
}
