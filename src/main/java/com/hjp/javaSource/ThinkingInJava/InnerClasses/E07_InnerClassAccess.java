package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-10-19 16:07
 * 内部类对外部类对象的影响：内部类能访问并修改外部类的域，即时是私有的
 **/
public class E07_InnerClassAccess {

    public static void main(String[] args) {
        Outer outer = new Outer(10);
        outer.add();
    }
    /*
        Output :
                第一步：创建一个外部类实例，初始化i = 10
                第二步：来到外部类的add()方法，在这里创建一个内部类实例，并调用内部类的add()方法
                第三步：来到内部类的add()方法，内部类调用外部类的private方法修改i的值，修改后i = 11
     */
}

class Outer{

    private int i;

    private void addOne(){
        i++;
    }

    Outer(int i) {
        this.i = i;
    }

    class Inner{
        void add(){
            addOne();
            System.out.println("第三步：来到内部类的add()方法，内部类调用外部类的private方法修改i的值，修改后i = " + i);
        }
    }

    void add(){
        System.out.println("第一步：创建一个外部类实例，初始化i = " + i);
        System.out.println("第二步：来到外部类的add()方法，在这里创建一个内部类实例，并调用内部类的add()方法");
        Inner inner = new Inner();
        inner.add();
    }
}
