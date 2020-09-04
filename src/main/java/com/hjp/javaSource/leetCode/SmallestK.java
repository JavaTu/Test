package com.hjp.javaSource.leetCode;

import java.util.Arrays;

/**
 * @ClassName: Solution
 * @Description: https://leetcode-cn.com/problems/smallest-k-lcci/
 * @Author: huangjp
 * @Date: 2020/9/4 16:23
 */
public class SmallestK {

    public static void main(String[] args) {
        int[] arr = {5,3,2,4};
        int k = 2;
        int[] brr = smallestK(arr, k);
        System.out.println(brr);
    }

    /**
     * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
     * @param arr arr = [1,3,5,7,2,4,6,8]
     * @param k   k = 4
     * @return [1,2,3,4]
     */
    public static int[] smallestK(int[] arr, int k) {

        if (arr.length == 0 || k == 0){
            return new int[0];
        }

        // 这有点扯淡吧。
        Arrays.sort(arr);
        int[] brr = new int[k];
        for (int i=0; i<k; i++){
            brr[i] = arr[i];
        }

        return brr;
    }
}
