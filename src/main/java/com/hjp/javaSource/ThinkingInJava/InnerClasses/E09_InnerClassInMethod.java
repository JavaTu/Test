package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-10-25 9:31
 * 方法中的内部类：局部内部类
 **/
public class E09_InnerClassInMethod {

    public SimpleInterface get(){

        class SI implements SimpleInterface {
            @Override
            public void f() {
                System.out.println("SI.f...");
            }
        }

        return new SI();
    }

    public static void main(String[] args) {
        SimpleInterface SI = new E09_InnerClassInMethod().get();
        SI.f();
    }
    /*
        Output : SI.f...
     */
}
