package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.util.concurrent.*;

/**
 * @author huangjp 2018/7/22 14:56
 * 创建线程
 **/
public class CreateAThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new RunnableDemo()).start();
        new ThreadDemo().start();
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> fs = exec.submit(new CallableDemo());
        exec.shutdown();
        System.out.println("任务是否执行完成：" + fs.isDone());
        System.out.println("返回值为：" + fs.get());
    }
}
/*
Output :
    Thread Demo
    Runnable Demo
    任务是否执行完成：true
    返回值为：执行成功
 */

class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable Demo");
    }
}

class ThreadDemo extends Thread{
    @Override
    public void run() {
        System.out.println("Thread Demo");
    }
}

class CallableDemo implements Callable<String>{
    @Override
    public String call(){
        return "执行成功";
    }
}