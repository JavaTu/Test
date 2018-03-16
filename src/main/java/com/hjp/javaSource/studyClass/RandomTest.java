package com.hjp.javaSource.studyClass;

import java.util.Random;

/**
 * @author huangjp 2018-03-15 09:26
 * 关于Random的常用方法，常常把他跟Math.random()弄混。
 **/
public class RandomTest {

    /**
     * 47是一个种子，随机数是种子经过计算生成的
     * 不含参的构造函数每次都使用当前时间作为种子，随机性更强
     * 而含参的构造函数其实是伪随机，更有可预见性
     * 详见：http://blog.csdn.net/u011240877/article/details/52971166
     */
    private static Random random = new Random(47);

    public static void main(String[] args) {

        System.out.println("随机获取int:");
        for (int i = 0; i < 10; i++)
            System.out.print(random.nextInt(47) + " ");  //random.nextInt(n)的n必须是正数，n限定了取随机数的范围

        System.out.println("");
        System.out.println("随机获取double:");
        for (int i = 0; i < 5; i++)
            System.out.print(random.nextDouble() + " ");

        System.out.println("");
        System.out.println("随机获取boolean:");
        for (int j = 0; j < 10; j++)
            System.out.print(random.nextBoolean() + " ");
    }

    /*
        Output : 随机获取int:
                8 21 5 6 21 39 33 2 36 39
                随机获取double:
                0.2678662084200585 0.2613610344283964 0.0508673570556899 0.8037155449603999 0.7620665811558285
                随机获取boolean:
                true false true false false false true false false true
     */

}
