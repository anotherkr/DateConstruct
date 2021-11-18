package test.homework_2.work2_7;




/** 单链表解决约瑟夫问题
 * @author yanhuanzhan
 * @date 2021/10/19 - 13:44
 */
public class SingleLinkedList<E> {
    Node<E> head = null;
    int size;
    //编写解决约瑟夫问题的方法

    /**
     *
     * @param begin 代表从第几个开始数
     * @param count 代表数几下
     */
    public void josefu( int begin, int count) {
        //先对数据进行校验
        if (head == null || begin > size || begin < 1) {
            System.out.println ("数据有误,请重新输入" );
            return ;
        }
        Node<E> cur = head;//辅助指针,先移动到头节点后面，方便去除数到的节点
        while (true) {
            if (cur.next == head) {
                break;
            }
            cur = cur.next;
        }
        //先让头节点移动到开始位置
        for (int i = 0; i < begin - 1; i++) {
            head = head.next;
            cur = cur.next;
        }
        while (true) {
            if (cur == head) {//说明圈中只有一个节点
                break;
            }
            for (int j = 0; j < count-1; j++) {
                head = head.next;
                cur = cur.next;
            }
            System.out.println (head.e+"出圈" );
            head = head.next;
            cur.next = head;
        }
        System.out.println ("最后留在圈中的为"+cur.e );
    }
//添加节点
    public void add(E e) {
        if (head == null) {
            head = new Node<> (e);
            head.next=head;//形成环
            size++;
            return;
        }
        Node cur = head;
        while (true) {
            if (cur.next == head) {
                break;
            }

            cur = cur.next;
        }
        Node<E> newNode = new Node<> (e);
            newNode.next = head;
            cur.next = newNode;
            size++;
    }



    //遍历节点
    public void list() {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (true) {
            if (cur.next == head) {
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
