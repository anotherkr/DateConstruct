package test.homework_2.work2_1;

/**
 * @author yanhuanzhan
 * @date 2021/10/19 - 13:44
 */
public class Node {
    int id;
    Node next;
    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
