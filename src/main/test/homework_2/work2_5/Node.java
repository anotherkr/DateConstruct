package main.test.homework_2.work2_5;

/**
 * @author yanhuanzhan
 * @date 2021/10/24 - 15:34
 */
public class Node {
    int id;
    Node next;
    Node pre;
    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node(int id) {
        this.id = id;
    }

    public Node() {
    }
}
