package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author huangjp 2018-03-19 18:15
 * T6_RegisteredFactories的升级版：代码简化很多，统一实例化，无需在每个实例中创建内部类实现生产接口
 **/
public class E14_RegisteredFactories {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        for (int i = 0 ; i < 10; i++)
            System.out.println(Part2.createRandom());
    }
}
/*
    Output : FanBelt2
            AirFilter2
            FanBelt2
            FuelFilter2
            FuelFilter2
            FanBelt2
            FuelFilter2
            AirFilter2
            FanBelt2
            FanBelt2
 */

class Part2{

    private static Random random = new Random(47);

    static List<Class<? extends Part2>> part2s = Arrays.asList(FuelFilter2.class, AirFilter2.class,
            FanBelt2.class, GeneractorBelt2.class);     //为什么static List<Class<? extends Part2>> part2s = Arrays.asList(FuelFilter2.class, AirFilter2.class);会报错？

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public static Part2 createRandom(){
        int n = random.nextInt(part2s.size());
        try {
            return part2s.get(n).newInstance();
        } catch (Exception e) {
            throw  new RuntimeException("实例化失败");
        }
    }
}

class Filter2 extends Part2{}

class Belt2 extends Part2{}

class FuelFilter2 extends Filter2{}

class AirFilter2 extends Filter2{}

class FanBelt2 extends Belt2{}

class GeneractorBelt2 extends Belt2{}