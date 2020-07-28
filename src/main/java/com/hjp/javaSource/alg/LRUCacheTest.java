package com.hjp.javaSource.alg;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: LRUTest
 * @Description:
 * @Author: huangjp
 * @Date: 2020/7/28 17:33
 */
public class LRUCacheTest<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_CACHE_SIZE;

    public LRUCacheTest(int cacheSize){
        super(cacheSize, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    /**
     * 淘汰机制
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    public static void main(String[] args) {

        Map linkedHashMap = new LinkedHashMap<String, String>(2, 0.75f, true);
        Map lruCacheMap = new LRUCacheTest<String, String>(2);

        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";

        linkedHashMap.put(key1, value1);
        linkedHashMap.put(key2, value2);
        linkedHashMap.get(key2);
        linkedHashMap.get(key1);
        linkedHashMap.put(key3, value3);

        lruCacheMap.put(key1, value1);
        lruCacheMap.put(key2, value2);
        lruCacheMap.get(key2);
        lruCacheMap.get(key1);
        lruCacheMap.put(key3, value3);

        System.out.println("LinkedHashMap：" + linkedHashMap.values());
        System.out.println("LRUCacheMap：" + lruCacheMap.values());
    }
    /**
     * LinkedHashMap：[value2, value1, value3]
     * LRUCacheMap：[value1, value3]，可见是淘汰了头部的元素
     */
}
