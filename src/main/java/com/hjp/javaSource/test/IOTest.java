package com.hjp.javaSource.test;

import java.io.*;

/**
 * @author huangjp 2018/7/11 16:26
 *
 **/
public class IOTest {

    public static void main(String[] args) {

        File f1 = new File("C:\\Users\\Administrator\\Desktop\\test.txt");  //绝对路径：以盘符开头
        //File f2 = new File("doc/test.txt"); //相对路径：以工程目录为参照点

        //System.out.println(f1.exists());    //true
        //System.out.println(f2.exists());    //true

        if (byteWrite(f1)){
            System.out.println(byteRead(f1));
        }
        if (charWrite(f1)){
            System.out.println(charRead(f1));
        }
        if (bufferedByteWrite(f1)){
            System.out.println(bufferedByteRead(f1));
        }
        if (bufferedCharWrite(f1)){
            System.out.println(bufferedCharRead(f1));
        }
        if (dataByteWrite(f1)){
            System.out.println(dataByteRead(f1));
        }
    }

    //字节流：以字节为单位进行写入与读取。
    private static boolean byteWrite(File file){
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream stream = new FileOutputStream(file);
            stream.write("hello FileOutPutStream!".getBytes());
            stream.flush();
            stream.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在："+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO输入报错："+e.getMessage());
        }
        return false;
    }

    private static String byteRead(File file){
        try {
            FileInputStream stream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            if (stream.read(bytes) > 0){
                //stream.close();   FileInputStream实现了Closeable接口，而JDK7后，Closeable继承了AutoCloseable接口，所以，这种try语句可以自动关闭资源。
                return new String(bytes);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在："+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO输出报错："+e.getMessage());
        }
        return null;
    }

    //字符流：以字符为单位进行写入与读取。
    private static boolean charWrite(File file){
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("hello FileWriter!");
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("IO异常："+e.getMessage());
        }
        return false;
    }

    private static String charRead(File file){
        try {
            FileReader fileReader = new FileReader(file);
            char[] chars = new char[1024];
            if (fileReader.read(chars) > 0){
                return new String(chars);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在："+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO输出异常："+e.getMessage());
        }
        return null;
    }

    /**
     * 包装流之缓冲流（类比为卡车）：提高读写的效率，减少访问硬盘的次数，达到保护硬盘的作用【深入解析】
     */
    //包装字节流
    private static boolean bufferedByteWrite(File file){
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream stream = new FileOutputStream(file);
            BufferedOutputStream bufferedStream = new BufferedOutputStream(stream);
            bufferedStream.write("hello BufferedOutPutStream!".getBytes());
            bufferedStream.flush();
            bufferedStream.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在："+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO写入失败："+e.getMessage());
        }
        return false;
    }

    private static String bufferedByteRead(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] bytes = new byte[1024];
            if (bufferedInputStream.read(bytes) > 0){
                return new String(bytes);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在："+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO异常："+e.getMessage());
        }
        return null;
    }

    //包装字符流
    private static boolean bufferedCharWrite(File file){
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("hello BufferedWriter!");
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("IO异常："+e.getMessage());
        }
        return false;
    }

    private static String bufferedCharRead(File file){
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String result = "";
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null){
                result = result + nextLine;     //提示建议使用StringBuffer的append方法
            }
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在："+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO异常："+e.getMessage());
        }
        return null;
    }

    /**
     * 包装流之数据流：可以根据数据的类型进行输入输出，写出去什么类型，读回来还是什么类型
     */
    //包装字节流
    private static boolean dataByteWrite(File f){
        try {
            if (!f.exists()){
                f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes("hello DataOutputStream!");
            dos.flush();
            dos.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在："+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO异常："+e.getMessage());
        }
        return false;
    }

    private static String dataByteRead(File f){
        try {
            if (!f.exists()){
                f.createNewFile();
            }
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            byte[] bytes = new byte[1024];
            dis.read(bytes);
            return new String(bytes);
        } catch (IOException e) {
            System.out.println("IO异常："+e.getMessage());
        }
        return null;
    }

    private static boolean dataCharWrite(File f){
        try {
            FileWriter fw = new FileWriter(f);

        } catch (IOException e) {
            System.out.println("IO异常："+e.getMessage()
            );
        }
        return false;
    }
}
