package com.hjp.javaSource.ThinkingInJava.ReusingClass;

/**
 * @author huangjp 2017-9-19 17:07
 **/
public class AnotherClass {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("一个包内的文件，无论是否继承父类，都能访问protected方法");
        System.out.println("一个包内访问protected方法");
        System.out.println("无法访问private方法");
        test.protectedMethod();
    }

}

class ExtendsClass extends Test{

    public static void main(String[] args) {
        Test test = new Test();
        test.protectedMethod();
        System.out.println("即时继承了父类，也无法访问父类的private方法");
    }

}
