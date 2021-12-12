package tree.threadedbinarytree;

/**
 * @author yanhuanzhan
 * @date 2021/10/8 - 15:48
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试中序线索二叉树
        HeroNode root = new HeroNode (1, "tom");
        HeroNode node2 = new HeroNode (3, "jack");
        HeroNode node3 = new HeroNode (6, "smith");
        HeroNode node4 = new HeroNode (8, "mary");
        HeroNode node5 = new HeroNode (10, "king");
        HeroNode node6 = new HeroNode (14, "dim");
        //后面用递归创建二叉树，这次先手动创建
        root.setLeft (node2);
        root.setRight (node3);
        node2.setLeft (node4);
        node2.setRight (node5);
        node3.setLeft (node6);
        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree ( );
        threadedBinaryTree.setRoot (root);
        //中序线索化二叉树
//        threadedBinaryTree.threadedMidNode ();
        //前序线索化二叉树
        threadedBinaryTree.threadedPreNode ();
        //后序线索化二叉树
//        threadedBinaryTree.threadedPostNode ( );
        //以10号节点测试
        HeroNode leftNode = node5.getLeft ( );
        System.out.println ("10号节点的前驱节点:" + leftNode);//中序:3,前序:8,后序:8
        HeroNode rightNode = node5.getRight ( );
        System.out.println ("10号节点的后继节点:" + rightNode);//中序:1,前序:6，后序:3
        //线索化二叉树后不能再使用先前的遍历方式了
        //中序线索化遍历
//        threadedBinaryTree.threadedMidList ( );
        //前序线索化遍历
        threadedBinaryTree.threadedProList ();
        //后序线索化遍历
//        threadedBinaryTree.threadedPostList ();
// 后序线索化遍历(递归)
//        threadedBinaryTree.threadedPostList2 ();
    }
}
