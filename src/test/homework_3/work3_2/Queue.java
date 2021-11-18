package test.homework_3.work3_2;

/**
 * @author yanhuanzhan
 * @date 2021/10/29 - 17:14
 */
public class Queue<E> {
    Node<E> head;
    Node<E> rear;
    int size;
    public Queue() {
        head=rear=null;

    }

    public boolean isEmpty() {
        return head==null&&rear==null;
    }
    public void add(E e){
        if (e == null) {
            return;
        }
        Node<E> newNode = new Node (e);
        System.out.println (e+"加入队列" );
        if (head == null) {
            head=newNode;
            rear=head;
            rear.next=head;

        }else {
            rear.next=newNode;
            rear=rear.next;
            rear.next=head;
        }
    }
    //取队列头部元素但不删除
    public E peek(){
        System.out.println ("队列头部为"+head.e );
        return isEmpty ()?null:head.e;
    }
    //取队列头部元素且删除
    public E  poll(){
        if (isEmpty ( )) {
            System.out.println ("队列为空" );
            return null;
        }
        if (rear == head&&rear!=null) {
            E e = head.e;
            head=null;
            rear=null;
            System.out.println (e+"出队列" );
            return e;
        }else {
            E e = head.e;
            head = head.next;
            rear.next = head;
            System.out.println (e+"出队列" );
            return e;
        }
        
    }


}
