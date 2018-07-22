package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

/**
 * @author huangjp 2018/7/19 14:46
 * 定义任务：输出结果中，先输出了'main方法结束'再输出线程run的内容，说明了main方法与run方法处于两个不同的线程，run方法是由不同的线程去执行的，因此程序可以同时运行这两个方法，所以才会产生这样的结果
 **/
public class T01_Thread extends Thread{

    private int countDown = 5;

    private static int taskCount = 0;

    private final int id = taskCount++;

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
        }
    }

    private String status(){
        return "Thread#" + id + "(" + (countDown > 0 ? countDown : "liftoff!") + "), ";
    }

    public static void main(String[] args) {
        for (int i=0; i<2; i++) new Thread(new T01_Thread()).start();
        for (int j=0; j<2; j++) new Thread(new T01_Runnable()).start();
        System.out.println("main方法结束...");
    }
}
/*
Output :
Thread#0(4), Thread#1(4), Thread#1(3), Thread#0(3), Thread#0(2), Thread#0(1), Thread#0(liftoff!), Thread#1(2), Thread#1(1), Thread#1(liftoff!),main方法结束...
Runnable#0(4), Runnable#1(4), Runnable#0(3), Runnable#1(3), Runnable#0(2), Runnable#1(2), Runnable#0(1), Runnable#1(1), Runnable#0(liftoff!), Runnable#1(liftoff!),
 */

class T01_Runnable implements Runnable{

    private int countDown = 5;

    private static int taskCount = 0;

    private final int id = taskCount++;

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
        }
    }

    private String status(){
        return "Runnable#" + id + "(" + (countDown > 0 ? countDown : "liftoff!") + "), ";
    }
}