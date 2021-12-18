package main.huffmancode;



/** 节点类
 * @author yanhuanzhan
 * @date 2021/10/11 - 19:58
 */
public class Node implements Comparable<Node>{
    Byte data;//存放数据本身，比如'a'=>97
    int weight;//权值,表示字符出现的次数
    Node left;
    Node right;
    //前序遍历
    public void preOrder(){
        System.out.println (this );
        if (this.left != null) {
            this.left.preOrder ();
        }
        if (this.right != null) {
            this.right.preOrder ();
        }
    }

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从大到小排
        return o.weight-this.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public Byte getData() {
        return data;
    }

    public int getWeight() {
        return weight;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
