package com.tc.sort;

import java.util.Arrays;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
//            取中值进行分治
            int mid = (left + right) / 2;
//            从左边进行递归分治
            mergeSort(arr, left, mid, temp);
//            从右边进行递归分治
            mergeSort(arr, mid + 1, right, temp);
//            合并且排序
            merge(arr, left, mid, right, temp);
        }

    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
//        左边数组的开始元素
        int i = left;
//        右边数组的开始元素
        int j = mid + 1;
//        临时数组的开始元素
        int t = 0;
//      该循环是判断两个有序数组各拿一个数进行比较较小的入临时数组
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[t] = arr[j];
                t++;
                j++;
            } else {
                temp[t] = arr[i];
                t++;
                i++;
            }
        }
//        从上一个循环跳出来说明有一个数组已经遍历完了
//        该循环是右数组遍历完了，将左数组没遍历完的值依次填充到temp数组中
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
//        该循环是左数组遍历完了，将右数组没遍历完的值依次填充到temp数组中
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
//        将temp数组的拷贝到原先的数组中 0 1   2 3    0 3
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }


    }
}
