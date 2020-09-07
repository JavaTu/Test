package com.hjp.javaSource.leetCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @ClassName: PrintZeroEvenOdd
 * @Description:
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 * 示例：
 * 输入：n = 5
 * 输出："0102030405"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: huangjp
 * @Date: 2020/9/7 14:08
 */
public class PrintZeroEvenOdd {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        pool.execute(() -> {
            try {
                zeroEvenOdd.zero((num) -> System.out.print(num));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(() -> {
            try {
                zeroEvenOdd.even((num) -> System.out.print(num));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(() -> {
            try {
                zeroEvenOdd.odd((num) -> System.out.print(num));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }

}

class ZeroEvenOdd {

    private int n;

    private AtomicInteger num = new AtomicInteger(1);

    private boolean isZero = true;

    private Object lock = new Object();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0; i<n; i++){
            synchronized (lock){
                while (!isZero){
                    lock.wait();
                }
                printNumber.accept(0);
                isZero = false;
                lock.notifyAll();
            }
        }
        System.out.println("zero stop");
    }

    // 偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=0; i<n/2; i++){
            synchronized (lock){
                while (isZero || num.get()%2 != 0){
                    lock.wait();
                }
                printNumber.accept(num.intValue());
                num.incrementAndGet();
                isZero = true;
                lock.notifyAll();
            }
        }
        System.out.println("even stop");
    }

    // 奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        int count = n%2 == 0 ? n/2 : n/2+1;
        for (int i=0; i<count; i++){
            synchronized (lock){
                while (isZero || num.get()%2 == 0){
                    lock.wait();
                }
                printNumber.accept(num.intValue());
                num.incrementAndGet();
                isZero = true;
                lock.notifyAll();
            }
        }
        System.out.println("odd stop");
    }
}