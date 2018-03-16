package com.hjp.javaSource.ThinkingInJava.c15_generics;

import java.util.Iterator;
import java.util.Random;

/**
 * @author huangjp 2018-03-15 19:58
 * 15.3示例：咖啡生成器（包含迭代器）
 **/
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>{

    private static Random random = new Random(47);

    private int size = 0;

    private Class[] types = {Latte.class, Mocha.class, Breve.class};

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    public CoffeeGenerator() {}

    @Override
    public Coffee next() {
        try {
            return (Coffee)types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 内部类：咖啡迭代器
     */
    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public CoffeeIterator(int count) {
            this.count = count;
        }
    }

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator(size);
    }

    public static void main(String[] args) {

        System.out.println("随机生成咖啡方法一：");
        for (int i = 0; i < 5; i++)
            System.out.println(new CoffeeGenerator().next());

        System.out.println("随机生成咖啡方法二（使用迭代器）：");
        for (Coffee c : new CoffeeGenerator(5))
            System.out.println(c);

    }
    /*
        Output : 随机生成咖啡方法一：
                Breve 0
                Breve 1
                Mocha 2
                Breve 3
                Mocha 4
                随机生成咖啡方法二（使用迭代器）：
                Breve 5
                Mocha 6
                Breve 7
                Latte 8
                Mocha 9
     */
}


