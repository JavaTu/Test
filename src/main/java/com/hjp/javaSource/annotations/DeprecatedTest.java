package com.hjp.javaSource.annotations;

/**
 * @author huangjp 2018/11/1 3:29 PM
 * 关于注解@Deprecated的测试类
 **/
public class DeprecatedTest {

    @Deprecated
    private static void f1(){
        System.out.println("f1...");
    }

    private static void f2(){
        System.out.println("f2...");
    }

    public static void main(String[] args) {
        f1();   //事实证明：即使被标记为Deprecated，仍可以正常使用！
        f2();
    }
}
