package com.hjp.javaSource.ThinkingInJava.c17_containersInDepth;

import com.hjp.javaSource.ThinkingInJava.Generator;

import java.util.ArrayList;

/**
 * @author huangjp 2018-03-09 14:36
 * 对象容器类
 **/
public class CollectionData<T> extends ArrayList<T>{

    /**
     * 构造函数（生成包含n个对象的容器）
     * @param gen 对象生成器
     * @param quantity 数量
     */
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }

    /**
     * 生成包含n个对象的容器并返回
     */
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
        return new CollectionData<>(gen, quantity);
    }
}
