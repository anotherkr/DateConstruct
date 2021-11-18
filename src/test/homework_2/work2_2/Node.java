package test.homework_2.work2_2;

/**
 * @author yanhuanzhan
 * @date 2021/10/19 - 13:44
 */
public class Node<E> {
    E e;
    Node next;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public Node(E e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "Node{" +
                "e=" + e +
                '}';
    }
}
