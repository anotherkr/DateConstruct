package main.test.homework_2.work2_5;

/**
 * @author yanhuanzhan
 * @date 2021/10/24 - 15:34
 */
public class DoubleLinkedList {
    Node head = new Node ( );
    public void add(Node node){
       Node cur = head;
       boolean flag = false;//标记是否相等
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.id > node.id) {
                break;
            }
            if (cur.next.id == node.id) {
                flag=true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            System.out.println ("节点"+node.id+"已经存在,添加失败" );
        }else {
            if (cur.next == null) {
                node.pre = cur;
                cur.next = node;
            }else {
                node.next = cur.next;
                cur.next.pre = node;
                cur.next = node;
                node.pre = cur;
            }
        }
    }
    //遍历
    public void list(){
        Node cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            System.out.println (cur.next.toString () );
            cur = cur.next;
        }
    }
}
