package com.hjp.javaSource.designPatterns;

/**
 * @ClassName: SingletonTest1
 * @Description: 内部类单例模式
 * @Author: huangjp
 * @Date: 2020/6/9 11:57
 */
public class SingletonTest1 {

    private SingletonTest1() {}

    public static SingletonTest1 getInstance() {
        return Mgr01Holder.INSTANCE;
    }

    private static class Mgr01Holder {
        private static final SingletonTest1 INSTANCE = new SingletonTest1();
    }
}
