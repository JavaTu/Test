package com.hjp.javaSource.designPatterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 参考：https://juejin.im/post/5c1ca8df6fb9a049b347f55c#heading-8
 */
public class JDKDynamicProxy{

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        RealObject object = new RealObject();
        Interface proxy = (Interface)Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                new DynamicProxyHandler(object));
        proxy.f();
    }
}
/*
    Output : ***** proxy : class com.hjp.javaSource.ThinkingInJava.c14_typeInformation.$Proxy0, method : public abstract void com.hjp.javaSource.ThinkingInJava.c14_typeInformation.Interface.doSomething(), args :null
            RealObject doSomething...
 */

/**
 * 代理接口（通用方法）
 */
interface Interface{
    void f();
}

/**
 * 代理生成器
 */
class DynamicProxyHandler implements InvocationHandler{

    //被代理者
    private Object target;

    public DynamicProxyHandler(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}

/**
 * 被代理类
 */
class RealObject implements Interface{
    @Override
    public void f() {
        System.out.println("RealObject doSomething...");
    }
}