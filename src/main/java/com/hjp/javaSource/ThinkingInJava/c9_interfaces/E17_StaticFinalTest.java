package com.hjp.javaSource.ThinkingInJava.c9_interfaces;

/**
 * @author huangjp 2017-10-17 15:11
 * 接口中的域隐式地是static和final的
 **/
public class E17_StaticFinalTest {
    public static void main(String[] args) {
        System.out.println("AClass.COLOR = " + AClass.COLOR);
    }   //Output : AClass.COLOR = yellow
}

interface Interface{
    String COLOR = "yellow";
}

class AClass implements Interface{
    // !COLOR = "red"; final类型的字段无法修改
}
