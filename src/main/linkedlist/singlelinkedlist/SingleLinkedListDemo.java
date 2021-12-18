package main.linkedlist.singlelinkedlist;

/**
 * @author yanhuanzhan
 * @date 2021/9/23 - 11:44
 */

import java.util.Stack;

/**
 * 单向链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList ();
        Node node1 = new Node (1, "颜", 11);
        Node node2 = new Node (2, "焕", 12);
        singleLinkedList.addByOrder (node2);
        singleLinkedList.addByOrder (node1);
        singleLinkedList.list ();
        singleLinkedList.update (new Node (2,"11",111));
        singleLinkedList.list ();
        System.out.println ("测试查找单链表中的倒数第k个节点(新浪面试题)" );
        Node lastIndxe = findLastIndexNode (singleLinkedList.getHead (),1);
        System.out.println (lastIndxe );
        System.out.println ("测试合并有序列表" );
        SingleLinkedList s1 = new SingleLinkedList ();
        SingleLinkedList s2 = new SingleLinkedList ();
        Node node3 = new Node (3, "3", 11);
        Node node4 = new Node (4, "4", 12);
        Node node5 = new Node (5, "4", 12);
        Node node6 = new Node (6, "4", 12);
        Node node7 = new Node (7, "4", 12);
        s1.addByOrder (node1);
        s2.addByOrder (node2);
        s1.addByOrder (node3);
        s2.addByOrder (node4);
        s1.addByOrder (node5);
        s2.addByOrder (node6);
        s1.addByOrder (node7);
        //合并
        //(自己写的方案)
//        SingleLinkedList s3=merge (s1,s2);
//        s3.list ();
        Node newHead = merge2 (s1.getHead ( ), s2.getHead ( ));
        SingleLinkedList newS = new SingleLinkedList ();
        newS.setHead (newHead);
        newS.list ();
        System.out.println ("对链表进行反转" );
        SingleLinkedList reverseList = new SingleLinkedList ();
        reverseList.setHead (reverseList (newS.getHead ( )));
        reverseList.list ();
        System.out.println ("逆序打印" );
        reversePrint (reverseList.getHead ());
    }

    //查找单链表中的倒数第k个节点【新浪面试题】
    //思路:
    //1,编写一个方法,接收head节点,同时接收一个index
    //2,index 表示的是倒数第index个节点
    //3,先把链表从头到尾遍历,得到总长度getLength
    //4,得到size后,我们从链表的第一个开始遍历(size-index)个,就可以得到
    public static Node findLastIndexNode(Node head,int index) {
        if(head.getNext ()==null){
            return null;
        }
        Node temp = head.getNext ();
        //链表长度
        int size = length (head);
        System.out.println (size );
        for (int i = 0; i < size - index; i++) {
            temp = temp.getNext ();
        }
         return temp;

    }

    public static int length(Node head) {
        Node temp = head;
        int count = 0;//计算节点个数
        if (head.getNext ( ) == null) {
            return 0;
        }
        while (true) {
            if (temp.getNext ( ) == null) {
                break;
            }
            count++;
            temp = temp.getNext ();
        }
        return count;
    }

    //合并两个有序链表，合并后的链表依然有序(自己做出来的写法)
    public static SingleLinkedList merge(SingleLinkedList s1, SingleLinkedList s2) {
        if (s1.getHead ( ).getNext ( ) == null && s2.getHead ( ).getNext ( ) == null) {
            return new SingleLinkedList ();
        }
        if (s1.getHead ( ).getNext ( ) == null) {
            return s2;
        }
        if (s2.getHead ( ).getNext ( ) == null) {
            return s1;
        }
        SingleLinkedList s3 = new SingleLinkedList ( );
        Node cur1 = s1.getHead ().getNext ();
        Node cur2 = s2.getHead ().getNext ();
        Node cur3 = s3.getHead ();
        //存放cur2的下一个节点
        Node next2 = new Node ( );
        cur3.setNext (cur1);
        while (cur2 != null) {
            //标记s3是否存在与s2节点相同的编号
            boolean flag = false;
            while (cur3.getNext ( ) != null) {
                if (cur2.getId ( ) < cur3.getNext ( ).getId ( )) {
                    break;
                }
                if (cur2.getId ( ) == cur3.getNext ( ).getId ( )) {
                    flag = true;
                    break;
                }
                cur3 = cur3.getNext ();
            }
            if (flag) {
                System.out.println ("节点编号"+cur2.getId ()+"已经存在" );
            }else {
                next2 = cur2.getNext ();
                cur2.setNext (cur3.getNext ());
                cur3.setNext (cur2);
            }
            cur2 = next2;
        }
        return s3;
    }
    //合并两个有序链表(网上找到的做法)
    public static Node merge2(Node head1,Node head2){
        if (head1.getNext () == null && head2.getNext () == null) {
            return new Node (0,"",0);
        }
        if (head1.getNext () == null) {
            return head2;
        }
        if (head2.getNext () == null) {
            return head1;
        }
        Node cur1 = head1.getNext ();
        Node cur2 = head2.getNext ();
        Node newHead = new Node (0,"",0);
        Node newCur = newHead;
        //两个链表任何一个为空循环就终止
        while (cur1 != null && cur2 != null) {
            if (cur1.getId ( ) < cur2.getId ( )) {
                newCur.setNext (cur1);
                cur1 = cur1.getNext ();
            }else {
                newCur.setNext (cur2);
                cur2 = cur2.getNext ();
            }
            newCur = newCur.getNext ();
        }
        if (cur1 == null) {
            newCur.setNext (cur2);
        }
        if (cur2 == null) {
            newCur.setNext (cur1);
        }
        return newHead;
    }

    //将单链表进行反转
    public static Node reverseList(Node head) {
        //如果当前链表为空或只有一个节点时,无需反转
        if (head.getNext ( ) == null||head.getNext ().getNext ()==null) {
            return head;
        }
        Node newHead = new Node ( );
        Node cur = head.getNext ();
        Node next = new Node ( );//用于保存cur的下一个节点

        while (cur != null) {
           next = cur.getNext ();//保存辅助指针的下一个节点
            cur.setNext (newHead.getNext ());
            newHead.setNext (cur);//将cur连接到新的链表
            cur = next;
        }
        //将head.next指向reverseHead.next实现链表的反转
        head.setNext (newHead.getNext ());
        return newHead;
    }
    //将链表逆序打印
//可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点
    public static void reversePrint(Node head) {
        if(head.getNext () == null) {
            return;//空链表，不能打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<Node> stack = new Stack<> ();
        Node cur = head.getNext ();
        //将链表所有节点压入栈
        while(cur !=null) {
            stack.push(cur);
            cur = cur.getNext ();
        }
        //将栈中节点进行打印，pop出栈
        while(stack.size()>0) {
            System.out.println(stack.pop());//先进后出
        }
    }
}

