package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-11-13 17:24
 * 接口内部的类
 **/
public class E21_InterfaceWithNested2 {
    public static void main(String[] args) {
        I impl = new I() {
            @Override
            public void f() {}
        };
        I.Nested.call(impl);
    }
}
/*
    Output : Calling I.f()...
 */

interface I{

    void f();

    class Nested {
        static void call(I impl){
            System.out.println("Calling I.f()...");
            impl.f();
        }
    }
}