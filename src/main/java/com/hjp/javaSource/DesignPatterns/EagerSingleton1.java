package com.hjp.javaSource.DesignPatterns;

/**
 * @author huangjp 2018/7/25 13:10
 *
 * 单例模式之饿汉式1
 *
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 *
 * 参考：https://www.cnblogs.com/zhaoyan001/p/6365064.html
 **/
public class EagerSingleton1 {

    private static final EagerSingleton1 EAGER_SINGLETON = new EagerSingleton1();

    private EagerSingleton1(){}

    public static EagerSingleton1 getSingleton(){
        return EAGER_SINGLETON;
    }
}

class EagerSingleton2{

    private static EagerSingleton2 eagerSingleton;

    private EagerSingleton2(){}

    static {
        eagerSingleton = new EagerSingleton2();
    }

    public static EagerSingleton2 getSingleton(){
        return eagerSingleton;
    }
}
