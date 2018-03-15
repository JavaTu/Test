package com.hjp.javaSource.ThinkingInJava.c10_innerClasses;

/**
 * @author huangjp 2017-11-13 17:20
 * 接口内部的类
 **/
public class E20_InterfaceWithNested {
    public static void main(String[] args) {
        WithNested.Nested nested = new B2.Nested(1111);
        nested.f();
    }
}
/*
    Output : Nested.f()...
 */

interface WithNested{
    class Nested{
        int i;

        public Nested(int i) {
            this.i = i;
        }

        void f(){
            System.out.println("Nested.f()...");
        }
    }
}

class B2 implements WithNested{

}
