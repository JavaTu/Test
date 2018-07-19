package com.hjp.javaSource.ThinkingInJava.c18_io.examples;

import org.springframework.util.StringUtils;

import java.io.*;

/**
 * @author huangjp 2018/7/18 18:24
 * 从控制台输入，并存入本地txt，遇到#后退出
 **/
public class ConsoleInput {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private static BufferedWriter out;

    private static final String filename = "doc/consoleInput.txt";

    private static final String DEFAULT_INITIAL_LINE = "";

    private static final byte SHUT_DOWN_BYTE = '#';

    public static void main(String[] args) throws IOException {
        System.out.println("请输入：");
        String line = in.readLine();

        File file = new File(filename);
        if (!file.exists()){
            file.createNewFile();
        }
        out = new BufferedWriter(new FileWriter(file));
        write(line);
        out.flush();
        System.out.println("存储完毕！");
    }

    private static void write(String line) throws IOException {
        if (StringUtils.isEmpty(line)){
            System.out.println("请输入：");
            line = in.readLine();
            write(line);
        }else {
            char[] chars = line.toCharArray();
            boolean shutDown = false;
            for (char c:chars){
                if (c == SHUT_DOWN_BYTE){
                    shutDown = true;
                    break;
                }
                out.write(c);
            }
            if (!shutDown){
                write(DEFAULT_INITIAL_LINE);
            }
        }
    }
}
