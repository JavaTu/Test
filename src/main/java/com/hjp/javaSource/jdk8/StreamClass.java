package com.hjp.javaSource.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。
 * @author huangjp 2019/9/23 4:18 PM
 **/
public class StreamClass {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,3,2,5);

        // foreach
        list.stream().forEach(each -> System.out.println(each));

        // 过滤
        list = list.stream().filter(Integer -> Integer > 1).collect(Collectors.toList());
        System.out.println(list);

        // map:映射每个元素到对应的结果
        list = list.stream().map(i -> i*i).collect(Collectors.toList());
        System.out.println(list);

        // sorted排序
        list = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list);

        // limit
        list = list.stream().limit(3).collect(Collectors.toList());
        System.out.println(list);

        // ....

    }


}
