package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author huangjp 2018/7/23 20:58
 * 发生阻塞时终止线程的几种方式
 **/
public class T04_Interrupting {

    public static void main(String[] args) {
        //简单粗暴（不推荐）
        /*Thread thread = new Thread(new Block());
        thread.interrupt();*/

        //终止线程池下所有线程
        /*ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i<5; i++) exec.execute(new Block());
        exec.shutdownNow(); //立马终止*/

        //终止线程池下制定的线程
        ExecutorService exec1 = Executors.newCachedThreadPool();
        ArrayList<Future<?>> list = new ArrayList<>();
        for (int i = 0; i<5; i++) list.add(exec1.submit(new Block()));
        list.get(0).cancel(true);   //终止单个
        System.out.println("第一个线程是否被终止："+list.get(0).isCancelled());
        exec1.shutdown();
    }
}

class Block implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " sleep interrupted");
        }
    }
}
/*Output :
pool-1-thread-1 run
pool-1-thread-3 run
pool-1-thread-2 run
pool-1-thread-4 run
pool-1-thread-1 sleep interrupted
第一个线程是否被终止：true
pool-1-thread-5 run
 */