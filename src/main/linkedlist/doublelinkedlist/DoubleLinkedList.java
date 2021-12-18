package main.linkedlist.doublelinkedlist;

/**
 * @author yanhuanzhan
 * @date 2021/12/6 - 22:07
 */
public class DoubleLinkedList {
    Node head;

    public DoubleLinkedList() {
        head = new Node(0,"");
    }

    //添加
    public void add(Node newNode) {
        //辅助指针
        Node temp=head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.pre = temp;
    }
    //按顺序添加
    public void addByOrder(Node newNode) {

    }

}
