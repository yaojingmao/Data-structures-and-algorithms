package com.tc.search;

import java.util.ArrayList;
import java.util.List;
//二分查找
public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 9);
        System.out.println(list);


     /*   int index = binarySearch(arr, 0, arr.length - 1, 9);
        if (index == -1) {
            System.out.println("没找到该数");
        } else {
            System.out.println("找到了。该数的下标为" + index);
        }*/
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;

        int midValue = arr[mid];
        if (left > right) {
            return -1;
        }
        if (value > midValue) {
            return binarySearch(arr, mid + 1, right, value);
        }
        if (value < midValue) {
            return binarySearch(arr, left, mid - 1, value);
        }

        return mid;


    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;

        int midValue = arr[mid];
        if (left > right) {
            return new ArrayList<Integer>();
        }
//        向右递归查找
        if (value > midValue) {
            return binarySearch2(arr, mid + 1, right, value);
        }
//        向左递归查找
        if (value < midValue) {
            return binarySearch2(arr, left, mid - 1, value);
        }

        List<Integer> list = new ArrayList<>();
        int temp = mid - 1;
//        向前遍历看是否还有要查找的值
        while (true) {
            if (temp < 0 || arr[temp] != value) {
                break;
            }
            list.add(temp);
            temp--;
        }
//        刚好查找到的值
        list.add(mid);
        temp = mid + 1;
//        向后遍历看是否还有要查找的值
        while (true) {
            if (temp > arr.length - 1 || arr[temp] != value) {
                break;
            }
            list.add(temp);
            temp++;
        }
        return list;


    }

}
