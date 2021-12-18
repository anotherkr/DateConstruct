package main.test.homework_4.work4_3;

/**
 * @author yanhuanzhan
 * @date 2021/11/12 - 23:03
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree(new Node(10));
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(15);
        tree.insert(4);
        tree.insert(5);
        tree.insert(11);
        tree.insert(17);
        System.out.println("按后根次序遍历中序线索二叉树");
//        tree.postOrderList();
        System.out.println("中序遍历线索化二叉树");
        tree.threadedMidList();
//        System.out.println("插入16后中序遍历");
//        tree.insert(16);
//        tree.threadedMidList();
        System.out.println("删除11后中序遍历");
        tree.delete(11);
        tree.threadedMidList();
    }
}
