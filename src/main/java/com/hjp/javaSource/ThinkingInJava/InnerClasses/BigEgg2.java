package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-11-16 11:17
 * 内部类可以被覆盖吗？这里展示的是可以
 **/
public class BigEgg2 extends Egg2{

    class Yolk extends Egg2.Yolk{                       //注意点二：想要向上转型就必须先继承Egg2.Yolk
        Yolk() {
            System.out.println("new BigEgg2.Yolk()");
        }

        @Override
        public void f() {
            System.out.println("BigEgg2.Yolk.f()...");
        }
    }

    private BigEgg2() {
        System.out.println("new BigEgg2()");
        insertYolk(new Yolk());                     //注意点一：将BigEgg2.Yolk向上转型为Egg2.Yolk
    }

    public static void main(String[] args) {
        Egg2 egg2 = new BigEgg2();
        egg2.g();
    }
}
/*
    Output :

            new Egg2.Yolk()
            new Egg2()
            new BigEgg2()
            new Egg2.Yolk()
            new BigEgg2.Yolk()
            BigEgg2.Yolk.f()...

 */

class Egg2{

    class Yolk{
        Yolk() {
            System.out.println("new Egg2.Yolk()");
        }

        public void f(){
            System.out.println("Egg2.Yolk.f()....");
        }
    }

    private Yolk yolk = new Yolk();

    void insertYolk(Yolk yy){
        yolk = yy;
    }

    Egg2(){
        System.out.println("new Egg2()");
    }

    void g(){
        yolk.f();
    }

}
