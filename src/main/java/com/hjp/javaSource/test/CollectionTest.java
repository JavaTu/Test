package com.hjp.javaSource.test;


import org.openjdk.jmh.runner.RunnerException;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 学习使用JMH
 */
public class CollectionTest {

    private static final int TEST_NUM = 1000000;
    private static long startTime;
    private static long endTime;

    public static void arrayList(){
        startTime = System.currentTimeMillis();
        List<String> arrayList = new ArrayList<>();
        for (int i=0; i<TEST_NUM; i++){
            arrayList.add("hxt");
        }
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));
    }

    public static void arrayListSize(){
        startTime = System.currentTimeMillis();
        List<String> arrayListSize = new ArrayList<>(TEST_NUM);
        for (int i=0; i<TEST_NUM; i++){
            arrayListSize.add("hxt");
        }
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));
    }

    public static void main(String[] args) throws RunnerException {
        /*Options opt = new OptionsBuilder()
                .include(CollectionTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();*/

        arrayList();
        arrayListSize();
    }
}
