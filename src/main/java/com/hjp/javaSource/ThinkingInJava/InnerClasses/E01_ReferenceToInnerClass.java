package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-10-18 16:01
 * 最简单的内部类示例
 **/
public class E01_ReferenceToInnerClass {

    public static void main(String[] args) {
        Outer1 outerClass = new Outer1();
        // 这里一定要写成OuterClass.InnerClass！！！
        Outer1.Inner1 innerClass = outerClass.getInner();
    }
    /*
        Output : InnerClass create...
     */
}

class Outer1 {
    class Inner1{
        Inner1() {
            System.out.println("InnerClass create...");
        }
    }

    Inner1 getInner(){
        return new Inner1();
    }
}
