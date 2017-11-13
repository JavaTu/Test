package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-11-13 16:52
 * 嵌套类
 **/
public class E18_NestedClass {

    public static class NestedClass{
        public NestedClass() {
            System.out.println("创建NestedClass..");
        }

        public void f(){
            System.out.println("NestedClass.f()...");
        }
    }

    public static void main(String[] args) {
        NestedClass nestedClass = new NestedClass();
        nestedClass.f();
    }
    /*
        Output :
            创建NestedClass..
            NestedClass.f()...
     */
}

class Other{
    public static void main(String[] args) {
        E18_NestedClass.NestedClass object = new E18_NestedClass.NestedClass();
        object.f();
    }
    /*
        Output :
            创建NestedClass..
            NestedClass.f()...
     */
}
