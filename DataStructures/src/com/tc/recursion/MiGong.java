package com.tc.recursion;

public class MiGong {
    public static void main(String[] args) {
        //    先初始化一个迷宫
        int map[][] = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay(map, i + 1, j)) {
                return true;
            }
            if (setWay(map, i, j + 1)) {
                return true;
            }
            if (setWay(map, i - 1, j)) {
                return true;
            }
            if (setWay(map, i, j - 1)) {
                return true;
            }
            map[i][j] = 3;
            return false;
        } else {
            return false;
        }


    }

}



