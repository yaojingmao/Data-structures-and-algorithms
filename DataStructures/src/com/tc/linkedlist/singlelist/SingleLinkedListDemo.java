package com.tc.linkedlist.singlelist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "林冲", "豹子头");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero7 = new HeroNode(7, "林冲", "豹子头");
        HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero3);
        linkedList.add(hero5);
        linkedList.add(hero7);
        SingleLinkedList linkedList2 = new SingleLinkedList();
        linkedList2.add(hero2);
        linkedList2.add(hero4);
        linkedList2.add(hero6);
        linkedList2.add(hero8);
        mergeLinkedList(linkedList, linkedList2);


/*        linkedList.list();
        System.out.println("反序打印单链表-----------------");
        reversePrint(linkedList.getHead());*/


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

    //合并两个有序的单链表，合并之后的链表依然有序
    public static void mergeLinkedList(SingleLinkedList list1, SingleLinkedList list2) {
        SingleLinkedList mergeList = new SingleLinkedList();
        HeroNode mergeHead = mergeList.getHead();
        HeroNode head1 = list1.getHead();
        HeroNode head2 = list2.getHead();
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;
        HeroNode mergeTemp = mergeHead;
        while (true) {
            if (temp1 == null && temp2 == null) {
                break;
            }
            if (temp1 == null) {
                mergeTemp.next = temp2;
                mergeTemp = mergeTemp.next;
                temp2 = temp2.next;
                continue;
            }
            if (temp2 == null) {
                mergeTemp.next = temp1;
                mergeTemp = mergeTemp.next;
                temp1 = temp1.next;
                continue;
            }
            if (temp1.no > temp2.no) {
                mergeTemp.next = temp2;
                temp2 = temp2.next;
                mergeTemp = mergeTemp.next;
                continue;
            }
            mergeTemp.next = temp1;
            temp1 = temp1.next;
            mergeTemp = mergeTemp.next;

        }
        mergeList.list();


    }


    //反序打印单链表
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
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
