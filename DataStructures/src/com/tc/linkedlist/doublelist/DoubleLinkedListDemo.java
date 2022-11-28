package com.tc.linkedlist.doublelist;



public class DoubleLinkedListDemo {
    public static void main(String[] args) {
       HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
       HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
       HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
       HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        DoubleLinkedList linkedList = new DoubleLinkedList();
       /* linkedList.add(hero1);
        linkedList.add(hero4);
        linkedList.add(hero2);
        linkedList.add(hero3);*/
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        linkedList.list();
        System.out.println("修改之后的链表------------------");
        linkedList.update(new HeroNode(1, "吴用22", "智多星22"));
        linkedList.list();
        System.out.println("删除之后的链表------------------");
        linkedList.del(1);
        linkedList.list();
        linkedList.queryByNo(1);
    }
}
