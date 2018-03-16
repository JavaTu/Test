package com.hjp.javaSource.ThinkingInJava.c15_generics;

/**
 * @author huangjp 2018-03-15 19:55
 * 15.3示例：咖啡类
 **/
public class Coffee {

    private static long counter = 0;

    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

/**
 * 咖啡的子类：Latte
 */
class Latte extends Coffee{}

/**
 * 咖啡的子类：Mocha
 */
class Mocha extends Coffee{}

/**
 * 咖啡的子类：Breve
 */
class Breve extends Coffee{}