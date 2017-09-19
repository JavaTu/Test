package com.hjp.javaSource.ThinkingInJava.ResuingClass2;

/**
 * @author huangjp 2017-9-19 17:10
 **/
public class AnotherPackageClass {

    public static void main(String[] args) {
        com.hjp.javaSource.ThinkingInJava.ReusingClass.Test test = new com.hjp.javaSource.ThinkingInJava.ReusingClass.Test();
        System.out.println("不同的包无法访问protected方法");
    }
}

class ExtendsClass extends com.hjp.javaSource.ThinkingInJava.ReusingClass.Test{

    public static void main(String[] args) {
        com.hjp.javaSource.ThinkingInJava.ReusingClass.Test test = new com.hjp.javaSource.ThinkingInJava.ReusingClass.Test();
        System.out.println("即时继承了父类，也无法访问父类的protected方法");
    }
}
