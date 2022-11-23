package com.tc.sparsearray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) {

        //先创建一个二维数组
        int chessArr1[][] = new int[11][11];
        //设置两个值,0代表没棋子，1代表黑子，2代表蓝子
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始的二维数组------------------------");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //遍历chessArr数组有多少个非零数据
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println();
        System.out.println("sum=" + sum);
        //创建稀疏数组，行为非零数据加一，列为三
        int[][] sparseArray = new int[sum + 1][3];
        //稀疏数组第一行存11 ，11 ，非零数据
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //从第二行开始存非零数据的坐标和value
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
//        查看稀疏数组
        System.out.println();
        System.out.println("原始数据稀疏数组---------------------------------------");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //存入到磁盘中
        File src = new File("D:\\Map.data");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(src));
            for (int[] row : sparseArray) {
                for (int data : row) {
                    writer.write(data + "\t");
                }
                writer.write("\n");
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        int[][] sparseArray2 = new int[sum+1][3];
        BufferedReader reader = null;
        int num=0;
        try {
             reader = new BufferedReader(new FileReader(src));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\t");

                for (int i = 0; i < split.length; i++) {
                        sparseArray2[num][i]=Integer.parseInt(split[i]);
                }
                num++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println("磁盘取出来的稀疏数组------------------------");
        for (int[] row : sparseArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //创建一个恢复之后的二位数组

        int chessArr2[][] = new int[sparseArray2[0][0]][sparseArray2[0][1]];
        for (int i = 1; i < sparseArray2.length; i++) {
            chessArr2[sparseArray2[i][0]][sparseArray2[i][1]] = sparseArray2[i][2];
        }
        System.out.println();
        System.out.println("数据回复的二维数组----------------------------------");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
