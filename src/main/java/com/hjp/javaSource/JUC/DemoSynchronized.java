package com.hjp.javaSource.JUC;

/**
 * @ClassName: DemoSynchronized
 * @Description:
 * @Author: huangjp
 * @Date: 2020/7/20 17:08
 */
public class DemoSynchronized {

    public static void main(String[] args) {
        String myLock = "myLock";
        test(myLock);
        test(myLock);
    }

    private static synchronized void test(){
        System.out.println("锁定类对象");
    }

    private static void test(String lock){
        synchronized (lock){
            System.out.println("锁定实例对象lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
