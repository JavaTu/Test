package com.hjp.javaSource.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: MethodReferenceTest
 * @Description:
 * @Author: huangjp
 * @Date: 2020/7/17 13:53
 */
public class MethodReferenceTest {

    private static void test(Object o){
        System.out.println(o);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3");
        list.forEach(MethodReferenceTest::test);
    }

}
