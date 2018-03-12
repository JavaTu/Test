package com.hjp.javaSource.ThinkingInJava.concurrency;

import java.util.Random;

/**
 * @author huangjp 2018-02-09 10:46
 * 线程：sleep()
 **/
public class Test6{

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        long i = random.nextInt(10);

        for (int j = 0 ; j < 5; j++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run");
                }
            });
            System.out.println("sleep " + i + "秒");
            Thread.sleep(i);
        }
    }
}
