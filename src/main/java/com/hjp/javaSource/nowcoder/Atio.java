package com.hjp.javaSource.nowcoder;

import java.math.BigDecimal;

/**
 * @ClassName: Atio
 * @Description: 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2的31,  2的31 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: huangjp
 * @Date: 2020/9/17 14:44
 */
public class Atio {

    public static void main(String[] args) {
//        BigDecimal min = new BigDecimal("-91283472332");
//        System.out.println(min.compareTo(new BigDecimal(Integer.MIN_VALUE)));
//
//        BigDecimal max = new BigDecimal("91283472332");
//        System.out.println(max.compareTo(new BigDecimal(Integer.MAX_VALUE)));

        String s = " ";
        s = "\" \"";
        s = " -47";
        s = " 47";
        s = " 91283472332";
        s = "-+1";
        s = "-42";
        System.out.println(atio(s));
    }


    // "  -74abc"
    private static int atio(String str) {

        if (str == null || str.equals("") || str.equals(" ") || str.equals("-") || str.equals("+")){
            return 0;
        }

        if (String.valueOf(str.charAt(0)).equals("\"")){
            str = str.substring(1);
        }

        if (str.equals("") || str.equals(" ")){
            return 0;
        }

        if (String.valueOf(str.charAt(str.length()-1)).equals("\"")){
            str = str.substring(0, str.length()-1);
        }

        if (str.equals("") || str.equals(" ")){
            return 0;
        }

        // 去除空格
        str = str.trim();

        // 判断是否包含符号
        String first = String.valueOf(str.charAt(0));
        if (first.equals("+")){
            str = str.substring(1);
        }
        if (!first.equals("-") && !Character.isDigit(str.charAt(0))){
            return 0;
        }

        int lastIndex = str.length();
        for (int i=0; i<str.length(); i++){
            if (i == 0 && first.equals("-")){
                continue;
            }

            if (!Character.isDigit(str.charAt(i))){
                lastIndex = i;
                break;
            }
        }

        String numStr = str.substring(0, lastIndex);
        if (numStr.startsWith("-") && (numStr.length() == 1 || !Character.isDigit(numStr.charAt(1)))){
            return 0;
        }
        if (!numStr.startsWith("-") && !Character.isDigit(numStr.charAt(0))){
            return 0;
        }

        BigDecimal num = new BigDecimal(numStr);
        if (num.compareTo(new BigDecimal(Integer.MAX_VALUE)) >= 0){
            return Integer.MAX_VALUE;
        }
        if (num.compareTo(new BigDecimal(Integer.MIN_VALUE)) <= 0){
            return Integer.MIN_VALUE;
        }

        return num.intValue();
    }

}
