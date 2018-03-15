package com.hjp.javaSource.ThinkingInJava.c7_reusingClass;

import com.hjp.javaSource.ThinkingInJava.c2_operators.Test;

/**
 * @author huangjp 2017-9-19 17:07
 * 测试protected的权限
 **/
public class AnotherClass {

    public static void main(String[] args) {
        E15_Protected test = new E15_Protected();
        System.out.println("无法访问private方法");
        test.f();   //一个包内的文件，无论是否继承父类，都能访问protected方法
    }

}

class ExtendsClass extends Test{

    public static void main(String[] args) {
        E15_Protected test = new E15_Protected();
        test.f();   //即时继承了父类，也无法访问父类的private方法
    }

}
