package com.hjp.javaSource.ThinkingInJava.c18_io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * @author huangjp 2018/7/13 14:45
 * File类：既能代表一个特定文件的名称，也能代表一个目录下一组文件的名称，可以帮助我们处理文件目录的问题。
 * 以下方法分别实现了：
 *  1. 基本的目录列表器
 *  2. 使用匿名内部类的方式实现FilenameFilter接口，重写accept()方法给list()使用。其中，file.list(filenameFilter)方法是策略模式的一个例子。
 *  3. 传向匿名内部类的参数必须是final类型，为了保证引用的一致性。？？？https://www.cnblogs.com/albert1017/p/3915356.html、http://feiyeguohai.iteye.com/blog/1500108
 *  4. 匿名内部类的优点与缺点：
 *      优点： 将解决问题的代码隔离、聚拢于一点
 *      缺点： 不易阅读
 **/
public class T01_File {

    public static void main(String[] args) {

        File path = new File("doc");
        String[] list = getList(path);
        if (list != null){
            for (String each : list){
                System.out.println(each);
            }
        }

        System.out.println("###Filter###");

        String[] filterList = filterList(path, ".java");
        if (filterList != null){
            for (String each : filterList){
                System.out.println(each);
            }
        }
    }

    //目录列表器：并按字母进行排序
    private static String[] getList(File path){
        if (!path.exists()){
            System.out.println("文件不存在");
            return null;
        }
        String[] list = path.list();
        if (list != null){
            Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        }
        return list;
    }

    //获取指定的目录列表
    private static String[] filterList(File path, String regex){
        if (!path.exists()){
            System.out.println("文件不存在");
            return null;
        }
        return path.list(filter(regex));
    }

    //使用匿名内部类实现filter()方法：过滤目录
    private static FilenameFilter filter(final String regex){   //传向filter()的参数必须是final的，这是匿名内部类中必需的，这样它才能够使用来自该类范围之外的对象。【？？？】
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(regex);
            }
        };
    }
}
