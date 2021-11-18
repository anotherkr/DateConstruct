package test.homework_2.work2_1;


/**
 * @author yanhuanzhan
 * @date 2021/10/19 - 14:02
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node (1);
        Node node2 = new Node (2);
        Node node3 = new Node (3);
        Node node4 = new Node (4);
        SingleLinkedList singleLinkedList = new SingleLinkedList ( );
        singleLinkedList.add (node1);
        singleLinkedList.add (node2);
        singleLinkedList.add (node3);
        singleLinkedList.add (node4);
        System.out.println ("添加后遍历链表" );
        singleLinkedList.list ();
        singleLinkedList.delete (3);
        System.out.println ("删除后遍历链表" );
        singleLinkedList.list ();
    }
}
