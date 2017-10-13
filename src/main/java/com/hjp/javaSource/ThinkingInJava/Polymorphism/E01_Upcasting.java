package com.hjp.javaSource.ThinkingInJava.Polymorphism;

/**
 * @author huangjp 2017-10-11 15:16
 * 多态：向上转型、可扩展性
 **/
public class E01_Upcasting {

    /**
     * 骑车 展现多态的向上转型
     * @param cycle 自行车
     */
    private static void ride(Cycle cycle){
        System.out.println(cycle);
        cycle.wheels();
    }

    public static void main(String[] args) {
        ride(new Cycle());      //No Upcasting
        ride(new Unicycle());   //Upcasting
        ride(new Bicycle());    //Upcasting
    }

    /*
     * Output :
                com.hjp.javaSource.ThinkingInJava.Polymorphism.Cycle@336bc75c
                Base Cycle wheels...
                com.hjp.javaSource.ThinkingInJava.Polymorphism.Unicycle@563da1dc
                Unicycle wheels...
                com.hjp.javaSource.ThinkingInJava.Polymorphism.Bicycle@684d9ebf
                Bicycle wheels...
     */
}

/**
 * 自行车
 */
class Cycle{

    /**
     * 车轮数 展现多态的可扩展性
     */
    public void wheels(){
        System.out.println("Base Cycle wheels...");
    }
}

/**
 * 单轮车
 */
class Unicycle extends Cycle{

    @Override
    public void wheels() {
        System.out.println("Unicycle wheels...");
    }
}

/**
 * 脚踏车
 */
class Bicycle extends Cycle{

    @Override
    public void wheels() {
        System.out.println("Bicycle wheels...");
    }
}