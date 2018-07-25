package com.hjp.javaSource.ThinkingInJava.c21_concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangjp 2018/7/24 20:03
 * 线程之间的协作（合作）：给卡车涂蜡-抛光-涂蜡
 **/
public class T05_Collaboration {

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new Waxer(car));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}
/*
Output :
打蜡 抛光 打蜡 抛光 打蜡 抛光 打蜡 抛光 打蜡 抛光 打蜡 抛光 打蜡 抛光 打蜡 等待抛光被打断。
等待打蜡被打断
打蜡任务结束com.hjp.javaSource.ThinkingInJava.c21_concurrency.Car@53945e81
抛光任务结束com.hjp.javaSource.ThinkingInJava.c21_concurrency.Car@53945e81
 */

//车
class Car {

    private Lock lock = new ReentrantLock();
    private Condition c = lock.newCondition();
    private boolean waxOn = false;  //是否已被打蜡

    //打蜡
    public void waxing(){
        lock.lock();
        try {
            waxOn = true;
            c.signalAll();
        }finally {
            lock.unlock();
        }
    }

    //抛光
    public void buffing(){
        lock.lock();
        try {
            waxOn = false;
            c.signalAll();
        }finally {
            lock.unlock();
        }
    }

    //等待打蜡
    public void waitingForWax() throws InterruptedException {
        lock.lock();
        try {
            while (!waxOn){
                c.await();
            }
        }finally {
            lock.unlock();
        }
    }

    //等待抛光
    public void waitingForBuff() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn){
                c.await();
            }
        }finally {
            lock.unlock();
        }
    }

}

//涂蜡人
class Waxer implements Runnable {

    private Car car;

    public Waxer(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.print("打蜡 ");
                TimeUnit.MILLISECONDS.sleep(200);

                car.waxing();
                car.waitingForBuff();
            }
        } catch (InterruptedException e) {
            System.out.println("等待抛光被打断。");
        }
        System.out.println("打蜡任务结束"+car);
    }
}

//抛光人
class WaxOff implements Runnable{

    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                car.waitingForWax();
                System.out.print("抛光 ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffing();
            }
        } catch (InterruptedException e) {
            System.out.println("等待打蜡被打断");
        }
        System.out.println("抛光任务结束"+car);
    }
}