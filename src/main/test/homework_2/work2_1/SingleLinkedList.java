package main.test.homework_2.work2_1;

/**
 * @author yanhuanzhan
 * @date 2021/10/19 - 13:44
 */
public class SingleLinkedList {
    Node head = new Node (-1);
//有序插入节点
    public void add(Node newNode) {
        Node cur = head;
        boolean flag = false;//标记编号是否存在
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.id > newNode.id) {
                break;
            }
            if (cur.next.id == newNode.id) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            System.out.println ("编号已经存在");
        } else {
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    //删除节点
    public void delete(int id) {
        Node cur = head;
        boolean flag = false;//标记是否找到节点
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.id == id) {
                flag = true;//找到
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            cur.next = cur.next.next;
        } else {
            System.out.println ("未找到节点,删除失败" );
        }
    }

    //遍历节点
    public void list() {
        if (head.next == null) {
            return;
        }
        Node cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }

            cur = cur.next;
            System.out.println (cur.toString () );
        }

    }
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
