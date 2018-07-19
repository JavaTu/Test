package com.hjp.javaSource.ThinkingInJava.c18_io;
import java.io.*;

/**
 * @author huangjp 2018/7/16 17:18
 *
 **/
public class T02_InputStream {

    public static void main(String[] args) {
        try {
            File file = new File("doc/a.txt");
            InputStream stream = new FileInputStream(file);
            Reader reader = new InputStreamReader(stream);     //InputStreamReader是一个适配器
            char[] chars = new char[1024];
            reader.read(chars);
            StringBuilder sb = new StringBuilder();
            for (char item:chars)
                sb.append(item);
            System.out.println(sb.toString());                //Output :Hello, I'm a!   你好，我是a!

            /*BufferedInputStream bs = new BufferedInputStream(stream);
            byte[] bytes = new byte[1024];
            bs.read(bytes);
            System.out.println(new String(bytes));*/    //Output :Hello, I'm a!   你好，我是a!


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
