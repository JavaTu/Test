package com.hjp.javaSource.ThinkingInJava.c10_innerClasses;

/**
 * @author huangjp 2017-10-19 14:01
 * 迭代器模式中对.this和.new的使用
 **/
public class E04_SequenceSelectorToSequence {

    private static final int size = 5;

    public static void main(String[] args) {

        //先输入
        Sequence1 sequence1 = new Sequence1(size);
        for (int i = 0; i < size; i++) {
            sequence1.add(i);
        }

        System.out.println(sequence1.check());      //对.this的使用

        //后输出
        Selector1 selector1 = sequence1.new SequenceSelector();    //对.new的使用
        while (!selector1.end()) {
            System.out.print(selector1.current() + " ");
            selector1.next();
        }
    }
    /*
        Output :
            true
            0 1 2 3 4
     */
}

interface Selector1{
    /**
     * 是否为最后一个
     */
    boolean end();

    /**
     * 返回当前对象
     */
    Object current();

    /**
     * 下一步
     */
    void next();
}

class Sequence1{

    private static Object[] items;

    private static int next;

    Sequence1(int size) {
        items = new Object[size];
    }

    void add(Object o){
        if (next < items.length) {
            items[next++] = o;            //旧代码为：items[next] = o; next++; 重构为：items[next++] = o;
        }
    }

    class SequenceSelector implements Selector1{

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        Sequence1 getSequence(){
            return Sequence1.this;
        }
    }

    public boolean check(){
        return
                this == new SequenceSelector().getSequence();
    }

}



