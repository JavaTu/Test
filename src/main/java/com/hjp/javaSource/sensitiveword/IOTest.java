package com.hjp.javaSource.sensitiveword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ClassName: IOTest
 * @Description:
 * @Author: huangjp
 * @Date: 2020/5/12 14:38
 */
public class IOTest {

    public static void main(String[] args){

        // 读取资源文件方式一
        System.out.println("读取资源文件方式一：IOTest.class.getResourceAsStream(\"/test.txt\")");
        InputStream in = IOTest.class.getResourceAsStream("/test.txt");
        if (in != null){
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            try {
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }catch (IOException e){
                System.err.println("读取报错" + e);
            }finally {
                if (br != null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        System.err.println("文件流关闭失败，报错：" + e);
                    }
                }
            }
        }

        // 读取资源文件方式二
            /*System.out.println("读取资源文件方式二：ResourceUtils.getFile(\"classpath:test.txt\")");
            File file;
            try {
                file = ResourceUtils.getFile("classpath:test.txt");
            } catch (FileNotFoundException e) {
                System.err.println("文件不存在，报错：" + e);
                return;
            }
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
                String line;
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }*/
    }

    // TODO
        /*private void testDFA(Set<String> words){

        }*/

    // TODO 效率是怎么保证的？需校验的字符串够短，DFA算法够快


}
