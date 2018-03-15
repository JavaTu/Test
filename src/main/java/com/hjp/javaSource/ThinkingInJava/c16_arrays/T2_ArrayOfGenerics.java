package com.hjp.javaSource.ThinkingInJava.c16_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjp 2018-03-14 17:47
 * 16.5示例：编译期不允许实例化泛型数组，但是允许创建泛型数组的引用，
 * 你可以先创建非泛型的数组，然后将其转型：
 **/
public class T2_ArrayOfGenerics {

    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;   //加上@SuppressWarnings("unchecked")可以去掉警告信息
        ls[0] = new ArrayList<>();
        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();
    }
}
