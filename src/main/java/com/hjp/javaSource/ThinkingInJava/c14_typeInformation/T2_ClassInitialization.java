package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

import java.util.Random;

/**
 * @author huangjp 2018-03-16 15:25
 * 14.2.1（类字面常量A.class）示例：初始化类的顺序
 **/
public class T2_ClassInitialization {

    public static Random random = new Random(47);

    public static void main(String[] args) {

        /*
            1、并没有初始化Initable类，只是提供了一个该类的引用，只有对静态方法（构造方法）或非常数静态域进行首次引用时才会初始化；
            2、这样做的优点：简单、安全（因为在编译期就会被检查）、高效；
         */
        Class<Initable> initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);  //因为staticFinal2非静态常量，所以引用前会先初始化类
        System.out.println(Initable2.staticNonFinal);
        try {
            Class.forName("Initable3");             //会初始化类
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Initable3");
        }
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
/*
    Output : After creating Initable ref
            47
            Initializing Initable
            58
            Initializing Initable2
            147
            Couldn't find Initable3
            After creating Initable3 ref
            Initializing Initable3
            74
 */

class Initable{
    static final int staticFinal = 47;  //编译期常量（无需初始化类就可访问）

    static final int staticFinal2 = T2_ClassInitialization.random.nextInt(100);

    static {
        System.out.println("Initializing Initable");
    }

    public Initable() {
        System.out.println("Initializing Initable's Construction Method");
    }
}

class Initable2{
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }

    public Initable2() {
        System.out.println("Initializing Initable2's Construction Method");
    }
}

class Initable3{
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }

    public Initable3() {
        System.out.println("Initializing Initable3's Construction Method");
    }
}
