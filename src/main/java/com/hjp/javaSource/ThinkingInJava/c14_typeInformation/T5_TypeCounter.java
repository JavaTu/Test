package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

import java.util.*;

/**
 * @author huangjp 2018-03-19 15:34
 * 14.3.3递归计数示例：与预加载映射表不同，我们可以使用Class.isAssignableForm()，并创建一个局限于对Pet计数的通用工具
 * Class.isAssignableFrom()执行运行时的检查，以校验你传递的对象确实属于我们感兴趣的继承结构
 * 完成了一件什么事情：对父类下所有子类进行一个计数
 **/
public class T5_TypeCounter extends HashMap<Class<?>, Integer>{

    private Class<?> baseType;

    public T5_TypeCounter(Class<?> baseType){
        this.baseType = baseType;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()){
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("}");
        return result.toString();
    }

    private void countClass(Class<?> type){
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity+1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass))
            countClass(superClass);
    }

    public void count(Object obj){
        Class<?> type = obj.getClass();
        if (!baseType.isAssignableFrom(type))
            throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of " + baseType);
        countClass(type);
    }
}

class Pet{}

class Dog extends Pet{}

class Cat extends Pet{}

class PetCount{
    public static void main(String[] args) {
        T5_TypeCounter counter = new T5_TypeCounter(Pet.class);
        List<Pet> pets = createArray(4);
        for (Pet pet : pets){
            System.out.println(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
            System.out.println(counter);
        }

    }

    private static List<Pet> createArray(int size){
        List<Class<? extends Pet>> types = Arrays.asList(Dog.class, Cat.class);
        List<Pet> pets = new ArrayList<>();
        Random random = new Random(47);

        for (int i = 0; i < size; i++){
            try {
                pets.add(types.get(random.nextInt(types.size())).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return pets;
    }
}
/*
    Output : Cat
            {Pet=1, Cat=1}
            Dog
            {Pet=2, Cat=1, Dog=1}
            Cat
            {Pet=3, Cat=2, Dog=1}
            Dog
            {Pet=4, Cat=2, Dog=2}
 */
