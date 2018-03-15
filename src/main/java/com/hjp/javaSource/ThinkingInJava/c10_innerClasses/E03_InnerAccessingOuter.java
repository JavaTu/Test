package com.hjp.javaSource.ThinkingInJava.c10_innerClasses;

/**
 * @author huangjp 2017-10-18 16:32
 **/
public class E03_InnerAccessingOuter {

    public static void main(String[] args) {
        Outer2 outer = new Outer2("I'm an outer");
        Outer2.Inner2 inner = outer.getInner();
        System.out.println(inner.toString());
    }
    /*
        Output : Outer's s : I'm an outer
     */
}

class Outer2{

    private String s;

    Outer2(String s) {
        this.s = s;
    }

    class Inner2{
        @Override
        public String toString() {
            return "Outer's s : " + s;
        }
    }

    Inner2 getInner(){
        return new Inner2();
    }
}