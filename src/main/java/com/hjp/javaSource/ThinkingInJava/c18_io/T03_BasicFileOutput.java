package com.hjp.javaSource.ThinkingInJava.c18_io;

import java.io.*;

/**
 * @author huangjp 2018/7/18 10:41
 * I/O流的典型使用方式：基本的文件输出
 **/
public class T03_BasicFileOutput {

    public static void main(String[] args){
        String file = "doc/b.txt";
        BufferedReader in = new BufferedReader(new StringReader(T03_BufferedInputFile.read("doc/a.txt")));  //大量的装饰工作
        try {
            //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            PrintWriter out = new PrintWriter(file);    //文本文件输出的快捷方式，这是Java5提供的辅助构造器，作用、性能与第15行一样，并且仍然在进行缓存。
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null)
                out.println(lineCount++ + ":" + s);
            out.flush();    //一定要加，不加会导致写入失败(刷新缓冲区内容)，或者在创建PrintWriter时使用此方法：public PrintWriter(OutputStream out, boolean autoFlush) {}，其中autoFlush设为true，就可以自动刷新缓存
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(T03_BufferedInputFile.read(file));
        System.out.println(in);
    }
}
/*
    Output : 1:Hello, I'm a!   你好，我是a!
 */
