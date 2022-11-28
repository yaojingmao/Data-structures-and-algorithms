package com.tc.linkedlist.singlelist;

public class SingleLinkedList {
    public HeroNode getHead() {
        return head;
    }

    private   HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("该排名已存在,请重新输入===" + heroNode.no);
            return;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;


    }

    public void list() {
        if (head.next == null) {
            System.out.println("该链表中没有数据，请先添加数据");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        if (temp.next == null) {
            System.out.println("该链表中没有数据，请先添加数据");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            return;
        }
        System.out.println("未找到该排名的数据");
    }

    public void update(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        if (temp.next == null) {
            System.out.println("该链表中没有数据，请先添加数据");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
           heroNode.next= temp.next.next;
           temp.next=heroNode;
            return;
        }
        System.out.println("未找到该排名的数据");
    }

    public void queryByNo(int no){
        HeroNode temp = head;
        boolean flag = false;
        if (temp.next == null) {
            System.out.println("该链表中没有数据，请先添加数据");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println(temp.next.toString());
            return;
        }
        System.out.println("未找到该排名的数据");
    }
}
