package com.tc.linkedlist.josepfu;

public class CircleSingleLinkedList {
    //    指定一个头节点
    Boy first = null;

    //增加孩子形成环的方法
    public void addBoy(int nums) {
//        判断输入的数是否合法
        if (nums < 1) {
            System.out.println("你所添加的个数不正确");
            return;
        }
//        设置一个遍历指针
        Boy curBoy = null;
//        遍历要添加孩子的数量，形成一个环
        for (int i = 1; i <= nums; i++) {
//            创建第i个孩子对象
            Boy boy = new Boy(i);
//            但孩子是第一个时
            if (i == 1) {
//                将第一个孩子赋值给first指针
                first = boy;
//                因为一个孩子也要形成一个环将自己的next指针指向自己
                first.setNext(first);
//                将first指针赋值给遍历指针
                curBoy = first;
            }
//            将当前的curBoy指针指向的Boy对象的next指向新的节点
            curBoy.setNext(boy);
//            将新的节点指向头部
            boy.setNext(first);
//            遍历指针向后移，就变成了遍历指针指向新的节点
            curBoy = boy;
        }
    }

    public void showBoy() {
//
        Boy curBoy = first;
        if (first == null) {
            System.out.println("该链表没有节点，请先添加节点");
        }
        while (true) {
            System.out.printf("该男孩的编号是 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    public void countNumber(int startNo, int countNum, int nums) {
//        进行数据校验
        if (first == null || startNo < 0 || startNo > nums) {
            System.out.println("你所输入的参数不对，请重新输入…………");
            return;
        }
//        设置一个帮助指针
        Boy helper = first;
//        该循环是将帮助指针放到first的前一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
//        该循环是将first指针放到指定的节点开始报数，就是起始报数的位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
//        该循环就是小孩出队列的实现
        while (true) {
//            当first=helper时说明循环链表只有一个节点，退出条件
            if (first == helper) {
                break;
            }
//            该for循环是数countNum下指针移动countNum-1次，最终first指向的是出圈的节点
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩的编号为 %d \n", first.getNo());
//            出圈的实现
            first = first.getNext();
            helper.setNext(first);

        }
//        最后小孩的序号
        System.out.printf("小孩的编号为 %d \n", first.getNo());

    }

}
