package com.hjp.javaSource.JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * @ClassName: DemoPharse
 * @Description: 移相器，指定线程分阶段执行任务
 * @Author: huangjp
 * @Date: 2020/5/19 16:38
 */
public class DemoPhaser {

    public static void main(String[] args) {

        int personNum = 4;  // 四个人来参加宴会
        Wedding phaser = new Wedding(); // 婚宴分阶段进行
        phaser.bulkRegister(personNum); // 注册四个人，代表这四个人要一起行动，直到完成任务或者自己主动arriveAndDeregister(解除注册)后方可单独行动
        ExecutorService personPool = Executors.newFixedThreadPool(personNum);
        personPool.submit(new Person("张三", phaser));
        personPool.submit(new Person("李四", phaser));
        personPool.submit(new Person("王五", phaser));
        personPool.submit(new Person("赵六", phaser));
        personPool.shutdown();
    }
}

// 分阶段执行任务，婚宴例子，入场-吃饭-散场
class Wedding extends Phaser {

    /**
     * 大家都arrive(到达)之后执行的方法
     * @param phase
     * @param registeredParties
     * @return
     */
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){     // phase 当前到第几阶段了，没有限定。
            case 0:
                System.out.println("大家都到齐了，准备开饭！");
                System.out.println();
                return false;   // false代表阶段还未结束，true代表结束
            case 1:
                System.out.println("大家都吃完了，准备散场！");
                System.out.println();
                return false;
            case 2:
                System.out.println("各回各家啦");
                System.out.println();
                return true;
            default:
                return true;
        }
    }
}

// 对象：宾客
class Person implements Runnable {

    private String name;

    private Phaser phaser;

    public Person(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    public void present () {
        System.out.println(name + "已入场，等待吃饭！");
        phaser.arriveAndAwaitAdvance();
    }

    public void eat () {
        System.out.println(name + "吃完了，等待散场！");
        if (name.equals("张三") || name.equals("李四")){
            phaser.arriveAndAwaitAdvance();
        }else {
            phaser.arriveAndDeregister();
        }

    }

    // 张三和李四一起坐车回家
    public void over () {
        if (name.equals("张三") || name.equals("李四")){
            System.out.println(name + "上车了，等待发车！");
            phaser.arriveAndDeregister();
        }else {
            System.out.println(name + "自己有车，先走了！");
        }
    }

    @Override
    public void run() {

        present();

        eat();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        over();

    }
}
