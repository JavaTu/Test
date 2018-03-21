package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author huangjp 2018-03-19 17:36
 * 14.4注册工厂示例：使用工厂方法设计模式将对象的创建工作交给类自己去完成
 *
 **/
public class T6_RegisteredFactories {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(Part.createRandom());
        }
    }
}
/*
    Output : FanBelt
            AirFilter
            FanBelt
            FuelFilter
            FuelFilter
            FanBelt
            FuelFilter
            AirFilter
            FanBelt
            FanBelt
 */

/**
 * 基类:部件，负责随机生成部件
 */
class Part{
    private static Random random = new Random(47);

    static List<T6_Factory<? extends Part>> partFactories = new ArrayList<>();

    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    public static Part createRandom(){
        int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}



/**
 * 类型1：过滤器
 */
class Filter extends Part {}

/**
 * 类型2：皮带
 */
class Belt extends Part {}

/**
 * 实体类1：燃油滤清器
 * 内部类Factory实现工厂接口，返回一个对象
 */
class FuelFilter extends Filter{
    public static class Factory implements T6_Factory{
        @Override
        public Object create() {
            return new FuelFilter();
        }
    }
}

/**
 * 实体类2：空气过滤器
 */
class AirFilter extends Filter{
    public static class Factory implements T6_Factory{
        @Override
        public Object create() {
            return new AirFilter();
        }
    }
}

/**
 * 实例3：风扇皮带
 */
class FanBelt extends Belt{
    public static class Factory implements T6_Factory{
        @Override
        public Object create() {
            return new FanBelt();
        }
    }
}

/**
 * 实例4：发电机皮带
 */
class GeneratorBelt extends Belt{
    public static class Factory implements T6_Factory{
        @Override
        public Object create() {
            return new GeneratorBelt();
        }
    }
}


