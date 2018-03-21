package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

/**
 * @author huangjp 2018-03-19 17:37
 * 14.4注册工厂示例：使用工厂方法设计模式将对象的创建工作交给类自己去完成
 * 工厂接口
 **/
public interface T6_Factory<T> {

    T create();
}
