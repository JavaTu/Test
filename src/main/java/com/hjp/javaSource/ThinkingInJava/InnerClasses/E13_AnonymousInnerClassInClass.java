package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-11-6 13:54
 * 匿名内部类（有参）
 **/
public class E13_AnonymousInnerClassInClass {

    private SimpleInterface get(){
        return new SimpleInterface(){
            @Override
            public void f() {
                System.out.println("SimpleInterface.f()...");
            }
        };
    }

    public static void main(String[] args) {
        E13_AnonymousInnerClassInClass aic = new E13_AnonymousInnerClassInClass();
        SimpleInterface s = aic.get();
        s.f();

//      不能直接new接口，但是可以这样new，类似于匿名内部类
//      SimpleInterface simpleInterface = new SimpleInterface() {
//          @Override
//          public void f() {
//
//          }
//      };
    }
    /*
        Output : SimpleInterface.f()...
     */
}
