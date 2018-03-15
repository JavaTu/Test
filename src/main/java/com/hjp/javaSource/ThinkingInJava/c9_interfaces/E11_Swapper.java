package com.hjp.javaSource.ThinkingInJava.c9_interfaces;

/**
 * @author huangjp 2017-10-13 11:04
 * 【接口】完全解耦 适配器设计模式
 **/
public class E11_Swapper {

    public static void main(String[] args) {
        Apply.process(new SwapAdapter(), "1234");
        Apply.process(new SwapAdapter(), "abcd");
    }
}
/*
    Output :
            using processor :CharacterPairSwapper
            2143
            using processor :CharacterPairSwapper
            badc
 */

interface Processor{

    String name();
    Object process(Object input);
}

class Apply{

    static void process(Processor p, Object s){
        System.out.println("using processor :" + p.name());
        System.out.println(s);
        System.out.println(p.process(s));
    }
}

class CharacterPairSwapper{

    /**
     * 字符两两交换
     */
    static String swap(String s){

       StringBuilder sb = new StringBuilder(s);
       for (int i = 0; i < sb.length() - 1; i += 2) {
           char c1 = sb.charAt(i);
           char c2 = sb.charAt(i + 1);
           sb.setCharAt(i, c2);
           sb.setCharAt(i+1, c1);
       }
       return sb.toString();
    }
}

/**
 *  CharacterPairSwapper的适配器
 */
class SwapAdapter implements Processor{

    @Override
    public String name() {
        return CharacterPairSwapper.class.getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return CharacterPairSwapper.swap((String)input);
    }
}

