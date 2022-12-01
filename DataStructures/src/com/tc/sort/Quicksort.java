package com.tc.sort;

import java.util.Arrays;

//快速排序
public class Quicksort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int temp;
        int l = left;
        int r = right;
//        基准选择的是中间值
        int pivot = arr[(left + right) / 2];
        while (l < r) {
//            该循环是从基准的左边找到一个比基准大的数
            while (arr[l] < pivot) {
                l++;
            }
//            该循环是从基准的右边找到一个比基准小的数
            while (arr[r] > pivot) {
                r--;
            }
//            退出循环的条件
            if (l >= r) {
                break;
            }
//            下三行代码是交换上面找到的比基准小的数和比基准大的数
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
//            如果左边的先到达基准，则只扫描右边的就行
            if (arr[l] == pivot) {
                r--;
            }
//            如果右边的先到达基准，则只扫描左边的就行
            if (arr[r] == pivot) {
                l++;
            }
        }
//        防止栈溢出
        if (l == r) {
            l++;
            r--;
        }
//        向左边的数组接着递归接着分治
        if (left < r) {
            quickSort(arr, left, r);
        }
//        向右边的数组接着递归接着分治
        if (right > l) {
            quickSort(arr, l, right);
        }

    }

}
