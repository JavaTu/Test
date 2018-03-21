package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjp 2018-03-16 16:47
 * 14.2.2泛化的Class引用的示例：泛型类语法
 **/
public class T3_FilledList<T> {

    private Class<T> type;

    public T3_FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements){
        List<T> result = new ArrayList<T>();
        for (int i = 0 ; i < nElements; i++)
            try {
                result.add(type.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        return result;
    }

    public static void main(String[] args) {
        T3_FilledList<CountedInteger> filledList = new T3_FilledList<>(CountedInteger.class);
        System.out.println(filledList.create(15));
    }
}
/*
    Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
 */

class CountedInteger{
    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}
