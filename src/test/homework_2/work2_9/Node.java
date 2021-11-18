package test.homework_2.work2_9;

/**
 * @author yanhuanzhan
 * @date 2021/10/23 - 12:47
 */
public class Node {
    int coefficient;//系数
    int index;//指数
    Node next;

    public Node(int coefficient, int index) {
        this.coefficient = coefficient;
        this.index = index;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "coefficient=" + coefficient +
                ", index=" + index +
                '}';
    }
}
