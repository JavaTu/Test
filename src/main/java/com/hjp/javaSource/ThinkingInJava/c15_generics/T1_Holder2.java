package com.hjp.javaSource.ThinkingInJava.c15_generics;

import com.hjp.javaSource.ThinkingInJava.PublicEntity;

/**
 * @author huangjp 2018-03-15 19:17
 * 15.2示例1：在Java SE5之前（没有泛型之前），我们可以直接让这个类直接持有Object类型的对象，获取时必须强制转换成你需要的类型
 **/
public class T1_Holder2 {

    private Object a;

    public T1_Holder2(Object a) {
        this.a = a;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public static void main(String[] args) {
        T1_Holder2 h2 = new T1_Holder2(new PublicEntity());
        PublicEntity publicEntity = (PublicEntity) h2.getA();   //没有泛型前，必须手动强制转换类型
        h2.setA("Not an PublicEntity");
        String s = (String) h2.getA();
        h2.setA(1);
        int i = (int) h2.getA();
    }
}

/**
 * 15.2示例2：泛型类，T是类型参数，告诉编译器想使用什么类型，然后编译器帮你处理一切细节
 * @param <T>
 */
class Holder3<T>{

    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {

        Holder3<PublicEntity> h3 = new Holder3<>(new PublicEntity());
        PublicEntity publicEntity = h3.getA();          //无需手动转换，编译器帮你处理一切细节
        h3.setA(new PublicEntity());
    }
}
