package com.tc.linkedlist.stack;

//用单链表实现数组
public class LinkedListStack {
    public int maxSize;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    Person head = new Person(0);

    public boolean isEmpty() {
        return head.next == null;
    }

    public int count() {
        int count = 0;
        Person temp = head.next;
        if (temp == null) {
            return 0;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void list() {
        int count = 0;
        Person temp = head.next;
        if (temp == null) {
            System.out.println("链表为空，请先输入数据");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    public void push(Person person) {
        if (count() == maxSize) {
            System.out.println("栈满");
            return;
        }

        if (head.next == null) {
            head.next = person;
            return;
        }
        person.next = head.next;
        head.next = person;
    }

    public void pop() {
        if (head.next == null) {
            System.out.println("栈空请先输入数据");
            return;
        }
        System.out.println("删除的是"+ head.next);
        head.next = head.next.next;
    }

}
