package com.hjp.javaSource.ThinkingInJava;

/**
 * @author huangjp 2017-9-19 17:10
 * 测试protected的访问权限
 **/
public class E15_Protected {

    public static void main(String[] args) {
        com.hjp.javaSource.ThinkingInJava.ReusingClass.E15_Protected test = new com.hjp.javaSource.ThinkingInJava.ReusingClass.E15_Protected();
        System.out.println("不同的包下无法访问protected方法");
    }
}

class ChildClass extends com.hjp.javaSource.ThinkingInJava.ReusingClass.E15_Protected{

    public static void main(String[] args) {
        com.hjp.javaSource.ThinkingInJava.ReusingClass.E15_Protected test = new com.hjp.javaSource.ThinkingInJava.ReusingClass.E15_Protected();
        System.out.println("不同的包下，这样不能调用父类的protected方法");
        System.out.println("---------------------------------------------------");

        ChildClass extendsClass = new ChildClass();
        extendsClass.p();   //可以通过子类间接的访问父类的protected方法
    }

    private void p(){
        f();
        System.out.println("访问子类的public方法");    //不同的包下，可以直接调用父类的方法
    }
}
