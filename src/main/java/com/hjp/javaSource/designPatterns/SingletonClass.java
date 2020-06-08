package com.hjp.javaSource.designPatterns;

/**
 * @ClassName: SingletonClass
 * @Description: 常规单例模式：懒汉式、双重检查、volatile
 * @Author: huangjp
 * @Date: 2020/6/8 13:59
 */
public class SingletonClass {

    private static volatile SingletonClass INSTANCE;

    private SingletonClass() {}

    public static SingletonClass getInstance () {
        if (INSTANCE == null){
            synchronized (SingletonClass.class){
                if (INSTANCE == null){
                    INSTANCE = new SingletonClass();
                }
            }
        }

        return INSTANCE;
    }
}
