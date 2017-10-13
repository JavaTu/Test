package com.hjp.javaSource.ThinkingInJava.Polymorphism;

import java.util.Random;

/**
 * @author huangjp 2017-10-11 15:51
 * 多态
 **/
public class E06_MusicToString {

    private static RandomInstrumentGenerator generator = new RandomInstrumentGenerator();

    /**
     * 演奏单个乐器
     */
    private static void tune(Instrument instrument){
        instrument.play();
    }

    /**
     * 演奏多个乐器
     */
    private static void tuneAll(Instrument[] instruments){
        for (Instrument instrument : instruments) {
            tune(instrument);
        }
    }

    /**
     * 输出乐器对象
     */
    private static void printAll(Instrument[] instruments){
        for (Instrument instrument : instruments) {
            System.out.println(instrument);
        }
    }

    public static void main(String[] args) {
        //Instrument[] instruments = {new Instrument(), new Wind(), new Stringed()};

        //使用乐器工厂生成乐器数组
        Instrument[] instruments = new Instrument[3];
        for (int i = 0 ; i < 3 ; i ++) {
            instruments[i] = generator.next();
        }

        tuneAll(instruments);
        printAll(instruments);
    }

    /*
        Output :
                    Instrment play...
                    Wind play...
                    Stringed play...
                    Instrument
                    Wind
                    Stringed
     */

}

/**
 * 乐器
 */
class Instrument{

    void play(){
        System.out.println("Instrment play...");
    }

    /**
     * 重写object的toString方法
     */
    public String toString(){
        return "Instrument";
    }

    void adjust(){
        System.out.println("Instrument adjust...");
    }
}

/**
 * 吹号角
 */
class Wind extends Instrument{

    @Override
    void play() {
        System.out.println("Wind play...");
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    void adjust() {
        System.out.println("Wind adjust...");
    }
}

class Stringed extends Instrument{
    @Override
    void play() {
        System.out.println("Stringed play...");
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Stringed adjust...");
    }
}

/**
 * 乐器工厂
 */
class RandomInstrumentGenerator{

    private Random random = new Random(47);

    /**
     * 随机生成一个乐器对象
     */
    Instrument next(){
        switch (random.nextInt(3)){
            default:
            case 0 : return new Instrument();
            case 1 : return new Wind();
            case 2 : return new Stringed();
        }
    }

}




