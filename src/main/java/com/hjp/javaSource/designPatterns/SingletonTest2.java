package com.hjp.javaSource.designPatterns;

/**
 * @ClassName: SingleTest2
 * @Description: 枚举单例模式
 * @Author: huangjp
 * @Date: 2020/6/9 11:57
 */
public enum SingletonTest2 {

    INSTANCE;

    public static SingletonTest2 getInstance(){

        return INSTANCE;
    }
}
