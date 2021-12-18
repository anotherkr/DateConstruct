package main.test.homework_2.work2_4;

/**
 * @author yanhuanzhan
 * @date 2021/10/24 - 16:05
 */
public class Node<E> {
    E e;
    Node<E> next;
    Node<E> pre;

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "e=" + e +
                '}';
    }

    public Node(E e) {
        this.e = e;
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

    public Node<E> getPre() {
        return pre;
    }

    public void setPre(Node<E> pre) {
        this.pre = pre;
    }
}
