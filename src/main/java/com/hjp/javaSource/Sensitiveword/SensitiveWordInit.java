package com.hjp.javaSource.Sensitiveword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Description: 初始化敏感词库，将敏感词加入到HashMap中，构建DFA算法模型
 * @Author : huangjp
 */
public class SensitiveWordInit {

    private static Logger log = LoggerFactory.getLogger(SensitiveWordInit.class);

    private static final String ENCODING = "GBK";    //字符编码

    private static final String FILE_PATH = "SensitiveWord.txt";

    public static Map sensitiveWordMap = new HashMap(); //敏感词库

    static {
        /*if (CollectionUtil.isEmpty(sensitiveWordMap)){
            sensitiveWordMap = initKeyWord();
        }*/
    }

    public static Map initKeyWord(){

        log.info("开始读取敏感词库");

        // 读取敏感词库文件
        Set<String> keyWordSet = new HashSet<>();
        try {
            keyWordSet = readSensitiveWordFile();
        } catch (Exception e) {
            log.error("敏感词库读取失败，报错：{}", e);
        }

        // 将敏感词库加入到HashMap中
        Map sensitiveWordMap = addSensitiveWordToHashMap(keyWordSet);
        log.info("敏感词库读取完毕");

        return sensitiveWordMap;
    }

    /**
     * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br>
     * 中 = {
     *      isEnd = 0
     *      国 = {<br>
     *      	 isEnd = 1
     *           人 = {isEnd = 0
     *                民 = {isEnd = 1}
     *                }
     *           男  = {
     *           	   isEnd = 0
     *           		人 = {
     *           			 isEnd = 1
     *           			}
     *           	}
     *           }
     *      }
     *  五 = {
     *      isEnd = 0
     *      星 = {
     *      	isEnd = 0
     *      	红 = {
     *              isEnd = 0
     *              旗 = {
     *                   isEnd = 1
     *                  }
     *              }
     *      	}
     *      }
     * @param keyWordSet  敏感词库
     */
    private static Map addSensitiveWordToHashMap(Set<String> keyWordSet) {
        HashMap sensitiveWordMap = new HashMap(keyWordSet.size());     //初始化敏感词容器，减少扩容操作
        String key;
        Map nowMap;
        Map<String, String> newWordMap;
        //迭代keyWordSet
        Iterator<String> iterator = keyWordSet.iterator();
        while(iterator.hasNext()){
            key = iterator.next();    //关键字
            nowMap = sensitiveWordMap;
            for(int i = 0 ; i < key.length() ; i++){
                char keyChar = key.charAt(i);               //转换成char型
                Object wordMap = nowMap.get(keyChar);       //获取

                if(wordMap != null){        //如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                } else{     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWordMap = new HashMap<>();
                    newWordMap.put("isEnd", "0");     //不是最后一个
                    nowMap.put(keyChar, newWordMap);
                    nowMap = newWordMap;
                }

                if(i == key.length() - 1){
                    nowMap.put("isEnd", "1");    //最后一个
                }
            }
        }
        return sensitiveWordMap;
    }

    /**
     * 读取敏感词库中的内容，将内容添加到set集合中
     * @throws Exception
     */
    private static Set<String> readSensitiveWordFile() throws Exception {

        Set<String> set = new HashSet<>();

        /*File file = ResourceUtils.getFile(FILE_PATH); // 达成Jar包后读取失败，那还要你何用？
        if(file.isFile() && file.exists()){      //文件流是否存在
            InputStreamReader read = null;
            try {
                read = new InputStreamReader(new FileInputStream(file), ENCODING);
                BufferedReader bufferedReader = new BufferedReader(read);
                String word;
                while((word = bufferedReader.readLine()) != null){    //读取文件，将文件内容放入到set中
                    set.add(word);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                read.close();     //关闭文件流
            }
        } else{
            throw new Exception("敏感词库文件不存在，初始化失败");
        }*/

        ClassPathResource classPathResource =  new ClassPathResource(FILE_PATH);
        if (null == classPathResource) {
            log.error("敏感词库读取失败,文件找不到！");
        }
        InputStream in = classPathResource.getInputStream();
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(in, ENCODING);
            BufferedReader bufferedReader = new BufferedReader(read);
            String word;
            while((word = bufferedReader.readLine()) != null){    //读取文件，将文件内容放入到set中
                set.add(word);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            read.close();     //关闭文件流
            in.close();
        }

        return set;
    }
}
