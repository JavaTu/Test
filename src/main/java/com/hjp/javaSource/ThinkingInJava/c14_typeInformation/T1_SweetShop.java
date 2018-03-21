package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

/**
 * @author huangjp 2018-03-16 14:15
 * 14.2示例：一旦某个类的Class对象被载入内存，它就被用来创建这个类的所有对象
 **/
public class T1_SweetShop {

    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After create Candy");
        try {
            //Class.forName()根据目标类路径获得对象的引用，会初始化对象（执行对象的构造方法）
            Class.forName("com.hjp.javaSource.ThinkingInJava.c14_typeInformation.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class forName(\"Gum\")");
        new Cookie();
        System.out.println("After create Cookie");
    }
}
/*
    Output : inside main
            Loading candy
            After create Candy
            Loading Gum
            After Class forName("Gum")
            Loading Cookie
            After create Cookie
 */

class Candy{
    static {
        System.out.println("Loading candy");
    }
}

class Gum{
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}



