package com.hjp.javaSource.ThinkingInJava.c10_innerClasses;

/**
 * @author huangjp 2017-11-6 9:40
 * 匿名内部类（无参）
 **/
public class E12_AnonymousInnerClassAccess {

    private int i;

    private void f(){
        System.out.println("E12_AnonymousInnerClassAccess.f()....");
    }

    public void h(){
        new Object(){
          void g(){
              i++;
              f();
          }
        }.g();
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        E12_AnonymousInnerClassAccess ica = new E12_AnonymousInnerClassAccess();
        ica.h();
    }
    /*
        Output :
            E12_AnonymousInnerClassAccess.f()....
            i = 1
     */
}
