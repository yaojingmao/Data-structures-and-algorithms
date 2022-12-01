package com.tc.sort;

public class ShellSort {
    public static void main(String[] args) {
//        shellSort(new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0});
        shellSort2(new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0});
    }

    //交换法 效率较低 17秒左右80000个数排完
    public static void shellSort(int[] arr) {
        int temp = 0;

        for (int gap = arr.length; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        print(arr);

    }

    //该方法采用移位法，效率高 1秒左右80000个数排完
    public static void shellSort2(int[] arr) {
//        设置一个临时变量
        int temp = 0;
//        该循环每次分组的间隔
        for (int gap = arr.length; gap > 0; gap /= 2) {
//            该循环进行希尔排序，从间隔为gap开始，其实好减去间隔前面有值
            for (int i = gap; i < arr.length; i += gap) {
                int j = i;
//                temp临时存储要插入到有序数组里面的值
                temp = arr[j];
//                该判断的意思是前面的大于后面的说明逆序的
                if (arr[j] < arr[j - gap]) {
//                    j - gap >= 0表示下一个数不要越界了，如果越界则会在j这个位置插入
                    while (j - gap >= 0 && temp < arr[j - gap]) {
//                        将大的数往后移
                        arr[j] = arr[j - gap];
//                        向前找比插入的数小的数
                        j -= gap;
                    }
//                    这里表示找到要插入的位置了，并将值放到该位置
                    arr[j] = temp;
                }
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
