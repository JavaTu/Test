package com.hjp.javaSource.ThinkingInJava.c18_io;

import java.io.*;

/**
 * @author huangjp 2018/7/17 17:58
 * I/O流的典型使用方式：缓冲输入文件
 **/
public class T03_BufferedInputFile {

    public static void main(String[] args) {
        System.out.println(read("doc/a.txt"));
    }

    public static String read(String fileName){
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = in.readLine()) != null)
                sb.append(s + "\n");
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/*
    Output : Hello, I'm a!   你好，我是a!
 */