package com.hjp.javaSource.ThinkingInJava.concurrency;

/**
 * @author huangjp 2018-02-08 16:15
 **/
public class Test1 implements Runnable{

    private static int taskCount;

    private final int id = taskCount++;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++){
            System.out.println("task 1...ID = " + id);
            Thread.yield();
            System.out.println("task 2...ID = " + id);
            Thread.yield();
            System.out.println("task 3...ID = " + id);
            Thread.yield();
        }
    }

    public Test1() {
        System.out.println("task start, ID = " + id);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            new Thread(new Test1()).start();
        }
    }
}
