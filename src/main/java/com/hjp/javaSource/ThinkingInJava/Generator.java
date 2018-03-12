package com.hjp.javaSource.ThinkingInJava;

/**
 * @author huangjp 2018-03-09 14:45
 * 对象生成器（工厂模式）
 **/
public interface Generator<T> {

    /**
     * 用于产生新对象
     */
    public T next();
}
