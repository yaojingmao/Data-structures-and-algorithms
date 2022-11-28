package com.tc.linkedlist.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show :查看栈中元素");
            System.out.println("add :向栈添加元素");
            System.out.println("del :删除栈顶元素");
            System.out.println("exit :程序退出");
            System.out.println("请输入你的选择...");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "add":
                    System.out.println("请输入一个整数....");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "del":
                    try {
                        int a = stack.pop();
                        System.out.println(a);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("程序已退出....");
    }
}
