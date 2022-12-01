package com.tc.search;

import java.util.Arrays;
//插值查找
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 1);
        System.out.println(index);

    }

    public static int insertValueSearch(int[] arr, int left, int right, int value) {

        System.out.println("xxxxxxxxx");
        if (left > right || value < arr[left] || value > arr[right]) {
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if (value > midValue) {
            return insertValueSearch(arr, mid + 1, right, value);
        }
        if (value > midValue) {
            return insertValueSearch(arr, left, mid - 1, value);
        }
        return mid;
    }
}
