package com.hjp.javaSource.ThinkingInJava.c18_io;

import java.io.*;

/**
 * @author huangjp 2018/7/17 17:37
 * I/O流的典型使用方式：格式化的内存输入，这个格式化如何理解？
 **/
public class T03_FormattedMemoryInput {

    public static void main(String[] args){

        DataInputStream in = new DataInputStream(new ByteArrayInputStream(T03_BufferedInputFile.read("doc/a.txt").getBytes()));
        InputStreamReader in2 = new InputStreamReader(new ByteArrayInputStream(T03_BufferedInputFile.read("doc/a.txt").getBytes()));
        try {
            System.out.print("DataInputStream output: ");
            while (in.available() != 0)
                System.out.print((char)in.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");
        try {
            System.out.print("Reader output: ");
            int c1;
            while ((c1 = in2.read()) != -1)
                System.out.print((char)c1);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
/*
    Output :
        DataInputStream output: Hello, I'm a!   ä½ å¥½ï¼ææ¯a!
        -----------------
        Reader output: Hello, I'm a!   你好，我是a!
 */