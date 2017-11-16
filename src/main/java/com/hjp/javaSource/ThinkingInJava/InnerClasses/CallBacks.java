package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-11-14 15:55
 * 内部类是面向对象的闭包，内部类可以操作所有的成员，包括private成员
 **/
public class CallBacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Caller caller1 = new Caller(c1);
        caller1.go();
        caller1.go();

        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller2 = new Caller(c2.getCallBackReference());
        caller2.go();
        caller2.go();
    }
}
/*
    Output :
            1
            2
            Other Operation
            1
            Other Operation
            2
            Other Operation
            3
 */

interface Incrementtable{
    void increment();
}

class Callee1 implements Incrementtable{

    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement{
    public void increment(){
        System.out.println("Other Operation");
    }

    static void f(MyIncrement mi){
        mi.increment();
    }
}

class Callee2 extends MyIncrement{

    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementtable{
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementtable getCallBackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementtable callBackReference;
    Caller(Incrementtable callBackReference) {
        this.callBackReference = callBackReference;
    }
    void go(){
        callBackReference.increment();
    }
}
