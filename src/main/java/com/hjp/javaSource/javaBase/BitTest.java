package com.hjp.javaSource.javaBase;

/**
 * @ClassName: BitTest
 * @Description: 位运算测试类
 * 参考：https://oi-wiki.org/math/bit/
 * @Author: huangjp
 * @Date: 2020/5/29 11:52
 */
public class BitTest {

    public static void main(String[] args) {
        int a = 1;  // 0001
        int b = 3;  // 0011
        int c = 9;  // 1001
        int d = -2; // 1111 1111 1111 1111 1111 1111 1111 1111，32位

        // 与：&
        System.out.println("0001 & 0011：" + Integer.toBinaryString(a & b));     // 0001，都是1才是1，否则都是0

        // 或：|
        System.out.println("0001 | 0011：" + Integer.toBinaryString(a | b));     // 0011，有一个1就是1

        // 异或：^
        System.out.println("0001 ^ 0011：" + Integer.toBinaryString(a ^ b));     // 0010，相同为0，不同为1

        // 左移：<<
        System.out.println("1001 << 2：" + Integer.toBinaryString(c << 2));      // 100100，右边加2个0

        // 右移：>>
        System.out.println("1001 >> 2：" + Integer.toBinaryString(c >> 2));      // 10，右边砍掉2位

        // 无符号右移：>>>
        System.out.println("1001 >>> 2：" + Integer.toBinaryString(c >>> 2));    // 10

        System.out.println("-2的二进制：" + Integer.toBinaryString(d));
        System.out.println("-1 >>> 2 ：" + Integer.toBinaryString(d >>> 2));

        // HashMap的Hash计算
        String key = "test";
        int hashCode = key.hashCode();
        int hash = hashCode ^ (hashCode >>> 16);
        System.out.println("hashCode " + hashCode + " 的hash值：" + hash);

        // HashMap数组下标的计算
        int length = 16;
        int index = (length - 1) & hash;
        System.out.println("index：" + index);
    }

}
