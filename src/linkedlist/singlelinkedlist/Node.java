package linkedlist.singlelinkedlist;

/**创建一个节点对象
 * @author yanhuanzhan
 * @date 2021/9/23 - 11:47
 */
public class Node {
    private int id;
    private String name;
    private int age;
    private Node next;

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getId() {
        return id;
    }

    public Node(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Node() {
    }
}
