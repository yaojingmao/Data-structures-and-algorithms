package com.tc.sort;

//选择排序
public class SelectSort {

    public static void main(String[] args) {

        selectSort(new int[]{101, 34, 119, 124, 25, 85});
    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] =min;
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
