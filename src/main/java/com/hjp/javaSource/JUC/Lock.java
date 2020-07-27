package com.hjp.javaSource.JUC;

/**
 * @author huangjp 2018/7/21 21:00
 * 此例子可以反映对一个锁竞争的现象，结合这个例子，理解下面这两条，就可以很容易理解synchronized关键字的使用：
 * ● 非静态方法使用synchronized修饰，相当于synchronized(this)。
 * ● 静态方法使用synchronized修饰，相当于synchronized(Lock.class)。
 * 不理解！
 **/
public class Lock {

    private static Object o = new Object();

    static Lock lock = new Lock();

    private static void sleepSilently(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //非静态方法使用synchronized修饰
    public synchronized void dynamicMethod(){
        System.out.println("dynamic method");
        sleepSilently(2000);
    }

    //静态方法使用synchronized修饰
    public static synchronized void staticMethod(){
        System.out.println("static method");
        sleepSilently(2000);
    }

    //synchronized(this)
    public void thisBlock(){
        synchronized (this){
            System.out.println("this block");
            sleepSilently(2000);
        }
    }

    //synchronized(object)
    public void objectBlock(){
        synchronized (o){
            System.out.println("object block");
            sleepSilently(2000);
        }
    }

    //静态方法synchronized(Lock.class)
    public static void classBlock(){
        synchronized (Lock.class){
            System.out.println("static block");
            sleepSilently(2000);
        }
    }

    public static void main(String[] args) {
        //object lock test
        new Thread(){
            @Override
            public void run() {
                lock.dynamicMethod();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                lock.objectBlock();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                lock.thisBlock();
            }
        }.start();

        sleepSilently(3000);
        System.out.println("");

        //class lock test
        new Thread(){
            @Override
            public void run() {
                lock.staticMethod();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                lock.classBlock();
            }
        }.start();

    }
}
