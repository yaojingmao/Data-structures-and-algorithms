package com.tc.search;
//线性查找
public class SequenceSearch {
    public static void main(String[] args) {
        int[]  arr={1,2,3,4,5,6,7,8,9};
        int index = sequenceSearch(arr, 5);
        if (index==-1){
            System.out.println("没找到该数");
        }else{
            System.out.println("找到了，该数下标为"+index);
        }
    }
    public static int sequenceSearch(int[] arr , int value){
        for (int i = 0; i < arr.length; i++) {
            if (value==arr[i]){
                return i;
            }
        }
        return -1;
    }
}
