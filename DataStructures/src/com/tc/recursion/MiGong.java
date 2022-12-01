package com.tc.recursion;

//递归思想 迷宫回溯问题
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
//        setWay(map, 1, 1);
        setWay2(map, 1, 1);
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

    //判断是否有通路的方法
    public static boolean setWay(int[][] map, int i, int j) {
//        1代表墙不能走  2代表走过的地方  3代表死路
//        判断终点是否为2，若为2则代表已经找到一条通路
        if (map[6][5] == 2) {
            return true;
        }
            //        先判断i ， j这个位置从来没走过
        if (map[i][j] == 0) {
            //            假设他是通路
            map[i][j] = 2;
            //            向下走
            if (setWay(map, i + 1, j)) {
                return true;
            }
            //            向右走

            if (setWay(map, i, j + 1)) {
                return true;
            }
            //            向上走

            if (setWay(map, i - 1, j)) {
                return true;
            }
            //            向左走

            if (setWay(map, i, j - 1)) {
                return true;
            }
            //            四路不同，则是死路
            map[i][j] = 3;
            return false;
        } else {//该else是代表遇上1，2，3都是走过的或走不通的直接返回false
            return false;
        }


    }

    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay2(map, i - 1, j)) {
                return true;
            }
            if (setWay2(map, i, j + 1)) {
                return true;
            }
            if (setWay2(map, i + 1, j)) {
                return true;
            }
            if (setWay2(map, i, j - 1)) {
                return true;
            }
            map[i][j] = 3;
            return false;
        } else {
            return false;
        }


    }


}



