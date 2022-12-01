package com.tc.sort;

import java.util.List;

//冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort(new int[]{3, 9, -1, 10, -2});
    }

    public static void bubbleSort(int[] arr) {
        int count = 0;
        boolean flag = false;
        int val;
//该地方减一是5个数据排四个数据就相当于全部有序了
        for (int i = 0; i < arr.length - 1; i++) {
//该地方减i是因为拍完i躺就说明有i个数据已经排好序了，在下一趟排序无需比较，减一则是下面有个J++防止索引越界
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    val = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = val;
                    flag = true;
                }
            }
            count++;
//            优化 当有一趟排序一次交换都没有发生则数据有序结束冒泡排序，或者当排序全部完成时数据有序，最后打印数据，和排序的次数
            if (!flag || i == arr.length - 2) {
                print(arr);
                System.out.println("---------" + count);
                break;
            }

        }

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}
