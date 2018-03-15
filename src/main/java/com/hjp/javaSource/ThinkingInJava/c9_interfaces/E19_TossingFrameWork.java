package com.hjp.javaSource.ThinkingInJava.c9_interfaces;

/**
 * @author huangjp 2017-10-17 16:52
 * 工厂模式实现抛硬币与掷骰子的框架
 **/
public class E19_TossingFrameWork {

    private static void f(PFactory pFactory){
        Tossing p = pFactory.getTossing();
        while (p.f());
    }

    public static void main(String[] args) {
        f(new CoinFactory());
        f(new SifterFactory());
    }

    /*
        Output :
                    Coin event 0
                    Coin event 1
                    Sifter event 0
                    Sifter event 1
                    Sifter event 2
                    Sifter event 3
                    Sifter event 4
                    Sifter event 5
     */
}

interface Tossing {
    boolean f();
}

interface PFactory{
    Tossing getTossing();
}

/**
 * 硬币
 */
class CoinTossing implements Tossing {

    private static int events;

    private static final int EVENT = 2;

    /**
     * 掷硬币
     */
    @Override
    public boolean f() {
        System.out.println("Coin event " + events);
        return ++events != EVENT;
    }
}

/**
 * 筛子
 */
class SifterTossing implements Tossing {

    private static int events;

    private static final int EVENT = 6;

    /**
     * 掷骰子
     */
    @Override
    public boolean f() {
        System.out.println("Sifter event " + events);
        return ++events != EVENT;
    }
}

/**
 * 硬币工厂
 */
class CoinFactory implements PFactory{
    @Override
    public Tossing getTossing() {
        return new CoinTossing();
    }
}

/**
 * 筛子工厂
 */
class SifterFactory implements PFactory{
    @Override
    public Tossing getTossing() {
        return new SifterTossing();
    }
}
