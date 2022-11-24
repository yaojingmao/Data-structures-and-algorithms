package com.tc.queue;

//定义一个队列
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
//初始化队列，maxSize队列长度，front队列头部的前一个位置，队列尾部的位置
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;
        rear = -1;
    }
//判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }
//判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }
//查看队列中的所有元素
    public void showQueueAll() {
        if (isEmpty()) {
            throw new RuntimeException("队列数据为空，请先添加数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
//查看队列的头部元素
    public int showHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列数据为空，请先添加数据");

        }
//        因为front是指向队列头部的前一个位置所以加1
        return arr[front + 1];
    }
//向队列中尾部添加一个元素
    public void addQueue(int value) {
//        判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满不能添加数据");
            return;
        }
        rear++;
        arr[rear] = value;
    }
//从队列的头部取出一个元素
    public int getQueue() {
//        判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列数据为空，请先添加数据");
        }
        front++;
        return arr[front];

    }

}
