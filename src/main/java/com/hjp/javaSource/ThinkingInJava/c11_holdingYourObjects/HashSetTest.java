package com.hjp.javaSource.ThinkingInJava.c11_holdingYourObjects;

import com.hjp.javaSource.ThinkingInJava.PublicEntity;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author huangjp 2018/7/1 20:06
 * 测试HashSet判断重复对象的标准
 **/
public class HashSetTest {

    public static void main(String[] args) {
        PublicEntity e1 = new PublicEntity();
        PublicEntity e2 = new PublicEntity();
        e1.setAttribute1("1");
        e2.setAttribute1("2");

        HashSet<PublicEntity> s1 = new HashSet<>();
        System.out.println("s1.add(e1) = "+s1.add(e1));
        System.out.println("s1.add(e2) = "+s1.add(e2));

        HashSet<String> s2 = new HashSet<>();
        System.out.println("s2.add('1') = "+s2.add("1"));   //true
        System.out.println("s2.add('1') = "+s2.add("1"));   //false

        HashMap<Integer, PublicEntity> m = new HashMap<>();
        System.out.println("m.put(1, e1) = " + m.put(1, e1));   //null
        System.out.println("m.put(1, e1) = " + m.put(1, e1));   //com.hjp.javaSource.ThinkingInJava.PublicEntity@3cd1a2f1
        System.out.println("m.put(2, e2) = " + m.put(2, e2));   //null

        HashMap<PublicEntity, Integer> m2 = new HashMap<>();
        System.out.println("m2.put(e1, 1) = " + m2.put(e1, 1)); //null
        System.out.println("m2.put(e1, 1) = " + m2.put(e1, 1)); //1
        System.out.println("m2.put(e1, 1) = " + m2.put(e2, 2)); //null

        m2.get(e1);

        int[] arr = {1,2,3};
        int i;
        System.out.println("arr[i = 1] = " + arr[i = 1]);
    }
}
