package com.hjp.javaSource.designPatterns;

/**
 * @ClassName: SingletonTest
 * @Description: 单例模式，详细笔记可见：https://app.yinxiang.com/shard/s72/nl/14947733/e715da91-f10e-4900-a931-6b357daf8eb4
 * @Date: 2020/2/10 14:18
 * @Created by huangjuping
 */
public class SingletonTest {

    private static volatile SingletonTest INSTANCE; // volatile主要用于防止指令的重排序，static是因为genInstance是静态的，由于私有的构造方法，外部只能通过SingletonTest.genInstance();生成对象，所以方法需要加上static

    private SingletonTest(){

    }

    public static SingletonTest genInstance(){
        if (INSTANCE == null){
            synchronized (SingletonTest.class){
                if (INSTANCE == null) {
                    INSTANCE = new SingletonTest();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0; i<50; i++){
            System.out.println(SingletonTest.genInstance());
        }
    }

}
