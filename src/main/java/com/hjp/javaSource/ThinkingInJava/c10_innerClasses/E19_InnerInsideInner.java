package com.hjp.javaSource.ThinkingInJava.c10_innerClasses;

/**
 * @author huangjp 2017-11-13 17:01
 * 内部类嵌套内部类，注意编译器生成的.class文件的名字
 * E19_InnerInsideInner：    E19_InnerInsideInner.class
 * InnerClass1：             E19_InnerInsideInner$InnerClass1.class
 * InnerClass2：             E19_InnerInsideInner$InnerClass1$InnerClass2.class
 * 匿名内部类：                E19_InnerInsideInner$1.class
 **/
public class E19_InnerInsideInner {

    static class InnerClass1{
        class InnerClass2{
            void f(){
                System.out.println("InnerClass2.f()...");
            }
        }

        InnerClass2 get2(){
            return new InnerClass2();
        }
    }

    SimpleInterface getI(){
        return new SimpleInterface() {

            @Override
            public void f() {
                System.out.println("匿名内部类.f()...");
            }
        };
    }

    public static void main(String[] args) {
        InnerClass1 i1 = new InnerClass1();
        InnerClass1.InnerClass2 i2 = i1.get2();
        i2.f();
    }
    /*
        Output :
                InnerClass2.f()...
     */
}

class OtherClass{
    public static void main(String[] args) {
        E19_InnerInsideInner.InnerClass1 i1 = new E19_InnerInsideInner.InnerClass1();
        E19_InnerInsideInner.InnerClass1.InnerClass2 i2 = i1.get2();
        i2.f();
    }
    /*
        Output :
                InnerClass2.f()...
     */
}
