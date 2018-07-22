package com.hjp.javaSource.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangjp 2018/7/21 20:35
 * i++这种操作是非原子的，而使用原子对象可以保证++操作的原子性。
 **/
public class Atomicity {

    private static volatile int nonAtomicCounter = 0;

    private static volatile AtomicInteger atomicCounter = new AtomicInteger();

    private static int times = 0;

    public static void caculate(){

        times++;
        for (int i=0; i<1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    nonAtomicCounter++;
                    atomicCounter.incrementAndGet();
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
    }

    public static void main(String[] args) {
        caculate();
        while (nonAtomicCounter == 1000){
            nonAtomicCounter = 0;
            atomicCounter.set(0);
            caculate();
        }

        System.out.println("Non-atomic counter: " + times + ":" + nonAtomicCounter);
        System.out.println("Atomic counter: " + times + ":" + atomicCounter);
    }
}
/*
    Output :
    Non-atomic counter: 20:999
    Atomic counter: 20:1000
 */
//Non-atomic counter的值经常小于1000，说明++是非原子的。