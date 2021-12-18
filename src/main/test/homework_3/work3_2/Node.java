package main.test.homework_3.work3_2;

/**
 * @author yanhuanzhan
 * @date 2021/10/29 - 17:14
 */
public class Node<E> {
    E e;
    Node<E> next;

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "e=" + e +
                '}';
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node(E e) {
        this.e = e;
    }
}
