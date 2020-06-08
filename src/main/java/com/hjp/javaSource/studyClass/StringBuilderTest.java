package com.hjp.javaSource.studyClass;

/**
 * @ClassName: StringBuilder
 * @Description:
 * @Author: huangjp
 * @Date: 2020/5/28 16:33
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        String a = "a"; // 创建一个a对象
        String b = "b"; // 创建一个b对象
        String c = "c";   // 创建一个c对象
        String d = a + b + c;   // 这里一共生成了多少个对象？
        System.out.println(d);

        StringBuilder sb = new StringBuilder(3);
        sb.append(a).append(b).append(c);   // 这里一共生成了多少个对象？
        System.out.println(sb.toString());

    }



}
