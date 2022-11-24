package com.tc.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero4);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.list();
        System.out.println("反序打印单链表-----------------");
        reversePrint(linkedList.getHead());


      /*  System.out.println("反转之后的链表");
        reverseLinkedList(linkedList.getHead());
        linkedList.list();*/
   /*     linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        linkedList.list();
        System.out.println("------------------------------");
//        linkedList.del(1);
//        linkedList.del(2);
//        linkedList.del(3);
//        linkedList.del(4);
//        linkedList.update(new HeroNode(4,"吴用2","智多星"));
        linkedList.list();
        System.out.println("查询指定编号的节点-----------------------");
//        linkedList.queryByNo(3);//查询指定编号的节点-----------------------
        System.out.println(getLength(linkedList.getHead())); //获取链表中有效节点的个数
        System.out.println(findLastIndex(linkedList.getHead(),5));//获取倒数第k个节点*/
    }

    //反序打印单链表
    public static void reversePrint(HeroNode head){
        if (head.next==null){
            return;
        }
        HeroNode temp=head.next;
        Stack<HeroNode>stack=new Stack<>();
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
    //反转单链表
    public static void reverseLinkedList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (temp != null) {
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;

    }

    //获取倒数第k个节点
    public static HeroNode findLastIndex(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }

        int size = getLength(head);
        HeroNode temp = head.next;

        if (index <= 0 || index > size) {
            return null;
        }
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;


    }

    //获取链表中有效节点的个数
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
