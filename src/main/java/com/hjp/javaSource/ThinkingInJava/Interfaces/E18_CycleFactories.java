package com.hjp.javaSource.ThinkingInJava.Interfaces;

/**
 * @author huangjp 2017-10-17 16:43
 * 工厂模式
 **/
public class E18_CycleFactories {
    private static void f(CycleFactory cycleFactory){
        Cycle cycle = cycleFactory.getCycle();
        cycle.f();
    }

    public static void main(String[] args) {
        f(new UnicycleFactory());
        f(new BicycleFactory());
    }
    /*
    Output : UniCycle f...
             Bicycle f...
     */
}

interface Cycle{
    void f();
}

interface CycleFactory{
    Cycle getCycle();
}

class Unicycle implements Cycle{
    @Override
    public void f() {
        System.out.println("UniCycle f...");
    }
}

class Bicycle implements Cycle{
    @Override
    public void f() {
        System.out.println("Bicycle f...");
    }
}

class UnicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}