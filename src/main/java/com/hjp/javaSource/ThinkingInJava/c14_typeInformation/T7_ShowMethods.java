package com.hjp.javaSource.ThinkingInJava.c14_typeInformation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author huangjp 2018-03-21 14:14
 * 14.6.1类方法提取器：利用反射，提取类的方法
 * 注：
 * 1、IDEA给main传参的方法：https://www.2cto.com/kf/201801/713344.html
 * 2、Class.forName(arg)的arg必须是完整的class路径，比如：com.hjp.javaSource.ThinkingInJava.c14_typeInformation.T7_ShowMethods
 **/
public class T7_ShowMethods {

    //正则表达式
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("No Args");
            System.exit(0);
        }

        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] ctors = c.getConstructors();
            if (args.length == 1){
                for (Method method : methods)
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                for (Constructor<?> constructor : ctors)
                    System.out.println(p.matcher(constructor.toString()).replaceAll(""));
            }else {
                for (Method method : methods){
                    if (method.toString().indexOf(args[1]) != -1){
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                    }
                }
                for (Constructor<?> constructor : ctors){
                    if (constructor.toString().indexOf(args[1]) != -1){
                        System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*
    Output : public static void main(String[])
            public final void wait(long,int) throws InterruptedException
            public final native void wait(long) throws InterruptedException
            public final void wait() throws InterruptedException
            public boolean equals(Object)
            public String toString()
            public native int hashCode()
            public final native Class getClass()
            public final native void notify()
            public final native void notifyAll()
            public T7_ShowMethods()
 */

/*
    当args参数修改为java.lang.String时，输出为：
    public boolean equals(Object)
    public String toString()
    public int hashCode()
    public int compareTo(Object)
    public int compareTo(String)
    public int indexOf(String,int)
    public int indexOf(int)
    public int indexOf(int,int)
    public int indexOf(String)
    public static String valueOf(float)
    public static String valueOf(double)
    public static String valueOf(boolean)
    public static String valueOf(char[],int,int)
    public static String valueOf(char[])
    public static String valueOf(Object)
    public static String valueOf(char)
    public static String valueOf(int)
    public static String valueOf(long)
    public char charAt(int)
    public int codePointAt(int)
    public int codePointBefore(int)
    public int codePointCount(int,int)
    public int compareToIgnoreCase(String)
    public String concat(String)
    public boolean contains(CharSequence)
    public boolean contentEquals(StringBuffer)
    public boolean contentEquals(CharSequence)
    public static String copyValueOf(char[],int,int)
    public static String copyValueOf(char[])
    public boolean endsWith(String)
    public boolean equalsIgnoreCase(String)
    public static String format(Locale,String,Object[])
    public static String format(String,Object[])
    public byte[] getBytes()
    public byte[] getBytes(String) throws UnsupportedEncodingException
    public void getBytes(int,int,byte[],int)
    public byte[] getBytes(Charset)
    public void getChars(int,int,char[],int)
    public native String intern()
    public boolean isEmpty()
    public int lastIndexOf(int)
    public int lastIndexOf(int,int)
    public int lastIndexOf(String,int)
    public int lastIndexOf(String)
    public int length()
    public boolean matches(String)
    public int offsetByCodePoints(int,int)
    public boolean regionMatches(int,String,int,int)
    public boolean regionMatches(boolean,int,String,int,int)
    public String replace(char,char)
    public String replace(CharSequence,CharSequence)
    public String replaceAll(String,String)
    public String replaceFirst(String,String)
    public String[] split(String)
    public String[] split(String,int)
    public boolean startsWith(String)
    public boolean startsWith(String,int)
    public CharSequence subSequence(int,int)
    public String substring(int,int)
    public String substring(int)
    public char[] toCharArray()
    public String toLowerCase()
    public String toLowerCase(Locale)
    public String toUpperCase(Locale)
    public String toUpperCase()
    public String trim()
    public final void wait(long,int) throws InterruptedException
    public final native void wait(long) throws InterruptedException
    public final void wait() throws InterruptedException
    public final native Class getClass()
    public final native void notify()
    public final native void notifyAll()
    public String(byte[])
    public String(byte[],int,int)
    public String(byte[],Charset)
    public String(byte[],String) throws UnsupportedEncodingException
    public String(byte[],int,int,Charset)
    public String(StringBuilder)
    public String(StringBuffer)
    public String(int[],int,int)
    public String(char[],int,int)
    public String(char[])
    public String(String)
    public String()
    public String(byte[],int,int,String) throws UnsupportedEncodingException
    public String(byte[],int)
    public String(byte[],int,int,int)
 */
