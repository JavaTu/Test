package com.hjp.javaSource.StringTest;

/**
 * @author huangjup
 * @create in 2017-09-05 11:11
 * @since JDK1.0
 */
public class StringCompareTest {

    private final static String str1 = "hello String";     //length : 12
    private final static String str2 = "another String";   //length : 14
    private final static String str3 = "Another String";   //length : 14
    private final static String str4 = "Another String2";  //length : 15
    private final static String str5 = "!";
    private final static String str6 = "Another";

    /** CharSequence是一个接口，不能用new来赋值 */
    private final static CharSequence cs1 = "a";
    private final static CharSequence cs2 = "A";

    private final static int length = str1.length();

    public static void main(String[] args) {

        testCharAt(str1, length - 1);                            //output : hello String charAt 11 is [g]

        testCodePointAt(str1, length - 1);                       //output : hello String codePointAt 11 is [103]

        testCodePointBefore(str1, length - 1);                   //output : hello String codePointBefore 11 is [110]

        testCodePointCount(str1, 1, length - 2);    //output : hello String, beginIndex:1, endIndex:10, codePointCount:9

        testCompareTo(str1, str2);      //output : 'hello String' compareTo 'another String' is [7]
        testCompareTo(str1, str1);      //output : 'hello String' compareTo 'hello String' is [0]
        testCompareTo(str2, str3);      //output : 'another String' compareTo 'Another String' is [32]
        testCompareTo(str3, str4);      //output : 'Another String' compareTo 'Another String2' is [-1]

        testCompareToIgnoreCase(str1, str2);    //output : 'hello String' compareToIgnoreCase 'another String' is [7]
        testCompareToIgnoreCase(str1, str1);    //output : 'hello String' compareToIgnoreCase 'hello String' is [0]
        testCompareToIgnoreCase(str2, str3);    //output : 'another String' compareToIgnoreCase 'Another String' is [0]
        testCompareToIgnoreCase(str3, str4);    //output : 'Another String' compareToIgnoreCase 'Another String2' is [-1]

        testConcat(str1, str5);     //output : 'hello String' concat '!' : hello String!

        testContains(str6, cs1);   //output : Is Another contains a?   false
        testContains(str6, cs2);   //output : Is Another contains A?   true



    }

    /**
     * 字符串中是否包含字节c(区分大小写)
     * @param s String
     * @param cs charSequence
     */
    private static void testContains(String s, CharSequence cs) {
        System.out.println("Is " + s + " contains " + cs + "?   " + s.contains(cs));
    }

    /**
     * 拼接字符串
     * @param s1 original1
     * @param s2 original2
     */
    private static void testConcat(String s1, String s2){
        System.out.println("'" + s1 + "' concat '" + s2 + "' : " + s1.concat(s2));
    }

    /**
     * 类似compareTo, 但是不区分大小写
     * @param s1 original1
     * @param s2 original2
     */
    private static void testCompareToIgnoreCase(String s1, String s2) {
        System.out.println("'" + s1 +
                "' compareToIgnoreCase '" + s2 +
                "' is [" + s1.compareToIgnoreCase(s2) + "]");
    }

    /**
     * 一一对比两个字符串的每个字节(区分大小写)
     *      如果遇到同一个索引下，字节不相同，则返回当前索引下字节的十进制值之差，
     *      如果字符串内容相同，长度不同，则返回长度之差
     *      如果完全相同，则返回0
     * @param s1 original1
     * @param s2 original2
     */
    private static void testCompareTo(String s1, String s2){
        System.out.println("'" + s1 +
                "' compareTo '" + s2 +
                "' is [" + s1.compareTo(s2) + "]");
    }

    /**
     * 计算字符串从beginIndex到endIndex的字节数（不包含空格）
     * @param s original
     * @param beginIndex 起始索引
     * @param endIndex 结束索引
     */
    private static void testCodePointCount(String s, int beginIndex, int endIndex){
        System.out.println(s + ", " +
                "beginIndex:" + beginIndex + ", " +
                "endIndex:" + endIndex + ", " +
                "codePointCount:" + s.codePointCount(beginIndex, endIndex));
    }

    /**
     * 获取第i-1个字节的十进制值
     * @param s original
     */
    private static void testCodePointBefore(String s, int index){
        System.out.println(s + " codePointBefore " + index + " is [" + s.codePointBefore(index) + "]");
    }

    /**
     * codePointAt : 输出字节对应ASCII表中的十进制值
     * @param s original(源)
     */
    private static void testCodePointAt(String s, int index){
        System.out.println(s + " codePointAt " + index + " is [" + s.codePointAt(index) + "]");
    }

    private static void testCharAt(String s, int index){
        System.out.println(s + " charAt " + index + " is [" + s.charAt(index) + "]");
    }

}
