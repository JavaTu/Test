package com.hjp.javaSource.alg;

/**
 * @ClassName: SortTest
 * @Description:
 * @Author: huangjp
 * @Date: 2020/7/27 18:05
 */
public class SortTest {

    private static final int[] ARR = {5, 9, 1, 8, 2};

    public static void main(String[] args) {
        bubbingSort(ARR);
    }

    // 冒泡排序：两两交换
    private static void bubbingSort(int[] arr){
        for (int i=0; i<arr.length; i++){
            int num = arr[i];
            if (i == arr.length - 1){

            }
            int next = arr[i+1];
            if (num <= next){

            }else {

            }
        }

        for (int j=0; j<arr.length; j++)
            System.out.println(arr[j]);
    }
}
