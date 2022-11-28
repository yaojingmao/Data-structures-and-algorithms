package com.tc.linkedlist.stack;

public class Person {
    public int num;
    public Person next;

    public Person(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Person{" +
                "num=" + num +
                '}';
    }
}
