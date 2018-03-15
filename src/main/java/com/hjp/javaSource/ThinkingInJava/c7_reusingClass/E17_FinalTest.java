package com.hjp.javaSource.ThinkingInJava.c7_reusingClass;

import java.util.Random;

/**
 * @author huangjp 2017-09-21 15:43
 * 1、初始化类先初始化成员，初始化成员先初始化静态成员
 * 2、object1.f2 = object2.f2说明了静态变量只有一份，也只会初始化一次
 */
public class E17_FinalTest {

    public static void main(String[] args) {

        System.out.println("----------------------- Test Begin --------------------------");
        FinalObjectClass object1 = new FinalObjectClass();
        System.out.println("----------------------- Test End --------------------------\n");

        object1.f1.f3 = 1111;
        // !f1 = new FinalClass();          //证明了final对象可修改其数据，但不可修改其引用

        System.out.println("----------------------- Test Begin --------------------------");
        FinalObjectClass object2 = new FinalObjectClass();
        System.out.println("----------------------- Test End --------------------------\n");
    }
    /*
        Output :
            ----------------------- Test Begin --------------------------
            获取一个static final数据sf1
            获取一个final数据f1
            获取一个普通的数据
            加载FinalMemberClass的构造函数
            FinalMemberClass{f1=5, f3=3, sf1=8}     //final FinalMemberClass f1 = new FinalMemberClass();引起

            获取一个final数据f1
            获取一个普通的数据
            加载FinalMemberClass的构造函数
            FinalMemberClass{f1=1, f3=1, sf1=8}    //private static final FinalMemberClass f2 = new FinalMemberClass();引起

            加载FinalObjectClass的构造函数
            FinalObjectClass{f1=FinalMemberClass{f1=1, f3=1, sf1=8}, f2=FinalMemberClass{f1=5, f3=3, sf1=8}}    //FinalObjectClass object1 = new FinalObjectClass();引起

            ----------------------- Test End --------------------------

            ----------------------- Test Begin --------------------------
            获取一个final数据f1
            获取一个普通的数据
            加载FinalMemberClass的构造函数
            FinalMemberClass{f1=9, f3=8, sf1=8}    //final FinalMemberClass f1 = new FinalMemberClass();引起

            //这里private static final FinalMemberClass f2 = new FinalMemberClass();没有再次访问FinalMemberClass，
              原因就是静态变量只会初始化一次！也只有一份！

            加载FinalObjectClass的构造函数
            FinalObjectClass{f1=FinalMemberClass{f1=9, f3=8, sf1=8}, f2=FinalMemberClass{f1=5, f3=3, sf1=8}}

            ----------------------- Test End --------------------------
     */
}

class FinalObjectClass{

    final FinalMemberClass f1 = new FinalMemberClass();

    private static final FinalMemberClass f2 = new FinalMemberClass();

    FinalObjectClass(){
        System.out.println("加载FinalObjectClass的构造函数");
        System.out.println(toString() + "\n");
    }

    @Override
    public String toString() {
        return "FinalObjectClass{" +
                "f1=" + f1 +
                ", f2=" + f2 +
                '}';
    }
}

class FinalMemberClass{

    private static Random random = new Random(47);

    private final int f1 = getInt("获取一个final数据f1");

    private static final int sf1 = getInt("获取一个static final数据sf1");

    int f3 = getInt("获取一个普通的数据");

    FinalMemberClass(){
        System.out.println("加载FinalMemberClass的构造函数");
        System.out.println(toString() + "\n");
    }

    private static int getInt(String s){
        System.out.println(s);
        return random.nextInt(10);
    }

    @Override
    public String toString() {
        return "FinalMemberClass{" +
                "f1=" + f1 +
                ", f3=" + f3 +
                ", sf1=" + sf1 +
                '}';
    }
}
