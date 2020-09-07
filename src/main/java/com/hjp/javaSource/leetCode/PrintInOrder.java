package com.hjp.javaSource.leetCode;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: PrintInOrder
 * @Description: 来源 leetCode 多线程题库
 * @Author: huangjp
 * @Date: 2020/9/7 11:48
 */
public class PrintInOrder {
    public static void main(String[] args) {
        Executor pool = Executors.newFixedThreadPool(3);
        Foo foo = new Foo();
        pool.execute(()->foo.first(()-> System.out.print("first")));
        pool.execute(()->foo.third(()-> System.out.print("third")));
        pool.execute(()->foo.second(()-> System.out.print("second")));
    }
}

class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) {

        while (firstJobDone.get() != 1){

        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) {

        while (secondJobDone.get() != 1){

        }

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
