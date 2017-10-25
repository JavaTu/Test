package com.hjp.javaSource.ThinkingInJava.InnerClasses;

import com.hjp.javaSource.ThinkingInJava.InnerClasses.packge1.SimpleInterface;
import com.hjp.javaSource.ThinkingInJava.InnerClasses.packge2.SimpleClass;

/**
 * @author huangjp 2017-10-19 15:42
 * 在不同的包下实例化protect的内部类
 **/
public class E06_ProtectedInnerClass extends SimpleClass{

    private SimpleInterface getProtectedInnerClass(){
        /*
            注意：
                1、内部类InnerClass本是protect的，不可在包以外被访问，由于E06_ProtectedInnerClass继承了SimpleClass，所以能访问InnerClass；
                2、但是要new一个InnerClass还有一个条件就是InnerClass的构造函数必须是public的
                3、protect内部类系统默认的构造函数是protect的
         */
        return new InnerClass();
    }

    public static void main(String[] args) {
        new E06_ProtectedInnerClass().getProtectedInnerClass().f();
    }
    /*
        Output : InnerClass.f()...
     */
}
