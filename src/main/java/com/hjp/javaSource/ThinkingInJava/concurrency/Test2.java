package com.hjp.javaSource.ThinkingInJava.concurrency;

/**
 * @author huangjp 2018-02-09 09:17
 **/
public class Test2 implements Runnable{

    private int n = 0;

    public Test2(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("生成"+n+"个斐波那契数");
    }

    public static void main(String[] args) {
        for (int i = 0 ; i < 5; i++){
            //new Test2(i).run();
            new Thread(new Test2(i)).start();
        }
    }

    /*
     *   output:
     *   生成0个斐波那契数
         生成2个斐波那契数
         生成3个斐波那契数
         生成1个斐波那契数
         生成4个斐波那契数
     */
}   //注：new Test2(i).run();与new Thread(new Test2(i)).start();产生的结果一致，为什么要new Thread(new Test2(i)).start();这样写？
    //new Thread(new Test2(i)).start();更能体现这是一个线程。
