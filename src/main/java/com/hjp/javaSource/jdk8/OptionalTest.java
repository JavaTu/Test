package com.hjp.javaSource.jdk8;

import java.util.Optional;

/**
 * 一个可以用来预防空指针异常的类
 * @author huangjp 2019/9/25 3:57 PM
 **/
public class OptionalTest {

    public static void main(String[] args) throws Exception {
        User user = null;
        //System.out.println(user.getName());     //肯定报错了：java.lang.NullPointerException

        //Optional.ofNullable(user).orElseThrow(() -> new Exception("用户不存在"));    // 更优雅
        User opUser = Optional.ofNullable(user).orElse(genUser());    // 更优雅
        //Optional.ofNullable(user).orElseGet(() -> genUser());    // 更优雅

        System.out.println(opUser.getName());
    }

    private static User genUser(){
        User user = new User();
        user.setName("张三");
        return user;
    }



}

class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
