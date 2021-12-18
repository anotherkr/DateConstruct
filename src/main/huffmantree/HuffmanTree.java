package main.huffmantree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 *
 * @author yanhuanzhan
 * @date 2021/10/11 - 10:49
 */
public class HuffmanTree {
    public static void main(String[] args) {
      int arr[] = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree (arr);
      preOrder (root);
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder ();
        }else {
            System.out.println ("是空树,不能遍历" );
        }
    }
    //创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr) {
        //第一步为了操作方便
        //先遍历arr数组，将arr的每一个元素构成一个Node,然后将Node放入ArrayList中
        List<Node> nodes = new ArrayList<> ( );
        for (int value : arr) {
            nodes.add (new Node (value));
        }
        //当只剩最后一个节点时循环结束
        while (nodes.size ( ) > 1) {
            //排序，从小到大
            Collections.sort (nodes);
            //取出根节点权值最小的两颗二叉树
            //(1)取出权值最小的两个节点(二叉树)
            Node leftNode = nodes.get (0);
            Node rightNode = nodes.get (1);
            //(2)构建一颗新的二叉树
            Node parent = new Node (leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //从ArrayList删除处理过的二叉树
            nodes.remove (leftNode);
            nodes.remove (rightNode);
            //将parent加入到nodes
            nodes.add (parent);
        }
       //返回赫夫曼树的root节点
        return nodes.get (0);

    }

}
