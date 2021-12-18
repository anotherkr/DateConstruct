package main.test.homework_4.work4_1;

/**
 * @author yanhuanzhan
 * @date $(DATE) - ${}
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        Node[] nodes = {new Node(1),new Node(3),new Node(15),new Node(12),
                new Node(16),new Node(0),new Node(4),new Node(2)};

        Binarytree<Integer> binarytree = new Binarytree<>(new Node<>(10));
        for (Node node : nodes) {
            binarytree.add(node);
        }
        //前序遍历
        System.out.println("输出二叉树:");
        binarytree.preList();
        System.out.println("前序输出所有叶子节点:");
        binarytree.listLeafNode();
        System.out.println("n0="+binarytree.numOfleafNode());
//        System.out.println("交换左右子树");
//        binarytree.changeLeftToRight();
//        binarytree.preList();
        System.out.println("n2="+binarytree.getN2());
//        System.out.println("n0="+binarytree.numOfleafNode());
        int k=10;
        System.out.println("二叉树中大于k="+k+"的节点如下");
        binarytree.listBigThanK(k);
        System.out.println("节点15所在层次为:"+binarytree.getLevel(new Node<>(15)));
        System.out.println("后序遍历后得到的第一个节点为:"+binarytree.getFirstNodeByPostList().toString());

        System.out.println("复制一颗二叉树,先序遍历如下:");
        Binarytree<Integer> copyTree = binarytree.copyTree();
        copyTree.preList();
        System.out.println("该二叉树是否为完全二叉树:"+binarytree.isCompleteBinaryTree());
        System.out.println("后序遍历二叉树(非递归形式):");
        binarytree.postListNoRecursion();
    }

    //已知先根和中根次序遍历序列构造二叉树
    public static Node creatTree(int[] pre, int[] mid, int preL, int preR, int midL, int midR) {
        if (preL > preR || midL > midR) {
            return null;
        }
        int traget = pre[preL];
        int cur=midL;
        for (int i = cur; i < preR; i++) {
            if (mid[i] == traget) {
                cur=i;
                break;
            }
        }
        Node node = new Node(traget);
        //preL+cur-midL是因为cur-midL就是中序数组的左子树部分节点数
        node.left = creatTree(pre, mid, preL + 1, preL + cur - midL, midL, cur - 1);
        node.right = creatTree(pre, mid, preL + cur - midL + 1, preR, cur + 1, midR);
        return node;
    }

}
