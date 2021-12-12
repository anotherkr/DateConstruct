package huffmantree;

/** 节点类
 *  为了让Node对象支持排序Collections集合排序
 *  让Node实现Comparable接口
 * @author yanhuanzhan
 * @date 2021/10/11 - 10:50
 */
public class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;//指向左子节点
    Node right;//指向右子节点

    //写一个前序遍历
    public void preOrder() {
        System.out.println ( );
        if (this.left != null) {
            this.left.preOrder ();
        }
        if (this.right != null) {
            this.right.preOrder ();
        }

    }
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排
        return this.value-o.value;
    }
}
