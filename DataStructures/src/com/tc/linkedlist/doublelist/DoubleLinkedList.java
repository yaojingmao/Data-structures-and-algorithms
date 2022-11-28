package com.tc.linkedlist.doublelist;

public class DoubleLinkedList {
    HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode newHero) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = newHero;
        newHero.pre = temp;
    }

    public void addByOrder(HeroNode newHero) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (newHero.no < temp.next.no) {
                break;
            }
            if (temp.next.no == newHero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("该排名已存在,请重新输入===" + newHero.no);
            return;
        }
        newHero.next = temp.next;
        newHero.pre = temp;
        if (temp.next != null) {
            temp.next.pre = newHero;

        }
        temp.next = newHero;
    }

    public void list() {
        HeroNode temp = head.next;
        if (temp == null) {
            System.out.println("链表为空，请先添加数据");
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public void update(HeroNode heroNode) {
        HeroNode temp = head.next;
        boolean flag = false;
        if (temp == null) {
            System.out.println("链表为空，请先添加数据");
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
            return;
        }
        System.out.println("未找到该编号的数据");
    }

    public void del(int no) {
        HeroNode temp = head.next;
        boolean flag = false;
        if (temp == null) {
            System.out.println("链表为空，请先添加数据");
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
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
