package com.tc.linkedlist.stack;

public class ArrayStack2 {
    public int maxSize;
    public int top;
    public int[] array;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[this.maxSize];
        top = -1;
    }

    public int peek() {
        return array[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isOper(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }
        return false;
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

    //判断符号的优先级
    public int priority(int val) {
        if (val == '*' || val == '/') {
            return 1;
        }
        if (val == '+' || val == '-') {
            return 0;
        }
        return -1;
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;

    }

}
