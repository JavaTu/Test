package com.hjp.javaSource.ThinkingInJava.c10_innerClasses;

/**
 * @author huangjp 2017-11-16 09:31
 * 内部类的继承
 **/
public class E26_InnerClassInheritance {

    class Inner2 extends WithNonDefault.Inner{
        //构造函数必须传递一个指向外围类的引用，否则会编译报错No enclosing instance of type '...WithNonDefault' is in scope
        Inner2(WithNonDefault wnd, int i) {
            wnd.super(i);
        }

        @Override
        public void f() {
            System.out.println("Inner2.f()...");
            super.f();
        }
    }

    class Inner3 extends WithDefault.Inner{
        Inner3(WithDefault wd) {
            wd.super();
        }

        @Override
        void f() {
            System.out.println("Inner3.f()....");
            super.f();
        }
    }

    public static void main(String[] args) {
        //有参的构造函数
        WithNonDefault withNonDefault = new WithNonDefault();
        Inner2 inner2 = new E26_InnerClassInheritance().new Inner2(withNonDefault, 1111);
        inner2.f();

        //无参的构造函数
        WithDefault wd = new WithDefault();
        Inner3 inner3 = new E26_InnerClassInheritance().new Inner3(wd);
        inner3.f();
    }
    /*
        Output :
                Inner2.f()...
                Inner.f()...
                Inner3.f()....
                Inner.f()...
     */
}

class  WithNonDefault{
    class Inner{
        int i;

        public Inner(int i) {
            this.i = i;
        }

        public void f(){
            System.out.println("Inner.f()...");
        }
    }
}

class WithDefault{

    class Inner{
        Inner() {

        }

        void f(){
            System.out.println("Inner.f()...");
        }
    }
}
