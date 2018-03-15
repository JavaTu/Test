package com.hjp.javaSource.ThinkingInJava.c9_interfaces;

/**
 * @author huangjp 2017-10-13 14:02
 * 接口的优点：灵活、通用、复用性强
 **/
public class E14_InterfaceInheritance{

    private static void f1(Interface1 i){
        i.f1();
        i.g1();
    }

    private static void f2(Interface2 i){
        i.f2();
        i.g2();
    }

    private static void f3(Interface3 i){
        i.f3();
        i.g3();
    }

    private static void f4(Multiple i){
        i.h();
    }

    public static void main(String[] args) {
        All i = new All();
        f1(i);
        f2(i);
        f3(i);
        f4(i);
    }

    /*
        Output :
            All.f1...
            All.g1...
            All.f2...
            All.g2...
            All.f3...
            All.g3...
            All.h...
     */
}

interface Interface1{
    void f1();

    void g1();
}

interface Interface2{
    void f2();

    void g2();
}

interface Interface3{
    void f3();

    void g3();
}

interface Multiple extends Interface1, Interface2, Interface3{
    void h();
}

/**
 * 一个具体的类
 */
class Concrete{
    String s;

    public Concrete(String s) {
        this.s = s;
    }
}

class All extends Concrete implements Multiple{

    @Override
    public void f1() {
        System.out.println("All.f1...");
    }

    @Override
    public void g1() {
        System.out.println("All.g1...");
    }

    @Override
    public void f2() {
        System.out.println("All.f2...");
    }

    @Override
    public void g2() {
        System.out.println("All.g2...");
    }

    @Override
    public void f3() {
        System.out.println("All.f3...");
    }

    @Override
    public void g3() {
        System.out.println("All.g3...");
    }

    @Override
    public void h() {
        System.out.println("All.h...");
    }

    public All() {
        super("All");
    }
}

abstract class AbstructClass{
    String s;

    public AbstructClass(String s) {
        this.s = s;
    }

    abstract void af();
}

class All2 extends AbstructClass implements Multiple{

    public All2() {
        super("All2");
    }

    @Override
    public void f1() {
        System.out.println("All2.f1...");
    }

    @Override
    public void g1() {
        System.out.println("All2.g1...");
    }

    @Override
    public void f2() {
        System.out.println("All2.f2...");
    }

    @Override
    public void g2() {
        System.out.println("All2.g2...");
    }

    @Override
    public void f3() {
        System.out.println("All2.f3...");
    }

    @Override
    public void g3() {
        System.out.println("All2.g3...");
    }

    @Override
    public void h() {
        System.out.println("All2.h...");
    }

    @Override
    void af() {
        System.out.println("All2.af...");
    }
}

class E15_AbstructAndInterface{

    private static void f1(Interface1 i){
        i.f1();
        i.g1();
    }

    private static void f2(Interface2 i){
        i.f2();
        i.g2();
    }

    private static void f3(Interface3 i){
        i.f3();
        i.g3();
    }

    private static void f4(Multiple i){
        i.h();
    }

    private static void f5(AbstructClass i){
        i.af();
    }

    public static void main(String[] args) {
        All2 i = new All2();
        f1(i);
        f2(i);
        f3(i);
        f4(i);
        f5(i);
    }

    /*
        Output :
            All2.f1...
            All2.g1...
            All2.f2...
            All2.g2...
            All2.f3...
            All2.g3...
            All2.h...
            All2.af...
     */
}



