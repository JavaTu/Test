package com.hjp.javaSource.Sensitiveword;

import java.util.Map;

/**
 * @Description: 敏感词过滤
 * @Author : huangjp
 */
public class SensitiveWordFilter {

    /**
     * 判断文字是否包含敏感字符
     * @param target  文字
     * @return 若包含返回true，否则返回false
     */
    public static boolean isContainSensitiveWord(String target){

        Map sensitiveWordMap = SensitiveWordInit.sensitiveWordMap;
        /*if (CollectionUtil.isEmpty(sensitiveWordMap)){
            return true;
        }*/

        boolean flag = false;
        for(int i = 0 ; i < target.length() ; i++){
            int matchFlag = checkSensitiveWord(target, i, sensitiveWordMap); //判断是否包含敏感字符
            if(matchFlag > 0){    //大于0存在，返回true
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 检查文字中是否包含敏感字符，检查规则如下：
     * @param txt
     * @param beginIndex
     * @return，如果存在，则返回敏感词字符的长度，不存在返回0
     */
    @SuppressWarnings({ "rawtypes"})
    private static int checkSensitiveWord(String txt, int beginIndex, Map sensitiveWordMap){
        boolean  flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况
        int matchFlag = 0;     //匹配标识数默认为0
        char word;
        Map nowMap = sensitiveWordMap;
        for(int i = beginIndex; i < txt.length() ; i++){
            word = txt.charAt(i);
            nowMap = (Map) nowMap.get(word);     //获取指定key
            if(nowMap != null){     //存在，则判断是否为最后一个
                matchFlag++;     //找到相应key，匹配标识+1
                if("1".equals(nowMap.get("isEnd"))){       //如果为最后一个匹配规则,结束循环，返回匹配标识数
                    flag = true;       //结束标志位为true
                    break;
                }
            } else{     //不存在，直接返回
                break;
            }
        }
        if(matchFlag < 2 || !flag){        //长度必须大于等于1，为词
            matchFlag = 0;
        }
        return matchFlag;
    }
}
