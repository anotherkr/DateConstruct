package main.test.homework_2.work2_9;

/**
 * @author yanhuanzhan
 * @date 2021/10/23 - 13:31
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node (2, 0);
        Node node2 = new Node (6, 0);
        Node node3 = new Node (4, 1);
        Node node4 = new Node (5, 1);
        Node node5 = new Node (7, 2);
        Node node6 = new Node (4, 2);
        SingleLinkedList list1 = new SingleLinkedList ();
        SingleLinkedList list2 = new SingleLinkedList ();
        list1.add (node1);
        list1.add (node3);
        list1.add (node5);
        list2.add (node2);
        list2.add (node4);
        list2.add (node6);
        System.out.printf ("链表1:");
        list1.list ();
        System.out.printf ("链表2:");
        list2.list ();
        SingleLinkedList list3 = new SingleLinkedList ();
        list3.setHead (list1.addList (list2.getHead ()));
        System.out.printf ("相加得链表3:");
        list3.list ();
    }
}
