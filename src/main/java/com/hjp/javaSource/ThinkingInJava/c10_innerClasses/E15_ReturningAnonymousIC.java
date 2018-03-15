package com.hjp.javaSource.ThinkingInJava.c10_innerClasses;

/**
 * @author huangjp 2017-11-6 19:51
 * 带参的匿名内部类
 **/
public class E15_ReturningAnonymousIC {

    public static void main(String[] args) {
        Second second = new Second();
        NoDefault object1 = second.get1(1111);
        object1.f();
        NoDefault object2 = second.get2(1111);
        object2.f();
    }
    /*
        Output :
        NoDefault.f()...
        Second.get2.f()...
     */
}

class NoDefault{
    private int i;

    public NoDefault(int i) {
        this.i = i;
    }

    public void f(){
        System.out.println("NoDefault.f()...");
    }
}

class Second{
    //匿名内部类1，不重写任何方法
    public NoDefault get1(int i){
        return new NoDefault(i){};
    }

    //匿名内部类2，重写方法f()
    public NoDefault get2(int j){
        return new NoDefault(j){
            public void f(){
                System.out.println("Second.get2.f()...");
            }
        };
    }
}
