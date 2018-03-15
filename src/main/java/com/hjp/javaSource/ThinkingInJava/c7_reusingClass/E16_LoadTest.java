package com.hjp.javaSource.ThinkingInJava.c7_reusingClass;

/**
 * @author huangjp 2017-9-21 14:24
 * static final 类 继承的初始化及加载顺序
 *      1、类的构造方法只会执行一次
 **/
public class E16_LoadTest extends BaseClass{

    private int k = initInt("加载导出类的非静态属性");

    private static int x2 = initInt("加载导出类的static属性");

    private E16_LoadTest(){
        System.out.println("进入导出类 -- 构造函数（static方法）");
    }

    public static void main(String[] args) {
        E16_LoadTest test = new E16_LoadTest();
    }
    /* Output :
            加载基类的static属性                          //1、加载基类的静态属性、方法
            加载导出类的static属性                        //2、加载导出类的静态属性、方法
            进入基类 -- 构造函数(static方法)               //3、加载基类的构造方法（构造方法是隐性的static方法）
            加载导出类的非静态属性                         //4、加载导出类的属性
            进入导出类 -- 构造函数（static方法）            //5、加载导出类的构造方法
     */
}

class BaseClass{

    private static int x1 = initInt("加载基类的static属性");        //类的static属性只会初始化一次，并且在第一次加载类时初始化

    BaseClass(){
        System.out.println("进入基类 -- 构造函数(static方法)");
    }

    static int initInt(String s){
        System.out.println(s);
        return 47;
    }
}

/**
 * 类的static方法，调用一次就会加载一次（构造函数是隐性的static方法，就是个很好的例子）
 */
class LoadOnce{

    public static void main(String[] args) {

        BaseClass.initInt("call类的静态方法");  //call类的静态方法，会先加载该类的静态属性（因为是第一次加载此类，其次静态属性也只会执行一次）

        System.out.println("-------------------");

        BaseClass baseClass = new BaseClass();  //只有创建类时才会加载类的构造函数， 每次创建类都会加载一次构造函数
    }
    /*
        Output :
            加载类的静态属性
            call类的静态方法
            -------------------
            进入基类 -- 构造函数
     */
}

/**
 * 与LoadOnce2形成对比，验证加载类的静态属性的动作只会执行一次，并且是在第一次加载类时执行。
 */
class LoadOnce2{

    public static void main(String[] args) {

        BaseClass baseClass = new BaseClass();

        System.out.println("-------------------");

        BaseClass.initInt("call类的静态方法");
    }
    /*
        Output :
            加载类的静态属性
            进入基类 -- 构造函数
            -------------------
            call类的静态方法
     */
}
