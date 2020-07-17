package com.hjp.javaSource.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 一个可以用来预防空指针异常的类
 * @author huangjp 2019/9/25 3:57 PM
 **/
public class OptionalTest {

    public static void main(String[] args) throws Exception {
        List<User> users = Arrays.asList(genUser(), null);
        for (User each:users){
            User defaultUser = new User();
            Optional<User> optional = Optional.ofNullable(each);
            // 如果存在该值，返回值， 否则返回 other
            User result1 = optional.orElse(defaultUser);
            System.out.println(result1);
            // 如果存在该值，返回值， 否则触发 other，并返回 other 调用的结果
            User result2 = optional.orElseGet(OptionalTest::genUser);
            System.out.println(result2);
            // 如果存在该值，返回包含的值，否则抛出由 Supplier 继承的异常
            optional.orElseThrow(() -> new Exception("用户不存在"));
        }
    }

    private static User genUser(){
        User user = new User();
        user.setName("张三");
        return user;
    }
}

class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
