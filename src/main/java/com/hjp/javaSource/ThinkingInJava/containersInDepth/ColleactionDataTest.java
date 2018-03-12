package com.hjp.javaSource.ThinkingInJava.containersInDepth;

import com.hjp.javaSource.ThinkingInJava.Goverment;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author huangjp 2018-03-09 14:31
 **/
public class ColleactionDataTest {

    public static void main(String[] args) {
        //quantity必须小于或等于13
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Goverment(), 13));
        System.out.println(set);    //[a, b, c, d, e, f, g, h, i, j, k, l, m]
        set.addAll(CollectionData.list(new Goverment(), 13));
        System.out.println(set);    //[a, b, c, d, e, f, g, h, i, j, k, l, m]

    }
}
