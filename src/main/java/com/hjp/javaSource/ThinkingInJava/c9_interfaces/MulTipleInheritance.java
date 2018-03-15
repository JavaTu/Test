package com.hjp.javaSource.ThinkingInJava.c9_interfaces;

/**
 * @author huangjp 2017-10-13 13:11
 *
 *      接口可继承多个接口。
 *      类只能继承一个基类，可以实现多个接口。
 **/
public class MulTipleInheritance extends ClassA implements InterfaceC, InterfaceD{

    @Override
    public void f3() {
        System.out.println("f3...");
    }

    @Override
    public void f4() {
        System.out.println("f4...");
    }

    public static void main(String[] args) {
        InterfaceA interfaceA = new MulTipleInheritance();
        interfaceA.f1();
        InterfaceB interfaceB = new MulTipleInheritance();
        interfaceB.f2();
        InterfaceC interfaceInheritance = new MulTipleInheritance();
        interfaceInheritance.f3();
        InterfaceD interfaceD = new MulTipleInheritance();
        interfaceD.f4();
        InterfaceAll interfaceAll = new MulTipleInheritance();
        interfaceAll.fA();
    }
    /*
        Output :
                f1...
                f2...
                f3...
                f4...
                fA...
     */
}

interface InterfaceA{
    void f1();
}

interface InterfaceB{
    void f2();
}

interface InterfaceC{
    void f3();
}

interface InterfaceD{
    void f4();
}

/**
 * 接口InterfaceAll多重继承！！！
 */
interface InterfaceAll extends InterfaceA, InterfaceB{
    void fA();
}

class ClassA implements InterfaceAll{

    @Override
    public void f1() {
        System.out.println("f1...");
    }

    @Override
    public void f2() {
        System.out.println("f2...");
    }

    @Override
    public void fA() {
        System.out.println("fA...");
    }
}



