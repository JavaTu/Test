package com.hjp.javaSource.studyClass;

/**
 * @author huangjp 2018-03-15 09:50
 * 关于类Math的常用方法
 **/
public class MathTest {

    private static double aDouble = Math.random();

    public static void main(String[] args) {

        System.out.println("随机获取一个double：" + aDouble);

        System.out.println("它的绝对值：" + Math.abs(aDouble));
    }
}