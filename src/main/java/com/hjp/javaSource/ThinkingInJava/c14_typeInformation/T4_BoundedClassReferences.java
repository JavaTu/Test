package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

/**
 * @author huangjp 2018-03-16 17:02
 * 14.2.2泛化的Class引用示例：使用？与extends
 **/
public class T4_BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = long.class;
        //均可以，因为这些类都是Number的子类
    }
}
