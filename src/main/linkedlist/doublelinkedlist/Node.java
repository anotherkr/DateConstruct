package main.linkedlist.doublelinkedlist;

/**
 * @author yanhuanzhan
 * @date 2021/12/6 - 22:07
 */
public class Node {
    int id;
    String name;
    Node pre;
    Node next;

    public Node(int id,String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
