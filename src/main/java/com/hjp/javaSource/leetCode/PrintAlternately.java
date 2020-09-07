package com.hjp.javaSource.leetCode;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName: PrintAlternately
 * @Description:
 *
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: huangjp
 * @Date: 2020/9/7 13:49
 */
public class PrintAlternately {

    public static void main(String[] args) {
        Executor pool = Executors.newFixedThreadPool(2);
        FooBar fooBar = new FooBar(3);
        pool.execute(() -> {
            try {
                fooBar.foo(()-> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

class FooBar {

    private int n;

    private boolean isFoo = true;

    private Object lock = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock){
                while (!isFoo){
                    lock.wait();
                }
                printFoo.run();
                isFoo = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock){
                while (isFoo){
                    lock.wait();
                }
                printBar.run();
                isFoo = true;
                lock.notifyAll();
            }
        }
    }
}
