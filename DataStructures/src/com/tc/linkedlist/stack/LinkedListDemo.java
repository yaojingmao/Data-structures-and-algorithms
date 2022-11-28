package com.tc.linkedlist.stack;

import java.util.Scanner;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack(3);
//        System.out.println(linkedListStack.count());
//        linkedListStack.list();
//        linkedListStack.pop();
        Person person1=new Person(1);
        Person person2=new Person(2);
        Person person3=new Person(3);
        Person person4=new Person(4);
        linkedListStack.push(person1);
        linkedListStack.push(person2);
        linkedListStack.push(person3);
        linkedListStack.push(person4);
        linkedListStack.list();
        System.out.println("删除栈顶之后的数据");
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.list();

    }
}
