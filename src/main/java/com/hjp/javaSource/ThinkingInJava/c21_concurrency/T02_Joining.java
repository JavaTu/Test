package com.hjp.javaSource.ThinkingInJava.c21_concurrency;

/**
 * @author huangjp 2018/7/23 15:44
 * join()：谁.join()，谁先执行
 **/
public class T02_Joining {

    public static void main(String[] args) {
        Sleeper s1 = new Sleeper("Alice", 1000),
                s2 = new Sleeper("Bob", 1000);

        Joiner j1 = new Joiner("JoinerA", s1),
               j2 = new Joiner("JoinerB", s2);

        s1.interrupt();
    }
}

class Sleeper extends Thread{

    private long sleepTime;

    public Sleeper(String name, long sleepTime) {
        super(name);
        this.sleepTime = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted, isInterrupted():" + isInterrupted()); //是否被中断这个标志，在异常捕获时将被清理，所以在catch子句中，在异常被捕获的时候这个标志总是会false
        }

        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread{

    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
/*Output :
Alice was interrupted, isInterrupted():false
Alice has awakened
JoinerA join completed
Bob has awakened
JoinerB join completed
 */