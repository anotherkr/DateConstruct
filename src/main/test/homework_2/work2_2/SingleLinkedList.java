package test.homework_2.work2_2;



/**
 * @author yanhuanzhan
 * @date 2021/10/19 - 13:44
 */
public class SingleLinkedList<E> {
    Node<E> head = new Node ("");

    //比较两个链表是否相等
    public boolean equals(Object object) {
        SingleLinkedList<E> list2 = (SingleLinkedList<E>) object;
        Node cur1 = head;
        Node cur2 = list2.getHead ();
        boolean flag = true;//标记是否相等
        while (true) {
            if (cur1.next == null && cur2.next == null) {
                break;
            }
            if (!cur1.getE ( ).equals (cur2.getE ( ))) {
                flag = false;
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return flag;
    }
    //替换方法

    /**
     *
     * @param obj 被替换的对象
     * @param element 要替换的对象
     * @return
     */
    public boolean replace(Object obj, E element) {
        Node<E> cur = head;
        boolean flag = false;//标记是否找到
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.getE ( ).equals (obj)) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            Node<E> newNode = new Node<> (element);
            newNode.next = cur.next.next;
            cur.next = newNode;
        }else {
            System.out.println ("找不到指定对象节点" );
        }
        return flag;
    }
    //移去首次出现的指定对象
    public void remove(E element) {
        Node cur = head;
        boolean flag = false;
        while (true) {
            if (cur == null) {
                break;
            }
            if (cur.next.getE ( ).equals (element)) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            cur.next = cur.next.next;
        } else {
            System.out.println ("指定对象节点不存在" );
        }
    }
    //以查找结果判断单链表是否包含指定对象
    public boolean contain(E element) {
        Node<E> searchNode = search (element);
        if (searchNode == null) {
            return false;
        } else {
            return true;
        }
    }
    //查找
    public Node<E> search(E element) {
        if (head.next == null) {
            System.out.println ("链表为空,查找失败" );
            return null;
        }
        Node cur = head.next;
        boolean flag = false;//标记是否找到指定对象
        while (true) {
            if (cur == null) {
                break;
            }
            if (cur.e.equals (element)) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            return cur;
        }else {
            System.out.println ("链表内未找到指定节点" );
            return null;
        }
    }
    //将指定链表list接在当前链表之后
    public void concat(SingleLinkedList list) {
        Node<E> cur1 = head;
        Node<E> cur2 = list.getHead ().next;
        while (true) {
            if (cur1.next == null) {
                break;
            }
            cur1 = cur1.next;
        }
        cur1.next = cur2;//将新链表的第一个节点接在后面
    }
    //以单链表list构造新的单链表
    public SingleLinkedList(SingleLinkedList list) {
        if (list.getHead ( ) == null) {
            System.out.println ("链表为空,无法生成新的链表" );
            return;
        }
        Node<E> cur1 = head;
        Node<E> cur2 = list.getHead ();
        while (true) {
            if (cur2.next == null) {
                break;
            }
            Node<E> newNode = new Node ((E) cur2.next.getE ());
            cur1.next = newNode;
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
    }
    //由指定数组中的多个对象构造单链表
    public SingleLinkedList(E[] element) {
        Node<E> cur = head;
        for (int i = 0; i < element.length; i++) {
            Node<E> newNode = new Node (element[i]);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next;
        }
    }
//添加节点
    public void add(Node newNode) {
        Node cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }

            cur = cur.next;
        }
            newNode.next = cur.next;
            cur.next = newNode;

    }

    //删除节点
    public void delete(Node node) {
        Node cur = head;
        boolean flag = false;//标记是否找到节点
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.e.equals (node.e) ) {
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
