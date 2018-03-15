package com.hjp.javaSource.ThinkingInJava.c10_innerClasses.packge2;

import com.hjp.javaSource.ThinkingInJava.c10_innerClasses.packge1.SimpleInterface;

/**
 * @author huangjp 2017-10-19 15:40
 **/
public class SimpleClass {

    protected class InnerClass implements SimpleInterface{
        @Override
        public void f() {
            System.out.println("InnerClass.f()...");
        }

        public InnerClass(){}
    }
}
