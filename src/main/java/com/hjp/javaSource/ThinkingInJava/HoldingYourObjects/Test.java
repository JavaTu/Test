package com.hjp.javaSource.ThinkingInJava.HoldingYourObjects;

import java.util.*;

/**
 * @author huangjp 2018-03-12 13:41
 * java基本容器测试类
 **/
public class Test {

    private static ArrayList arrayList = new ArrayList();

    private static LinkedList linkedList = new LinkedList();

    private static HashSet hashSet = new HashSet();

    private static TreeSet treeSet = new TreeSet();

    private static LinkedHashSet linkedHashSet = new LinkedHashSet();

    private static HashMap hashMap = new HashMap();

    private static TreeMap treeMap = new TreeMap();

    private static LinkedHashMap linkedHashMap = new LinkedHashMap();

    private static Hashtable hashtable = new Hashtable();

    private static final Object[] arr = {1,5,2,6,0,8,6,2,4,7,100};

    public static void main(String[] args) {
        add();
        addNull();
        print();
    }
    /*
    Output : arrayList:
            1 5 2 6 0 8 6 2 4 7 100 null
            linkedList:
            1 5 2 6 0 8 6 2 4 7 100 null
            hashSet:
            null 0 1 100 2 4 5 6 7 8
            treeSet:
            0 1 2 4 5 6 7 8 100
            linkedHashSet:
            1 5 2 6 0 8 4 7 100 null
            hashMap:
            null 0 1 100 2 4 5 6 7 8
            treeMap:
            0 1 2 4 5 6 7 8 100
            linkedHashMap:
            1 5 2 6 0 8 4 7 100 null
            hashtable:
            100 8 7 6 5 4 2 1 0
     */


    private static void add(){
        for (Object i : arr){
            arrayList.add(i);
            linkedList.add(i);
            hashSet.add(i);
            treeSet.add(i);
            linkedHashSet.add(i);
            hashMap.put(i,i);
            treeMap.put(i, i);
            linkedHashMap.put(i, i);
            hashtable.put(i, i);
        }
    }

    private static void addNull(){
        arrayList.add(null);
        linkedList.add(null);
        hashSet.add(null);
        //treeSet.add(null);
        linkedHashSet.add(null);
        hashMap.put(null,null);
        //treeMap.put(null, null);
        linkedHashMap.put(null, null);
        //hashtable.put(null, null);
    }

    private static void print(){
        System.out.println("arrayList:");
        for (Object array : arrayList)
            System.out.print(array + " ");
        System.out.println("");
        System.out.println("linkedList:");
        for (Object linked : linkedList)
            System.out.print(linked + " ");
        System.out.println("");
        System.out.println("hashSet:");
        for (Object set : hashSet){
            System.out.print(set + " ");
        }
        System.out.println("");
        System.out.println("treeSet:");
        for (Object set : treeSet)
            System.out.print(set + " ");
        System.out.println("");
        System.out.println("linkedHashSet:");
        for (Object set : linkedHashSet)
            System.out.print(set + " ");
        System.out.println("");
        System.out.println("hashMap:");
        for (Object key : hashMap.keySet())
            System.out.print(hashMap.get(key) + " ");
        System.out.println("");
        System.out.println("treeMap:");
        for (Object key : treeMap.keySet())
            System.out.print(treeMap.get(key) + " ");
        System.out.println("");
        System.out.println("linkedHashMap:");
        for (Object key : linkedHashMap.keySet())
            System.out.print(linkedHashMap.get(key) + " ");
        System.out.println("");
        System.out.println("hashtable:");
        for (Object key : hashtable.keySet())
            System.out.print(hashtable.get(key) + " ");
    }
}
