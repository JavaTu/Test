package com.hjp.javaSource.ThinkingInJava.c18_IO;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author huangjp 2018/7/16 12:08
 * 查找所有在doc目录子树下的txt文件：使用递归的方式实现。（参考E06_filterFiles自己输出一遍。）
 **/
public class E06_filterFiles2 {

    public static void main(String[] args) {
        //String startPath = "doc/child1/child2";
        String startPath = "doc";
        String suffix = ".txt";

        try {
            System.out.println(walk(startPath, suffix).toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class TreeInfo implements Iterable<File> {

        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            /*String result = "files = [";
            if (files.isEmpty()){
                result += "], \ndirs = [";
            }else {
                for (int i = 0; i < files.size(); i++){
                    File item = files.get(i);
                    if (i == files.size() - 1){
                        result += (item.getName() + "], \ndirs = [");
                    }else {
                        result += (item.getName() + ", ");
                    }
                }
            }

            if (dirs.isEmpty()){
                result += "]";
            }else {
                for (int i = 0; i < dirs.size(); i++){
                    File item = dirs.get(i);
                    if (i == dirs.size() - 1){
                        result += (item.getName() + "]");
                    }else {
                        result += (item.getName() + ", ");
                    }
                }
            }
            return result;*/

            return "files : " + cToString(files) + "\n\ndirs :" + cToString(dirs);
        }
    }

    public static String cToString(Collection<?> c){
        if (c.size() == 0) return "[]";

        StringBuilder result = new StringBuilder("[");
        for (Object o:c){
            if (c.size() != 1) result.append("\n  ");
            result.append(o);
        }

        if (c.size() != 1) result.append("\n");
        result.append("]");

        return result.toString();
    }

    private static TreeInfo walk(String startPath, String suffix) throws FileNotFoundException {
        if (StringUtils.isEmpty(startPath)){
            throw new FileNotFoundException("目录名不能为空");
        }

        File startDir = new File(startPath);
        if (!startDir.exists()){
            throw new FileNotFoundException("目录不存在");
        }

        return recurseDirs(startDir, suffix);
    }

    private static TreeInfo recurseDirs(File startDir, String suffix){
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()){
            if (item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item, suffix));
            }else if (item.getName().endsWith(suffix)){
                result.files.add(item);
            }
        }
        return result;
    }
}
/*
Output :
files : [
  doc\a.txt
  doc\b.txt
  doc\c.txt
  doc\child1\child2\f.txt
  doc\child1\e.txt
  doc\test.txt
]

dirs :[
  doc\child1
  doc\child1\child2
]
 */
