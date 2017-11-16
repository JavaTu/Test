package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-11-16 11:13
 * 内部类可以被覆盖吗？这里展示的是不可以，因为没有进行向上转型，那么他们两个Yolk其实是两个独立的实体
 **/
public class BigEgg extends Egg {

    class Yolk {
        public Yolk() {
            System.out.println("Yolk2 create...");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}
/*
    Output :
        Egg create..
        Yolk create..
 */

class Egg{

    class Yolk{

        public Yolk() {
            System.out.println("Yolk create..");
        }

        public void f(){
            System.out.println("Yolk1.f()...");
        }
    }

    private Yolk yolk;

    public Egg() {
        System.out.println("Egg create..");
        yolk = new Yolk();
    }
}


