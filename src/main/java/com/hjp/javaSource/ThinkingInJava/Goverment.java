package com.hjp.javaSource.ThinkingInJava;

/**
 * @author huangjp 2018-03-09 15:19
 **/
public class Goverment implements Generator<String>{

    private String[] foundation= ("a b c d e f g h i j k l m n").split(" ");

    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}
