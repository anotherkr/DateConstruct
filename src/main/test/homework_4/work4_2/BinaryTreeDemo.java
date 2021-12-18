package main.test.homework_4.work4_2;


import java.util.List;

/**
 * @author yanhuanzhan
 * @date 2021/11/13 - 16:27
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new Node(10,null));
        tree.add(11);
        tree.add(13);
        tree.add(1);
        tree.add(2);
        tree.add(7);
        System.out.println("中序遍历:");
        tree.midOrderList();
        //测试寻找父母节点
        int no1=7;
        Node parent = tree.searchParent(no1);
        if (parent != null) {
            System.out.println("节点"+no1+"的父母节点为"+parent.toString());
        }
        //测试寻找祖先节点
        int no2=7;
        List<Node> nodes = tree.searchAncestors(no2);
        if (nodes.size()!=0) {
            System.out.print("节点"+no2+"的祖先节点为:");
            for (Node node : nodes) {
                System.out.printf(node.toString());
            }
        }
        System.out.println();
        //测试寻找共同祖先节点
        int no3=7;
        int no4=2;
        Node common = tree.searchCommon(no3, no4);
        System.out.println(no3+"和"+no4+"的共同祖先节点(最近)为:"+common.toString());
    }
}
