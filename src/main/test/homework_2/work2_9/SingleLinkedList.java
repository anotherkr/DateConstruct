package main.test.homework_2.work2_9;

/**
 * @author yanhuanzhan
 * @date 2021/10/23 - 12:47
 */
public class SingleLinkedList {
    Node head = new Node ( );

    //添加，按指数从大到小排列
    public void add(Node node) {
        Node cur = head;
        boolean flag = false;//标记是否相等
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.index < node.index) {
                break;
            }
            if (cur.next.index == node.index) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            cur.next.coefficient += node.coefficient;//系数相加
        } else {
            node.next = cur.next;
            cur.next = node;
        }
    }

    //两个多项式相加,即两个链表相加
    public Node addList(Node head2) {
        if (head.next == null) {
            return head2;
        }
        if (head2.next == null) {
            return head;
        }
        if (head2 == null && head == null) {
            return null;
        }
        Node cur1 = head.next;//第一条链表的辅助指针
        Node cur2 = head2.next;//第二条链表的辅助指针
        Node newHead = new Node ( );
        Node newCur = newHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.index > cur2.index) {
                newCur.next = cur1;
                cur1 = cur1.next;
            } else if(cur1.index<cur2.index) {
                newCur.next = cur2;
                cur2 = cur2.next;
            }else {
                cur1.coefficient+=cur2.coefficient;
                newCur.next = cur1;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            newCur = newCur.next;
        }
        if (cur1 == null) {
            newCur.next = cur2;
        } else {
            newCur.next = cur1;
        }
        return newHead;
    }

    //遍历链表
    public void list() {
        Node cur = head.next;
        StringBuilder stringBuilder = new StringBuilder (cur.coefficient + "x^" + cur.index);
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.index == 0) {
                stringBuilder.append ("+" + cur.next.coefficient);
            } else {
                stringBuilder.append ("+" + cur.next.coefficient + "x^" + cur.next.index);
            }
            cur = cur.next;
        }
        System.out.println (stringBuilder);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
