package com.hjp.javaSource.test;

import java.util.Scanner;

/**
 * @author huangjp 2017-12-05 14:01
 **/
public class Test {

    private static int[] a = {0,5,8,12,17,20,25,28,30,50};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你想插入的数据：");
        int b = scanner.nextInt();

        int[] c = new int[11];
        int index = 0;
        for (int i = 0; i < a.length; i++){
            int j = a[i];
            int max;
            if (j < b){
                c[index] = j;
                max = b;
            }else {
                c[index] = b;
                max = j;
                b = j;
            }
            index++;
            if (index == 10){
                c[index++] = max;
            }
        }

        for (int i = 0; i<c.length; i++){
            System.out.print(c[i] + " ");
        }
    }
}
