package test.homework_2.work2_5;

/**
 * @author yanhuanzhan
 * @date 2021/10/24 - 15:49
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList ();
        Node node1 = new Node (1);
        Node node2 = new Node (2);
        Node node3 = new Node (3);
        Node node4 = new Node (4);
        //从大到小添加,从小到大排序
        linkedList.add (node4);
        linkedList.add (node3);
        linkedList.add (node2);
        linkedList.add (node1);
        linkedList.list ();
    }
}
