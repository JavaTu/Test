package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.util.concurrent.*;

/**
 * @author huangjp 2018-02-09 09:38
 **/
public class Test5 implements Callable<Integer>{

    private static int i = 0;

    private final int count = i++;

    @Override
    public Integer call() throws Exception {
        return 0;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Integer> future = exec.submit(new Test5());
        try {
            System.out.println("result = " + future.get());
        } catch (Exception e) {
            System.out.println("获取线程返回值报错，报错信息为：" + e);
        }
        /*if (future.isDone()){
            try {
                System.out.println("result = " + future.get());
            } catch (Exception e) {
                System.out.println("获取线程返回值报错，报错信息为：" + e);
            }
        }*/
    }
}
