package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

/**
 * @author huangjp 2018-03-21 15:21
 * 14.7：静态代理的示例
 * 代理原则：对扩展开放，对修改关闭，封装修改：https://www.cnblogs.com/lixiuyu/p/5919643.html
 **/
public class T8_SimpleProxyDemo {

    public static void consumer(Interface iface){
        iface.doSomething();
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
/*
    Output : RealObject doSomething...
            SimpleProxy let com.hjp.javaSource.ThinkingInJava.c14_typeInformation.RealObject@66492ff1 doSomething...
            RealObject doSomething...
 */

/**
 * 代理接口（通用方法）
 */
interface Interface{

    void doSomething();
}

/**
 * 真实的对象类
 */
class RealObject implements Interface{
    @Override
    public void doSomething() {
        System.out.println("RealObject doSomething...");
    }
}

/**
 * 代理类（实现代理接口，组合代理接口）
 */
class SimpleProxy implements Interface{

    //被代理对象
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy let " + proxied.toString() + " doSomething...");
        proxied.doSomething();
    }
}
