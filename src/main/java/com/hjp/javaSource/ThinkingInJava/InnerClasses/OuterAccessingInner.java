package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-10-19 16:48
 * 外部类对内部类对象的影响：外部类能访问并修改内部类的域，即时是私有的
 **/
public class OuterAccessingInner {

    public static void main(String[] args) {
        Outer3 outer3 = new Outer3();
        outer3.testInnerAccess(47);
    }
    /*
        Output : Inner3.i = 47
     */
}

class Outer3{

    void testInnerAccess(int j){
        Inner3 inner3 = new Inner3();
        inner3.i = j;
        inner3.h();
    }

    private class Inner3{
        private int i;

        private void h(){
            System.out.println("Inner3.i = " + i);
        }
    }
}
