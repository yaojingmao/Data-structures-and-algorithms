package com.tc.linkedlist.stack;

//采用数组模拟栈
public class ArrayStack {
    public int maxSize;
    public int top;
    public int[] array;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.array =new int[this.maxSize];
        top=-1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int pop() {
        //先判断栈是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = array[top];
        top--;
        return value;
    }

    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        array[top] = value;
    }

    public void list() {
        //先判断栈是否空
        if (isEmpty()) {
            //抛出异常
            System.out.println("栈空，没有数据~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n", i, array[i]);
        }
    }

}
