package main.tree.binarytree;

/**测试
 * @author yanhuanzhan
 * @date 2021/10/3 - 1:59
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree ();
        //创建节点
        HeroNode root = new HeroNode (1,"宋江");
        HeroNode node2 = new HeroNode (2,"吴用");
        HeroNode node3 = new HeroNode (3,"卢俊义");
        HeroNode node4 = new HeroNode (4,"林冲");
        HeroNode node5 = new HeroNode (5,"关胜");
        //说明，我们先手动创建该二叉树，后面用递归的方法创建二叉树
        root.setLeft (node2);
        root.setRight (node3);
        node3.setRight (node4);
        node3.setLeft (node5);
        binaryTree.setRoot (root);
        //测试:
        System.out.println ("前序遍历" );//1,2,3,5,4
        binaryTree.preOrder ();
        //测试
        System.out.println ("中序遍历" );//2,1,5,3,4
        binaryTree.midOrder ();
        //测试
        System.out.println ("后序遍历" );//2,5,4,3.1
        binaryTree.postOrder ();
        //前序遍历查找
        System.out.println ("前序遍历查找-------" );
        HeroNode resNode = binaryTree.preOrderSearch (5);
        System.out.println (resNode );
        //中序遍历查找
        System.out.println ("中序遍历查找-------" );
        resNode = binaryTree.midOrderSearch (5);
        System.out.println (resNode );
        //后序遍历查找
        System.out.println ("后序遍历查找-------" );
        resNode = binaryTree.postOrderSearch (5);
        System.out.println (resNode );
        //测试删除
        System.out.println ("删除前--------" );
        binaryTree.preOrder ();
        System.out.println ("删除后--------" );
        binaryTree.delNode (3);
        binaryTree.preOrder ();
    }


}
