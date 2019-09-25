package com.hjp.javaSource.javaBase;

/**
 * Java 类型自动转换机制：
 * 1. 低类型可自动转换为高类型:
 *  byte，char，short 可转 int
 *  int 可转 long
 *
 * 2. 谨记：
 *  预防数据溢出问题
 *
 * 3. 一般很少用到类型转换，为什么要转换？
 *
 * @author huangjp 2019/9/25 4:34 PM
 **/
public class ShortToIntTest {

    public static void main(String[] args) {

        // 字符型
        char c = 1;     // 2字节，16位，0～65535
        char c2 = 'A';  // 最小值 \u0000，就是0，最大值 \uffff，就是65535

        // 整型
        byte b = 1;     // 1字节，8位，-2的7次 ～ 2的7次-1 = -128～127
        short s1 = 1;   // 2字节，16位，-2的15次 ～ 2的15次-1
        short s2 = 2;
        s1 = (short) (s1 + s2);

        // Java 类型自动转换机制
        int i = s1;    // 4字节，32位，-2的31次 ～2的31次-1
        i++;

        // 是低的就能转高的，可跳跃
        long l = s1;    // 8字节，64位
        long l2 = 1L;

        // 浮点型
        float f1 = i;   // 单精度，4字节，有效小数位7位
        double d1 = i;  // 双精度，8字节，有效小数位15位

        double d2 = l;
        float f2 = l;

        double d3 = f1;
        float f3 = 0.0f;

        double d4 = 0.0d;
        System.out.println(i);
    }

}
