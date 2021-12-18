package main.test.homework_2.work2_10;

/**
 * @author yanhuanzhan
 * @date 2021/10/22 - 16:44
 */
public class RandomLinkedList<E> {
    int size;
    Node<E> head = new Node<> ();

    //删除
    public void delete(E e) {
        Node cur = head;
        boolean flag = false;//标记是否找到该节点
        while (true){
            if (cur.next == null) {
                break;
            }
            if (cur.next.e.equals (e)) {
                flag=true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            cur.next = cur.next.next;
        }else {
            System.out.println ("该曲目不存在,删除失败" );
        }
    }
    //添加
    public void add(E e){
        Node<E> cur = head;
        boolean flag = false;//检查是否有重复的曲目
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.e.equals (e)) {
                flag=true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            System.out.println ("添加的曲目重复,添加失败" );
        }else{
            size++;
            Node<E> newNode = new Node (e);
            cur.next = newNode;
            random ();//随机排列
        }

    }
    //随机插入
    public void randomInsert(Node<E> node){
        Node<E> cur = head;
        //注意:下面的size要-1,不然有概率死循环
        for (int i = 0; i < (int)(Math.random ( ) * (size-1)); i++) {//选择随机插入的位置
            cur = cur.next;
        }
        if (cur.next == null) {//如果该节点的下一个节点为空
            cur.next = node;
        }else {
            node.next = cur.next;
            cur.next = node;
        }
    }
    //随机排序
    public void random(){

        for (int i = 0; i < 10000; i++) {//随机插入次数
            Node<E> cur =head;//指针
            Node<E> getNode = cur.next;//被随机插入节点
            int j=0;
            int randomNum = (int)(Math.random ()*size);
            //随机选择要排序的节点
            while (j<randomNum){
                if (getNode.next==null) {//防止删除失败
                    break;
                }
                cur = cur.next;
                getNode=getNode.next;
                j++;
            }
            //把节点取出,即从链表删除
            if (getNode.next==null) {
                cur.next=null;
            }else {
                cur.next = getNode.next;
            }
            //将节点随机插入
            randomInsert (getNode);
        }
    }

    //遍历链表
    public void list() {
        Node<E> cur = head.next;
        while (true) {
            if (cur == null) {
                break;
            }
            System.out.println (cur.toString () );
            cur = cur.next;
        }
        random ();
    }
}
