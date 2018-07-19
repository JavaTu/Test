package com.hjp.javaSource.ThinkingInJava.c18_io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author huangjp 2018/7/18 15:40
 * 认识RandomAccessFile.java 一个不同于其他I/O类型，自我独立的类
 **/
public class T04_RandomAccessFile {

    public static void main(String[] args) throws IOException {
        RandomAccessFile f = new RandomAccessFile("doc/a.txt", "r");
        long l = f.length();
        System.out.println("The length is:"+l);
        long p = f.getFilePointer();
        while (p < l){
            System.out.println(p + ":" + (char)f.read());   //中文乱码
            p++;
            //f.seek(++p);
        }

        RandomAccessFile rw = new RandomAccessFile("doc/d.java", "rw");
        rw.writeUTF("你好，RandomAccessFile!");
        rw.close();

        RandomAccessFile r = new RandomAccessFile("doc/d.java", "r");
        System.out.println(r.readUTF());
    }
}
/*
    Output :
        The length is:33
        0:H
        1:e
        2:l
        3:l
        4:o
        5:,
        6:
        7:I
        8:'
        9:m
        10:
        11:a
        12:!
        13:
        14:
        15:
        16:ä
        17:½
        18: 
        19:å
        20:¥
        21:½
        22:ï
        23:¼
        24:
        25:æ
        26:
        27:
        28:æ
        29:
        30:¯
        31:a
        32:!
        你好，RandomAccessFile!
 */