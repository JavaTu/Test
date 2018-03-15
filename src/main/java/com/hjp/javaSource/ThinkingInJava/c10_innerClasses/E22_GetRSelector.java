package com.hjp.javaSource.ThinkingInJava.c10_innerClasses;

/**
 * @author huangjp 2017-11-14 13:44
 * 内部类没有令人迷惑的"is-a"关系，它就是一个独立的实体
 * 使用内部类创建两个序列，一个顺序，一个倒序，证明内部类更灵活
 **/
public class E22_GetRSelector {

    public static void main(String[] args) {

        int size = 10;
        Sequence2 sequence2 = new Sequence2(size);
        for (int i = 0; i <size; i++)
            sequence2.add(i);

        Selector selector = sequence2.makeR();
        while (!selector.end()){
            System.out.print(selector.current() + " ");
            selector.next();
        }

        System.out.print("\n");
        System.out.println("------------- InnerClass -------------");

        Selector selector1 = sequence2.makeS();
        while (!selector1.end()){
            System.out.print(selector1.current() + " ");
            selector1.next();
        }
    }
    /*
        Output :
                9 8 7 6 5 4 3 2 1 0
                ------------- InnerClass -------------
                0 1 2 3 4 5 6 7 8 9
     */
}

class Sequence2{

    private int next;

    private Object[] objects;

    Sequence2(int size) {
        objects = new Object[size];
    }

    void add(Object o){
        if (next < objects.length)
            objects[next++] = o;
    }

    /**
     * 倒序
     */
    private class ReverseSelector implements Selector{

        private int index = objects.length - 1;

        @Override
        public boolean end() {
            return (index < 0);
        }

        @Override
        public Object current() {
            return objects[index];
        }

        @Override
        public void next() {
            if (index >= 0)
                index--;
        }
    }

    /**
     * 顺序
     */
    private class SequenceSelector implements Selector{

        private int index;

        @Override
        public boolean end() {
            return (index == objects.length);
        }

        @Override
        public Object current() {
            return objects[index];
        }

        @Override
        public void next() {
            if (index < objects.length)
                index++;
        }
    }

    Selector makeR(){
        return new ReverseSelector();
    }

    Selector makeS(){
        return new SequenceSelector();
    }
}
