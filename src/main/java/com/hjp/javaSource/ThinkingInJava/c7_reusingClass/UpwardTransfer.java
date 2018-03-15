package com.hjp.javaSource.ThinkingInJava.c7_reusingClass;

/**
 * @author huangjp 2017-9-20 14:56
 * 向上转型
 **/
public class UpwardTransfer {

    public void play(){
        System.out.println("基类执行play方法");
    }

    public static void f(UpwardTransfer u){
        System.out.println("基类执行f方法，对象" + u + "开始请求play方法");
        u.play();
    }
}

/**
 * 导出类
 */
class ChildClass extends UpwardTransfer{

    public static void main(String[] args) {
        ChildClass c = new ChildClass();
        System.out.println("导出类开始请求基类的f方法");
        UpwardTransfer.f(c);    //即时这里我传递的是导出类，但会自动向上转型为基类，来请求play方法
    }

    /*
         output : 导出类开始请求基类的f方法
                  基类执行f方法，对象com.hjp.javaSource.ThinkingInJava.c7_reusingClass.ChildClass@4b1210ee开始请求play方法
                  基类执行play方法
     */
}

class ChildClass2 extends UpwardTransfer{

    public static void f(UpwardTransfer u){
        System.out.println("导出类重载f方法，对象" + u + "开始请求play方法");
        u.play();
    }

    public static void main(String[] args) {
        ChildClass2 c = new ChildClass2();
        System.out.println("导出类开始请求基类的f方法");
        UpwardTransfer.f(c);
    }

}