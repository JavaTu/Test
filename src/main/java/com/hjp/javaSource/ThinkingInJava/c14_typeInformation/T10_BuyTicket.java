package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author huangjp 2018-03-21 16:46
 * 动态代理实例之代理购票
 **/
public class T10_BuyTicket {

    public static void main(String[] args) {

        //购票人信息
        User user = new User("张三");
        //创建一个代理对象
        IProxy realProxy1 = new RealProxy(user);
        //将这个代理(IProxy)指定为某个其他对象的代理对象，在调用处理器的invoke()方法中采取代理，一方面将调用传递给真实对象(RealProxy)，另一方面执行各种需要做的操作
        IProxy iProxy = (IProxy)Proxy.newProxyInstance(realProxy1.getClass().getClassLoader(), new Class[]{IProxy.class}, new DynamicProxy(realProxy1));
        iProxy.bugTicket();

        //测试发现：到底选择哪一个代理对象，由classLoader决定
        User lisi = new User("李四");
        RealProxy2 realProxy2 = new RealProxy2(lisi);
        IProxy proxy2 = (IProxy)Proxy.newProxyInstance(realProxy2.getClass().getClassLoader(), new Class[]{IProxy.class}, new DynamicProxy(realProxy2));
        proxy2.bugTicket();



    }
}
/*
    Output : 欢迎来到代理购票系统一
            客户：张三需要购票
            出票中....
            购票成功
            ******************************************
            欢迎来到代理购票系统二
            客户：李四需要购票
            出票中....
            购票成功
 */

/**
 * 代理
 */
interface IProxy{
    void bugTicket();
}

/**
 * 调用处理器（动态代理的核心）
 */
class DynamicProxy implements InvocationHandler{

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println("Before Method :" + method);
        Object o = method.invoke(object, args);
        //System.out.println("After Method :" + method);
        return o;
    }
}

/**
 * 代理对象（代理售票机构一：什么人都能找他买票）
 */
class RealProxy implements IProxy{

    private User user;

    public RealProxy(User user) {
        this.user = user;
    }

    @Override
    public void bugTicket() {
        if (user != null){
            System.out.println("欢迎来到代理购票系统一");
            System.out.println("客户：" + user.getName() + "需要购票");
            System.out.println("出票中....");
            System.out.println("购票成功");
            System.out.println("******************************************");
        }
    }
}

class RealProxy2 implements IProxy{

    private User user;

    public RealProxy2(User user) {
        this.user = user;
    }

    @Override
    public void bugTicket() {
        if (user != null){
            System.out.println("欢迎来到代理购票系统二");
            System.out.println("客户：" + user.getName() + "需要购票");
            System.out.println("出票中....");
            System.out.println("购票成功");
        }
    }
}

class User{
    private String name;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }
}