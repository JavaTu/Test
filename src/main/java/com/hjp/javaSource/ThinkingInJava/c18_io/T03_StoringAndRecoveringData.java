package com.hjp.javaSource.ThinkingInJava.c18_io;

import java.io.*;

/**
 * @author huangjp 2018/7/18 14:10
 * I/O流的典型使用方式：存储和恢复数据(数据流)
 **/
public class T03_StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        String file = "doc/c.txt";
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
        out.writeByte(1);
        out.writeBoolean(true);
        out.writeDouble(1.2456);
        out.writeUTF("Hello, I'm c!");
        out.flush();
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        System.out.println(in.readByte());
        System.out.println(in.readBoolean());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
/*
    Output :
        1
        true
        1.2456
        Hello, I'm c!
 */