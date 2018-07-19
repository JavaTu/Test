package com.hjp.javaSource.ThinkingInJava.c18_io;

import com.hjp.javaSource.ThinkingInJava.util.PPrint;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author huangjp 2018/7/15 0015 16:20
 * 查找所有在doc目录子树下的txt文件：使用递归的方式实现。
 **/
public class E06_FilterFiles {

    public static void main(String[] args) {

        String path = "doc";
        long lastModifiedTime = 1531643973101L;
        String regix = ".txt";
        try {
            getLastModifiedTime(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
System.out.println("-----------------------------");
        try {
            File[] files = filter(path, lastModifiedTime);
            for (File each : files){
                System.out.println("find file:"+each.getName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
System.out.println("-----------------------------");

        System.out.println(walk(path, regix));

    }

    private static void getLastModifiedTime(String path) throws FileNotFoundException {

        File dir = new File(path);
        if (!dir.exists()){
            System.out.println("目录不存在！");
            throw new FileNotFoundException("目录不存在");
        }

        File[] files = dir.listFiles();
        for (File each : files){
            System.out.println("lastModified on :" + each.lastModified());
        }

    }

    private static File[] filter(final String path, final long lastModifyTime) throws FileNotFoundException {
        File dir = new File(path);
        if (!dir.exists()){
            System.out.println("目录不存在！");
            throw new FileNotFoundException("目录不存在");
        }

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return dir.lastModified() > lastModifyTime;
            }
        };

        return dir.listFiles(filter);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();
        // The default iterable element is the file list:
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(String start, String regex) { // Begin recursion
        return recurseDirs(new File(start), regex);
    }

    static TreeInfo recurseDirs(File startDir, String regex){
        System.out.println("开始遍历文件："+startDir.getName());
        TreeInfo result = new TreeInfo();
        for(File item : startDir.listFiles()) {
            if(item.isDirectory()) {
                System.out.println("放入目录："+item.getName());
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else // Regular file
                if(item.getName().endsWith(regex)){
                    System.out.println("放入文件："+item.getName());
                    result.files.add(item);
                }
        }
        return result;
    }
}
/*
Output :
lastModified on :1531468128815
lastModified on :1531468137437
lastModified on :1531468143120
lastModified on :1531713244489
lastModified on :1531468602497
lastModified on :1531303276917
-----------------------------
find file:a.txt
find file:b.txt
find file:c.txt
find file:child1
find file:d.java
find file:test.txt
-----------------------------
开始遍历文件：doc
放入文件：a.txt
放入文件：b.txt
放入文件：c.txt
放入目录：child1
开始遍历文件：child1
放入目录：child2
开始遍历文件：child2
放入文件：f.txt
放入文件：e.txt
放入文件：test.txt
dirs: [
  doc\child1
  doc\child1\child2
]

files: [
  doc\a.txt
  doc\b.txt
  doc\c.txt
  doc\child1\child2\f.txt
  doc\child1\e.txt
  doc\test.txt
]
 */