package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjp 2018/7/22 0022 17:08
 **/
public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i=0; i<5; i++) singleThreadExecutor.execute(new LiftOff());
        singleThreadExecutor.shutdown();
    }
}
/*
Output :

    #0(4), #0(3), #0(2), #0(1), #0(liftoff!),
    #1(4), #1(3), #1(2), #1(1), #1(liftoff!),
    #2(4), #2(3), #2(2), #2(1), #2(liftoff!),
    #3(4), #3(3), #3(2), #3(1), #3(liftoff!),
    #4(4), #4(3), #4(2), #4(1), #4(liftoff!),
 */