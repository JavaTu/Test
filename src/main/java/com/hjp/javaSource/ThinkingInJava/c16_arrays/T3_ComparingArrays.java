package com.hjp.javaSource.ThinkingInJava.c16_arrays;

import com.hjp.javaSource.ThinkingInJava.PublicEntity;

import java.util.Arrays;

/**
 * @author huangjp 2018-03-14 19:41
 * 16.7.2示例：数组的比较（对象数组）
 **/
public class T3_ComparingArrays {

    public static void main(String[] args) {
        PublicEntity entity1 = new PublicEntity();
        PublicEntity entity2 = new PublicEntity();

        PublicEntity[] entities1 = {entity1, entity2};
        PublicEntity[] entities2 = {entity1, entity2};
        PublicEntity[] entities3 = {new PublicEntity(), new PublicEntity()};
        PublicEntity[] entities4 = {new PublicEntity(), new PublicEntity()};

        System.out.println(Arrays.equals(entities1, entities2));
        System.out.println(Arrays.equals(entities3, entities4));
    }
    /*
        Output : true
                false

     */

}
