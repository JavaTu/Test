package com.hjp.javaSource.ThinkingInJava.c9_interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * @author huangjp 2017-10-13 14:59
 * 创建一个字符序列的适配器，使其可以成为Scanner对象的一种输入
 **/
public class E16_AdaptedCharSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdaptedCharSequence(10));
        //TODO：深入理解Scanner的使用与原理
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
    /*
        Output :
            NfMwKfNuEy
            GvMfZeJkUl
            TuMdDpDkGt
            LxTeXgFtGt
            RsLdViSuTq
            IaEbKtJxEw
            WaOfQdTlWz
            ViApXkXaMh
            UvLjHmRnEn
            KyPjQiBbIc
     */
}

class CharSequence{

    private static Random random = new Random(47);

    private static final char[] capitals = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();

    private static final char[] lowers = "qwertyuiopasdfghjklzxcvbnm".toCharArray();

    char[] gengerate(){
        char[] buffer = new char[11];
        for (int i = 0; i < 9; i += 2) {
            buffer[i] = capitals[random.nextInt(capitals.length)];
            buffer[i+1] = lowers[random.nextInt(lowers.length)];
        }
        buffer[10] = ' ';  //与'\n'的作用相同，不写不会换行
        return buffer;
    }
}

class AdaptedCharSequence extends CharSequence implements Readable{

    private int count;

    AdaptedCharSequence(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {

        if (count-- == 0) {     //TODO：count == 1与count-- == 0的区别？
            return -1;
        }

        char[] buffer = gengerate();
        cb.put(buffer); //TODO ？

        return buffer.length;
    }
}
