package com.hjp.javaSource.ThinkingInJava.c16_arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @author huangjp 2018-03-14 16:51
 * 16.3示例：返回String型数组（元素唯一）
 **/
public class T1_IceCream {

    private static Random random = new Random(47);

    static final String[] FLAVORS = {"1", "2", "3", "4", "5", "6", "7"};

    private static String[] flavors(int n){
        if (n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] result = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];     //设计思路1：确保result中元素的唯一性
        for (int i = 0; i < n; i++) {
            int t;
            do
                t = random.nextInt(FLAVORS.length);         //设计思路2：随机抽取数据，若为true,则继续抽取，直到抽到false(代表此值没被使用过)，才放入result
            while (picked[t]);
            result[i] = FLAVORS[t];
            picked[t] = true;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            System.out.println(Arrays.toString(flavors(3)));
    }

    /*
    Output : [7, 3, 2]
            [6, 3, 1]
            [6, 1, 3]
            [6, 5, 2]
            [4, 2, 6]
            [1, 3, 5]
            [1, 4, 6]
     */

    //代码设计思路感想：这里针对元素的唯一性使用boolean数组与do...while更加安全，效率更高，更加强调随机性
}
