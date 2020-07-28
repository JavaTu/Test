package com.hjp.javaSource.alg;

/**
 * @ClassName: SortTest
 * @Description:
 * @Author: huangjp
 * @Date: 2020/7/27 18:05
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5};
        bubbleSort(arr);
    }

    // 冒泡排序：两两交换，时间复杂度O(n^2)
    private static void bubbleSort(int[] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length-1; j++){
                int temp = arr[j];
                if (arr[j] > arr[j+1]){
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int j=0; j<arr.length; j++){
            System.out.println(arr[j]);
        }
    }

    // 归并排序，时间复杂度O(nlogn)
    private static void mergeSort(int[] arr){
        // TODO...

    }
}
