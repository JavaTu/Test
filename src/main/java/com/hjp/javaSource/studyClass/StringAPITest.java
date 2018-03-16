package com.hjp.javaSource.studyClass;

import java.io.UnsupportedEncodingException;

/**
 * @author huangjp
 * 2017-9-6 9:59
 **/
public class StringAPITest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        testAcquireAPIs();
        testCompareAPIs();
        testIndexAPIs();
        testModifyAPIs();
        testOtherAPIs();
        testValueAPIs();
        testUnicodeAPIs();
    }

    /**
     * String中比较相关的API
     */
    private static void testCompareAPIs() {
        System.out.println("--------------------- testCompareAPIs ----------------------");

        String str = "abc";
        System.out.println("str = " + str);

        //比较两个字符串的大小(如果内容不同，比较unicode码，如果内容相同，长度不同，返回长度差)
        System.out.println("str compareTo 'ABC' = " + str.compareTo("ABC"));

        //比较两个字符串的大小（不区分大小写）
        System.out.println("str compareToIgnoreCase 'ABC' = " + str.compareToIgnoreCase("ABC"));

        //比较两个字符串的内容是否相同，区分大小写(CharSequence)
        System.out.println("str contentEquals 'abc' = " + str.contentEquals("abc"));

        //比较两个字符串的内容是否相同，区分大小写(StringBuffer)
        System.out.println("str contentEquals new StringBuffer('abc') = " + str.contentEquals(new StringBuffer("abc")));

        //比较两个字符串是否相等
        System.out.println("str equals 'abc' = " + str.equals("abc"));

        /*
            深入理解 equals、 == 、 hasCode()
            1、 == 比较对象存储内存的地址
            2、equals 默认比较对象的引用，但是因为String重写的equals方法，所以String的equals是比较对象的内容
                大多的Java类库都实现了equals方法，用来比较对象的内容
            3、hasCode 就结果来看也是比较对象的内容
            参考资料 ： http://blog.csdn.net/woxueliuyun/article/details/3903102
         */
        System.out.println("new String('abc').hasCode() = " + new String("abc").hashCode());    //96354
        System.out.println("('abc').hasCode() = " + ("abc").hashCode());    //96354

        //比较两个字符串是否相等（不区分大小写）
        System.out.println("str equalsIgnoreCase 'ABC' = " + str.equalsIgnoreCase("ABC"));

        /*
            比较两个字符串的部分内容是否相等（可以设置是否区分大小写）
            示例：将'abc'从第1个元素起，长度为2的字符串与'BC12234'从第0个元素起，长度为2的字符串进行比较，并且不区分大小写
         */
        System.out.println("str.regionMatches(true, 1, 'BC1234', 0, 2) = " +
                str.regionMatches(true, 1, "BC1234", 0, 2));

        System.out.println("");
    }

    /**
     * String中Index相关的API
     */
    private static void testIndexAPIs() {
        System.out.println("--------------------- testIndexAPIs -----------------------");

        String str = "你好，String1111";
        System.out.println("str = " + str);

        //str 中第一次出现 '1' 的位置
        System.out.println("str indexOf('1') = " + str.indexOf("1"));   //9

        //str 中从位置10开始，从前往后， 第一次出现 '1' 的位置
        System.out.println("str indexOf('1', 10) = " + str.indexOf("1", 10));     //10

        //str 中从前往后，最后一次出现 '1' 的位置
        System.out.println("str.lastIndexOf('1') = " + str.lastIndexOf("1"));   //12

        //str 中从位置12开始，从前往后，最后一次出现 '1' 的位置
        System.out.println("str.lastIndexOf('1', 12) = " + str.lastIndexOf("1", 12));   //12



        System.out.println("");
    }

    /**
     * String中修改（拼接、替换、截取、分割）相关的API
     */
    private static void testModifyAPIs() {
        System.out.println("------------------ testModifyAPIs --------------------------");

        String str = "abc";
        System.out.println("str = " + str);

        //拼接字符串
        System.out.println("str.concat('!!!') = " + str.concat("!!!"));

        //按指定格式拼接字符串
        System.out.println("String.format('%s-%d-%b','a',1,true) = " + String.format("%s-%d-%b","a", 1, true));

        //拼接字节，只支持字节序列格式的，since 1.8
        //System.out.println("String.join('-', 'a', '1', 'true') = " + String.join("-", "a", "1", "true"));

        //替换str中所有的.为#
        String str1 = "my.test.txt";
        System.out.println("str1 = " + str1);
        System.out.println("str1.replace('.','#') = " + str1.replace(".", "#"));    //my#test#txt

        //replaceAll与replaceFirst涉及到正则表达式，遇到特殊字符不能随便乱用，比如说："." ，这时候需要转义一下，变成 "\\."即可
        //详情可见 ： http://www.cnblogs.com/jun9207/p/5191857.html
        //System.out.println("str1.replaceAll('.','#') = " + str1.replaceAll(".", "#"));  //###########
        System.out.println("str1.replaceAll('\\.','#') = " + str1.replaceAll("\\.", "#"));  //转义一下即可：my#test#txt
        System.out.println("str1.replaceFirst('.','#') = " + str1.replaceFirst(".", "#"));  //#y.test.txt

        //按指定字符串分割字符串，注意：split也支持正则表达式，所有遇到特殊字符也必须先转义
        //详情可见 ： http://blog.csdn.net/huangjp_hz/article/details/72929709
        String[] strings = str1.split("\\.");
        System.out.println("split(regex  )");
        for (int i = 0 ; i < strings.length; i++) {
            System.out.println("str1.split('\\.')[" + i + "] = " + strings[i]);
        }

        String[] strings1 = str1.split("\\.", 1);
        for (int i = 0 ; i < strings1.length; i++) {
            System.out.println("str1.split('\\.', 1)[" + i + "] = " + strings1[i]);
        }

        System.out.println("");
    }

    /**
     * String的valueOf()相关的API
     */
    private static void testValueAPIs() {
        System.out.println("---------------- testValueAPIs ----------------------------");

        System.out.println("");
    }

    /**
     * String其他的API
     */
    private static void testOtherAPIs() {
        System.out.println("----------------- testOtherAPIs ---------------------------");

        String str = "abc";
        System.out.println("str = " + str);

        //将字符数组转换成字符串并返回
        System.out.println("String.copyValueOf(new char[]{'a','b','c'}) = " + String.copyValueOf(new char[]{'a','b','c'}));

        //将字符数组转换成字符串并返回第0位到第2位的字符串
        System.out.println("String.copyValueOf(new Char[]{'a','b','c'}, 0, 2) = " + String.copyValueOf(new char[]{'a','b','c'}, 0, 2));

        //正则表达式
        String reg_ipv4 = "[0-9]{3}(\\.[0-9]{1,3}){3}";
        String ipv4addr1 = "192.168.1.102";
        String ipv4addr2 = "192.168";
        System.out.println("ipv4addr1.matches('reg') = " + ipv4addr1.matches(reg_ipv4));    //true
        System.out.println("ipv4addr2.matches('reg') = " + ipv4addr2.matches(reg_ipv4));    //false

        System.out.println("");
    }

    /**
     * String中与查询相关的API
     */
    private static void testAcquireAPIs() throws UnsupportedEncodingException {
        System.out.println("------------------ testAcquireAPIs --------------------------");

        String str = "0123456789";
        String str1 = "你好";
        System.out.println("str = " + str);

        //查询str第3个字节
        System.out.println(str+".[3] = "+str.charAt(3));

        //查询字符串是否包含'abc'
        System.out.println("str contain 'abc' = " + str.contains("abc"));

        //查询字符串是否以9结尾
        System.out.println("str endWith '9' = " + str.endsWith("9"));

        //获取字符串的字节数组（值是每个字节对应的Unicode值）
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print("str[" + i + "] = " + bytes[i] + "; ");
        }
        System.out.println("");

        //GBK
        byte[] bytes1 = str1.getBytes("GBK");
        System.out.print("GBK : ");
        for (int i = 0; i < bytes1.length; i++) {
            System.out.print("str[" + i + "] = " + bytes1[i] + "; ");
        }
        System.out.println("");

        //UTF-8
        byte[] bytes2 = str1.getBytes("utf-8");
        System.out.print("utf-8 : ");
        for (int i = 0; i < bytes2.length; i++) {
            System.out.print("str[" + i + "] = " + bytes2[i] + "; ");
        }
        System.out.println("");

        //US-ASCII
        byte[] bytes3 = str1.getBytes("US-ASCII");
        System.out.print("US-ASCII : ");
        for (int i = 0; i < bytes3.length; i++) {
            System.out.print("str[" + i + "] = " + bytes3[i] + "; ");
        }
        System.out.println("");

        //UTF-16
        byte[] bytes4 = str1.getBytes("utf-16");
        System.out.print("utf-16 : ");
        for (int i = 0; i < bytes4.length; i++) {
            System.out.print("str[" + i + "] = " + bytes4[i] + "; ");
        }
        System.out.println("");

        //获取字符串的长度
        System.out.println("str.length() = " + str.length());





        System.out.println("");
    }

    /**
     * String中与Unicode相关的API
     */
    private static void testUnicodeAPIs() {
        System.out.println("--------------------- testUnicodeAPIs -----------------------");

        String str = "字符编码 test";
        System.out.println("str = "+str);

        //获取第6位字节的unicode码
        System.out.println("str.codePointAt{6}="+str.codePointAt(6));

        //获取第3位的前一位的unicode码
        System.out.println("str.codePointBefore{3}="+str.codePointBefore(3));

        //获取第2位与第7位之间的unicode编码的个数
        System.out.println("str.codePointCount{2,7}="+str.codePointCount(2,7));

        System.out.println("");
    }

}
