package com.hjp.javaSource.ThinkingInJava.c18_io.examples;

import java.io.*;
import java.net.URL;

/**
 * @author huangjp 2018/7/18 18:09
 * 下载一张图片
 **/
public class DownloadAPicture {

    public static void main(String[] args) throws IOException {
        URL url=new URL("http://img.sccnn.com/bimg/338/27244.jpg");
        InputStream in = url.openStream();
        File file = new File("doc/getLucky.jpg");
        if (!file.exists()){
            file.createNewFile();
        }
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        while (in.available() != 0)
            out.write(in.read());
        out.flush();
        System.out.println("图片下载完毕");
    }
}
