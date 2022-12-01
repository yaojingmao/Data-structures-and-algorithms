package com.tc.recursion;

import java.util.ArrayList;

public class Queue8 {
    int maxSize = 8;
    int[] array = new int[maxSize];
    static int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法", count);
    }

    private void check(int n) {
        if (n == maxSize) {
            print();
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }

    }

    private boolean judge(int n) {

        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
