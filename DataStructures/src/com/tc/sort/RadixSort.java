package com.tc.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214,36,88,91};
        radix(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radix(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        int maxSize = (maxValue + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int i = 0, n = 1; i < maxSize; i++, n *= 10) {
//            将元素按照规则放入到指定的桶中
            for (int j = 0; j < arr.length; j++) {
                int digit = (arr[j] / n) % 10;
                bucket[digit][bucketCounts[digit]] = arr[j];
                bucketCounts[digit]++;
            }
//
            int index = 0;
            for (int k = 0; k < 10; k++) {
                for (int l = 0; l < bucketCounts[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
                bucketCounts[k]=0;
            }



        }
    }
}
