package com.hjp.javaSource.studyClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjp 2018/7/2 14:02
 **/
public class HashMapTest {

    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<>();
        Map<Integer, String> m2 = new HashMap<>();

        m1.put(1, "1");
        m1.put(2, "2");
        m1.put(3, "3");
        m2.put(4, "1");
        m2.put(5, "2");
        m2.put(6, "3");

        System.out.println(m2.get(5));
        System.out.println(m2.remove(5));

    }




    /*final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //如果tab为空的话，则进行初始化，并将初始化后的长度传给n
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //如果hash（此hash为hash(key)）不存在，也就是不重复（冲突），则生成新的节点存入数组
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        //如果hash已存在
        else {
            Node<K,V> e; K k;
            //如果hash相同并且key相同，则将临时指针e指向p
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            //如果e存在，即key已存在，则更新此key对应的value为当前传入的value，并返回value对象
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }*/

}
