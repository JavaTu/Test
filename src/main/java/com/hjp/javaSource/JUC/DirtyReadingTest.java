package com.hjp.javaSource.JUC;

import java.math.BigDecimal;

/**
 * @ClassName: JUC.DirtyReadingTest
 * @Description: 脏读重现
 * @Author: huangjp
 * @Date: 2020/5/18 17:01
 */
public class DirtyReadingTest {

    public static void main(String[] args) {

        // 操作同一个账户
        Account account = new Account();
        account.setId(1L);
        account.setMoney(new BigDecimal(100));

        // 写加锁，读不加锁，导致脏读
        // 怎么解决？不使用全局变量Account，改为变量
        // 实际工作中这部分在数据库层面解决了。
        /*new Thread(()->{
            synchronized (account){
                System.out.println("Start");
                account.setMoney(account.getMoney().add(new BigDecimal(100)));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            }
        }).start();

        new Thread(()-> System.out.println(account.getMoney())).start();*/

        // 也有脏读风险
        /*new Thread(()->{
            ReentrantLock lock = new ReentrantLock();
            try {
                lock.lock();
                System.out.println("写开始");
                account.setMoney(account.getMoney().add(new BigDecimal(100)));
                System.out.println("写好了，开始睡1s");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("写睡完了");
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(()-> {
            System.out.println("读开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("读睡好了");
            System.out.println(account.getMoney());
        }).start();*/

    }
}

class Account {

    Long id;

    BigDecimal money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
