package com.hjp.javaSource.jdk8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Test {

    /**
     * @Description:
     * @Author: huangjp
     * @Date: 2021-06-07 17:25
     * @Param: 
     * @Return:
     */
    public static void main(String[] args) {
        String key = "testString?java8";
        System.out.println("key = " + key);

        // 加码
        String base64EncodedString = Base64.getEncoder().encodeToString(key.getBytes(StandardCharsets.UTF_8));
        System.out.println("base64EncodedString = " + base64EncodedString);

        // 解码
        byte[] base64DecodedBytes = Base64.getDecoder().decode(base64EncodedString);
        System.out.println(base64DecodedBytes);

    }
}
