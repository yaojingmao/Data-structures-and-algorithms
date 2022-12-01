package com.tc.sort;
//插入排序
public class InsertSort {
    public static void main(String[] args) {
        insertSort(new int[]{101, 34, 119, 1, -1, 89});
    }

    public static void insertSort(int[] arr) {
//        记录插入元素的值
        int insertValue = 0;
//        记录插入索引的前一个位置
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
//            插入的值
            insertValue = arr[i];
//            插入的值的前一个位置
            insertIndex = i - 1;
//            insertIndex >= 0防止越界，判断插入的值是否小于遍历的值从而找到应该插入的位置
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
//                将元素向后移一位
                arr[insertIndex + 1] = arr[insertIndex];
//                向前遍历
                insertIndex--;
            }
//            如果为false说明该元素是有序的，无序交换位置
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }

        }
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
