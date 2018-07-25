package com.hjp.javaSource.DesignPatterns;

/**
 * @author huangjp 2018/7/25 13:01
 *
 * 单例模式之懒汉式1：双重检查（线程安全；延迟加载；效率较高）
 *
 * 参考：https://www.cnblogs.com/zhaoyan001/p/6365064.html
 **/
public class LazySingleton1 {

    private volatile static LazySingleton1 singleton;    //这里的volatile有什么用？

    private LazySingleton1(){}                           //私有的构造方法

    public static LazySingleton1 getSingle(){
        if (singleton == null){
            synchronized (LazySingleton1.class){
                if (singleton == null){                  //双重检查
                    singleton = new LazySingleton1();
                }
            }
        }
        return singleton;
    }
}

/**
 * 懒汉式2：使用静态内部类，采用了类装载的机制来保证初始化实例时只有一个线程（避免了线程不安全，延迟加载，效率高。）
 *
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 */
class LazySingleton2{

    private LazySingleton2(){}

    private static class SingletonInstance{
        private static final LazySingleton2 SINGLETON = new LazySingleton2();
    }

    public static LazySingleton2 getSingle(){
        return SingletonInstance.SINGLETON;
    }

}