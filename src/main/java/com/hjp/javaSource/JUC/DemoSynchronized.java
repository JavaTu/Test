package com.hjp.javaSource.JUC;

/**
 * @ClassName: DemoSynchronized
 * @Description:
 * @Author: huangjp
 * @Date: 2020/7/20 17:08
 */
public class DemoSynchronized {

    public static void main(String[] args) {
        test();
    }

    private static synchronized void test(){
        System.out.println("锁定类对象");
    }

}
