package com.hjp.javaSource.alg;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: Test
 * @Description:
 * @Author: huangjp
 * @Date: 2020/8/13 13:37
 */
public class Test {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "a", "c", "d", "c", "e", "b"};
        List<String> list = Arrays.asList(arr);

        Map<String, Integer> map = new HashMap<>();
        list.forEach(key -> {
            if (map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }else {
                map.put(key, 1);
            }
        });

        Set<String> keys = map.keySet();
        for (String key:keys){
            if (map.get(key) >= 2){
                System.out.println(key);
            }
        }

        List<String> listSorted = list.stream().sorted().collect(Collectors.toList());
        System.out.println(listSorted);
    }
}
