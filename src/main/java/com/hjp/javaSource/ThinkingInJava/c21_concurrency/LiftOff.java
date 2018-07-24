package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

/**
 * @author huangjp 2018/7/19 14:46
 * 发射前的倒计时
 * 定义任务：输出结果中，先输出了'main方法结束'再输出线程run的内容，说明了main方法与run方法处于两个不同的线程，
 * run()是由不同的线程去执行的，因此程序可以同时运行这两个方法，所以才会产生这样的结果
 **/
public class LiftOff extends Thread{

    private int countDown = 5;

    private static int taskCount = 0;

    private final int id = taskCount++;

    @Override
    public void run() {
        System.out.println("");
        while (countDown-- > 0){
            System.out.print(status());
        }
    }

    private String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : "liftoff!") + "), ";
    }

    public static void main(String[] args) {
        new Thread(new LiftOff()).start();
        System.out.println("main方法结束...");
    }
}
/*
    Output :
    main方法结束...
    #0(4), #0(3), #0(2), #0(1), #0(liftoff!),
 */