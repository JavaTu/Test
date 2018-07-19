package com.hjp.javaSource.ThinkingInJava.c18_io;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author huangjp 2018/7/17 17:54
 * I/O流的典型使用方式：从内存输入
 **/
public class T03_MemoryInput {

    public static void main(String[] args) {
        try {
            StringReader in = new StringReader(T03_BufferedInputFile.read("doc/a.txt"));
            int c;
            while ((c = in.read()) != -1)
                System.out.println("int = "+c + ", char = "+(char)c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Output :
            int = 72, char = H
            int = 101, char = e
            int = 108, char = l
            int = 108, char = l
            int = 111, char = o
            int = 44, char = ,
            int = 32, char =
            int = 73, char = I
            int = 39, char = '
            int = 109, char = m
            int = 32, char =
            int = 97, char = a
            int = 33, char = !
            int = 32, char =
            int = 32, char =
            int = 32, char =
            int = 20320, char = 你
            int = 22909, char = 好
            int = 65292, char = ，
            int = 25105, char = 我
            int = 26159, char = 是
            int = 97, char = a
            int = 33, char = !
            int = 10, char =
 */
