package com.hjp.javaSource.ThinkingInJava.c15_generics;

/**
 * @author huangjp 2018-03-15 19:53
 * 15.3 泛型接口：生成器，这是一种专门负责创建对象的接口，这是工厂方法设计模式的一种应用
 **/
public interface Generator<T> {

    T next();
}
