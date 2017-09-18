package com.hjp.javaSource.ThinkingInJava.OOP;

import java.util.Random;

/**
 * @author huangjp
 * 2017-9-6 15:09
 **/
public class Test {

    public static void main(String[] args) {

//        testStaticMember();
//        testLocalVariable();
//        testArgs(args);
//        testBaseTypes();
//            testAssign();
//        testAssignOnMethod();
//          testOperator();
//testRandom();
//        testEquals();
//        testToBinaryString();
        E04_FindPrime();
    }

    private static void E04_FindPrime(){
        System.out.println("----------------------- E04_FindPrime ------------------------");
        for (int i = 1; i <= 100; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("找到素数 : " + i);
            }
        }
        System.out.println("");
    }

    /**
     * 将十六进制/八进制转换成二进制
     */
    private static void testToBinaryString(){
        System.out.println("----------------------- testToBinaryString ----------------------------");
        long l1 = 0x45abL;  //十六进制 : 0x + 0~9/a-f
        long l2 = 04531L;   //八进制 : 0 + 0~7
        System.out.println("l1.toBinaryString = " + Long.toBinaryString(l1));   //100010110101011
        System.out.println("l2.toBinaryString = " + Long.toBinaryString(l2));   //100101011001
    }


    /**
     * 测试对象的equals方法：默认是比较对象的引用
     */
    private static void testEquals(){
        System.out.println("------------------------ testEquals --------------------");
        Dog dog1 = new Dog();
        dog1.name = "spot";
        dog1.says = "Ruff!";
        Dog dog2 = new Dog();
        dog2.name = "Robers";
        dog2.says = "sa bi!";
        System.out.println("dog1.name = " + dog1.name + ", says = " + dog1.says);
        System.out.println("dog2.name = " + dog2.name + ", says = " + dog2.says);

        Dog dog3 = dog1;
        System.out.println("(dog3 == dog1) = " + (dog3 == dog1));           //true : 内存地址相同
        System.out.println("(dog3 equals dog1) = " + (dog3.equals(dog1)));  //true : 引用相同

        Dog dog4 = new Dog();
        dog4.name = dog1.name;
        dog4.says = dog1.says;
        System.out.println("(dog4 == dog1) = " + (dog4 == dog1));           //false
        System.out.println("(dog4 equals dog1) = " + (dog4.equals(dog1)));  //false
    }

    /**
     * 测试操作符
     */
    private static void testOperator(){
        System.out.println("---------------- testOperator -----------------------------");
        float distance = 100f;
        float time = 9.3f;
        float speed = distance/time;
        System.out.println("distance = " + distance + "m");     //100.0m
        System.out.println("time = " + time + "s");             //9.3s
        System.out.println("speed = " + speed + "m/s");         //10.752688m/s
    }

    /**
     * 测试Random类
     */
    private static void testRandom(){
        System.out.println("---------------------------- testRandom ----------------------");
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            System.out.println("random.nextInt(100) = " + random.nextInt(100));
            System.out.println("random.nextFloat() = " + random.nextFloat());
            System.out.println("random.nextLong() = " + random.nextLong());
            System.out.println("random.nextDouble() = " + random.nextDouble());
            System.out.println("random.nextGaussian() = " + random.nextGaussian()); //返回下一个伪随机数，它是取自此随机数生成器序列的、呈高斯（“正态”）分布的double值，其平均值是0.0标准差是1.0。
            System.out.println("Math.random() = " + Math.random());         //[0.0, 1.0)
        }
    }

    /**
     * 赋值 ： 别名机制的测试方法（体现在方法f中）
     */
    private static void testAssignOnMethod(){
        System.out.println("------------------- testAssignOnMethod ----------------------------");
        Integral integral = new Integral();
        integral.aFloat = 4f;
        System.out.println("1: integral.f = " + integral.aFloat);   //4.0
        f(integral);
        System.out.println("2: integral f = " + integral.aFloat);   //6.0
    }

    private static void f(Integral integral){
        integral.aFloat = 6f;
    }

    /**
     * 赋值 ： 别名机制的测试方法（体现在常量aFloat中）
     */
    private static void testAssign(){
        System.out.println("----------------- testAssign -----------------");

        Integral i1 = new Integral();
        i1.aFloat = 1f;
        Integral i2 = new Integral();
        i2.aFloat = 2f;

        System.out.println("i1.f = " + i1.aFloat);
        System.out.println("i2.f = " + i2.aFloat);
        System.out.println("");

        i2 = i1;
        System.out.println("把i1赋值给i2后：");
        System.out.println("i1.f = " + i1.aFloat);
        System.out.println("i2.f = " + i2.aFloat);
        System.out.println("");

        i2.aFloat = 3f;
        System.out.println("修改i2的f值后：");
        System.out.println("i1.f = " + i1.aFloat);
        System.out.println("i2.f = " + i2.aFloat);
        System.out.println("");
    }   /* output : ----------------- testAssign -----------------
                    i1.f = 1.0
                    i2.f = 2.0

                    把i1赋值给i2后：
                    i1.f = 1.0
                    i2.f = 1.0

                    修改i2的f值后：
                    i1.f = 3.0
                    i2.f = 3.0
        */

    private static void testBaseTypes(){
        System.out.println("--------------------- testBaseTypes ---------------------------");

        DataOnly dataOnly = new DataOnly();
        System.out.println(dataOnly.aBoolean);  // output : false
        System.out.println(dataOnly.aByte);     // output : 0
        System.out.println(dataOnly.aChar);     // output : 空白
        System.out.println(dataOnly.aDouble);   // output : 0.0
        System.out.println(dataOnly.aFloat);    // output : 0.0
        System.out.println(dataOnly.aLong);     // output : 0
        System.out.println(dataOnly.anInt);     // output : 0
        System.out.println(dataOnly.aShort);    // output : 0

        System.out.println("");
    }

    private static void testLocalVariable(){
        System.out.println("--------------------- testLocalVariable ---------------------------");

        int i = new DataOnly().anInt;
        int x;
        //局部变量必须手动初始化，否则编译器会给予警告
        x = i;
        System.out.println("对象的数据成员i = " + i + ", 局部变量x = " + x);   // output : 对象的数据成员i = 0, 局部变量x = 0

        System.out.println("");
    }

    private static void testStaticMember(){
        System.out.println("--------------------- testStaticMember ---------------------------");

        StaticTest s1 = new StaticTest();
        StaticTest s2 = new StaticTest();
        System.out.println(s1.i + " == " + s2.i);       // output : 47 == 47

        //通过对象s1修改静态数据成员i, 对象s2的i值也发生改变，说明静态成员的实例只有一个
        s1.i++;
        System.out.println(s1.i + " == " + s2.i);       // output : 48 == 48

        System.out.println("");
    }

    private static void testArgs(String[] args){
        System.out.println("------------------- testArgs ----------------");

        if (args.length < 3) {
            System.err.println("请先输入三个参数！");    //err输出顺序不定，out输出顺序遵循从上至小
            return;
        }

        System.out.println("args[0] = " + args[0]);
        System.out.println("args[1] = " + args[1]);
        System.out.println("args[2] = " + args[2]);
        System.out.println("");
    }

}

class StaticTest{
    static int i = 47;

    public static void main(String[] args) {
        System.out.println("Second main function in one file");
    }
}

class Integral{
    float aFloat;
}

class Dog {
     String name;

     String says;
}

class A{

    A(String name) {
        System.out.println("A.name = " + name);
    }
}

class B extends A{

    B(String name) {
        super(name);    //调用基类构造器必须是你在导出类构造器中要做的第一件事
        System.out.println("B.name = " + name);
    }

    B(){
        super("no parameters");
        System.out.println("B()");
    }

    public static void main(String[] args) {
        B b = new B();
        B b1 = new B("one parameters");
    }
    /*
       output : A.name = no parameters
                B()
                A.name = one parameters
                B.name = one parameters
     */
}

class Component1{
    Component1() {
        System.out.println("Component1()");
    }
}

class Component2{
    Component2() {
        System.out.println("Component2()");
    }
}

class Component3{
    Component3() {
        System.out.println("Component3()");
    }
}

class Root{
    Component1 component1 = new Component1();
    Component2 component2 = new Component2();
    Component3 component3 = new Component3();

    Root() {
        System.out.println("root()");
    }
}

class Stem extends Root{
    Component1 component1 = new Component1();
    Component2 component2 = new Component2();
    Component3 component3 = new Component3();

    Stem() {
        System.out.println("stem()");
    }

    public static void main(String[] args) {
        new Stem();
    }
}

/*
 *  output : Component1()
             Component2()
             Component3()
             root()         为什么root的component也会初始化呢？在定义对象的地方初始化引用，这意味着它们总是能够在构造器被调用之前被初始化。
             Component1()
             Component2()
             Component3()
             stem()
 */




