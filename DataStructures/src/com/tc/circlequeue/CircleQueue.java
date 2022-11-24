package com.tc.circlequeue;


//定义一个循环队列
public class CircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //初始化队列，maxSize队列长度，front队列头部的位置，rear队列尾部后一个的位置，保留一个标记位
    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //查看队列中的所有元素
    public void showQueueAll() {
        if (isEmpty()) {
//            throw new RuntimeException("队列数据为空，请先添加数据");
            System.out.println("队列数据为空，请先添加数据");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\t", i % maxSize, arr[i % maxSize]);
        }
    }

    // 返回循环队列里面有多少个数据
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    //查看队列的头部元素
    public int showHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列数据为空，请先添加数据");
        }
//        因为front是指向队列头部的前一个位置所以加1
        return arr[front];
    }

    //向队列中尾部添加一个元素
    public void addQueue(int value) {
//        判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满不能添加数据");
            return;
        }
        arr[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    //从队列的头部取出一个元素
    public int getQueue() {
//        判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列数据为空，请先添加数据");
        }

        int value = arr[front];

        front = (front + 1) % maxSize;
        return value;

    }

}
