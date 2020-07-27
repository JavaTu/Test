package com.hjp.javaSource.anotherPackage;

import com.hjp.javaSource.javaSe.ProtectedClass;

/**
 * @author huangjp 2019/9/23 4:04 PM
 **/
public class ProtectedChildClass extends ProtectedClass {

    public void f(){
        protectedMethod();  //不同包子类可访问父类的protected方法
    }
}
