package com.hjp.javaSource.JUC;

/**
 * @ClassName: JUC.ProducerCustomerTest
 * @Description: 生产者消费者协同
 * @Author: huangjp
 * @Date: 2020/5/11 11:33
 */
public class ProducerCustomerTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        new Thread(new Producer(stack)).start();
        new Thread(new Customer(stack)).start();
    }
}

class Producer implements Runnable {

    private Stack stack;

    public Producer(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++){
            stack.push(new Wotou());
        }
    }
}

class Customer implements Runnable {

    private Stack stack;

    public Customer(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++){
            stack.pop();
        }
    }
}

class Wotou {

}

class Stack {

    private Wotou[] arrWotou = new Wotou[6];

    private int index;  // 0,1,2,3,4,5

    public synchronized void push(Wotou wotou){

        while (index == arrWotou.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();

        System.out.println("存入：" + index);
        arrWotou[index] = wotou;
        index++;
    }

    public synchronized Wotou pop(){

        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();

        index--;
        System.out.println("取出：" + index);
        Wotou wotou = arrWotou[index];
        return wotou;
    }
}