package com.hjp.javaSource.jdk8;

/**
 * default 接口默认实现方法是为了让集合类默认实现这些函数式处理，而不用修改现有代码
 * 多实现类，默认方法重名时必须复写
 * @author huangjp 2019/9/23 4:55 PM
 **/
public interface DefaultAndStaticInterface {

    default void defaultMethod(){
        System.out.println("I'm defaultMethod in interface!");
    }

    default void defaultMethod2(){
        System.out.println("I'm defaultMethod2 in interface!");
    }

    static void staticMethod(){
        System.out.println("I'm staticMethod in interface!");
    }


}
