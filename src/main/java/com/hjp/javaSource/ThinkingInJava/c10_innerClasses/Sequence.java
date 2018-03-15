package com.hjp.javaSource.ThinkingInJava.c10_innerClasses;

/**
 * @author huangjp 2017-10-18 16:18
 * 内部类可以访问外部类的成员示例（迭代器设计模式的例子）
 **/
public class Sequence {

    private Object[] items;

    private int next = 0;

    private Sequence(int size) {
        items = new Object[size];
    }

    private void add(Object x){
        if (next < items.length) {
            items[next++] = x;
        }
    }

    /**
     * 序列选择器
     */
    private class SequenceSelector implements Selector{

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
    }

    private Selector getSelector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {

        //先输入
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }

        //再输出
        Selector selector = sequence.getSelector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        /*
            Output : 0 1 2 3 4 5 6 7 8 9
         */
    }
}

/**
 * 选择器
 */
interface Selector{
    boolean end();

    Object current();

    void next();
}


