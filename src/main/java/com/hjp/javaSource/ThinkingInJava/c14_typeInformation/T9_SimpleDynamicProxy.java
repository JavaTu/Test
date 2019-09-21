package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author huangjp 2018-03-21 15:33
 * 14.6动态代理：由T8_SimpleProxyDemo升级来的动态代理，可以动态的创建代理并动态的处理对所代理方法的调用
 * 参考：https://www.jianshu.com/p/95970b089360
 **/
public class T9_SimpleDynamicProxy{

    public static void consumer(Interface iface){
        iface.doSomething();
    }

    public static void main(String[] args) {
        RealObject object = new RealObject();
        Interface proxy = (Interface)Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                new DynamicProxyHandler(object));
        consumer(proxy);
    }
}
/*
    Output : ***** proxy : class com.hjp.javaSource.ThinkingInJava.c14_typeInformation.$Proxy0, method : public abstract void com.hjp.javaSource.ThinkingInJava.c14_typeInformation.Interface.doSomething(), args :null
            RealObject doSomething...
 */

/**
 * 代理生成器
 */
class DynamicProxyHandler implements InvocationHandler{

    //被代理者
    private Object obj;

    public DynamicProxyHandler(Object object) {
        this.obj = object;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}