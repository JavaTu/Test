package com.hjp.javaSource.studyClass;

import java.util.Arrays;

/**
 * @author huangjp 2018-03-15 09:34
 * 关于System类常用的方法，具体可以以后要用到的时候再看。
 **/
public class SystemTest {

    private static int[] i1 = {1,2,3,4,5,6,7,8,9};

    private static int[] i2 = {11,22,33,44,55,66,77,88,99};

    public static void main(String[] args) {

        System.out.println("获取时间戳：" + System.currentTimeMillis());

        System.arraycopy(i1, 0, i2, 0, 5);
        System.out.println("复制数组：" + Arrays.toString(i2));

        System.out.println("正常退出程序...");
        System.exit(0);             //参数为0代表正常退出，程序正常执行结束退出，非0是非正常退出，就是说无论程序正在执行与否，都退出

        System.out.println("？？？");
    }
}
