package com.hjp.javaSource.javaSe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName: Reflect
 * @Description: 反射测试类
 * @Author: huangjp
 * @Date: 2020/6/8 14:26
 */
public class ReflectTest {

    /**
     * 反射
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("java.lang.String");
        clazz = String.class;
        clazz = new String().getClass();

        // 调用有参构造方法
        Constructor con = clazz.getConstructor(String.class);
        String myString = new String("MyString");
        Object obj = con.newInstance(myString);
        System.out.println("构造：" + obj);

        // 获取所有属性
        Field[] fields = clazz.getFields();
        System.out.println("fields'length：" + fields.length);

        // 获取所有方法
        Method[] methods = clazz.getMethods();
        System.out.println("methods'length：" + methods.length);

        // 调用指定方法
        Method method = clazz.getMethod("hashCode");
        method.setAccessible(true); // 设置私有方法可访问
        Object result = method.invoke(obj);
        System.out.println(myString + "'s hashCode：" + result);
    }
}
