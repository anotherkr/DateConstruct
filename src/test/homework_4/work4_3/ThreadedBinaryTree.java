package test.homework_4.work4_3;

import java.util.Stack;

/** 线索化二叉树
 * @author yanhuanzhan
 * @date 2021/11/7 - 18:28
 */
public class ThreadedBinaryTree {
Node root;
//线索化二叉树需要前驱节点
    Node pre=null;//用来记录该节点的前驱节点

    //按后根次序遍历中序线索二叉树
    public void postOrderList() {
        if (root == null) {
            return;
        }
        Node node=root;
        //利用栈的方式，以中右左的顺序将节点压入栈
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (node != null) {
            while (node.rightType == 0 && node.right != null) {
                node=node.right;
                stack.push(node);
            }
            while (node.left != null&&node.leftType==0) {
                node=node.left;

                stack.push(node);
            }
            while (node != null && node.leftType == 1) {//无路向下便往回走
                node=node.left;
            }
            if (node!=null&&node.left!=null&&node.leftType==0){//该节点右边已经探索完，往左走一步，不然重新循环又会往右走
                node=node.left;

                stack.push(node);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toString());
        }
    }
    //中序遍历线索化二叉树
    public void threadedMidList() {
        //指针
        Node node=root;
        while (node != null) {
            //找到第一个节点
            while (node.getLeft() != null && node.getLeftType() == 0) {
                node=node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }
    }


    //重载
    public void threadedMidNode() {
        threadedMidNode(root);
        pre=null;//关键点，不重置pre会导致上次调用线索化方法后pre会指向最后一个节点，导致再次调用形成死循环
    }
    //中序线索化二叉树
    public void threadedMidNode(Node node) {
        if (node == null) {
            return;
        }
        //先线索化左子树
        if (node.leftType == 0) {
            threadedMidNode(node.getLeft());
        }
        //线索化当前节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;//记录前驱节点
        //线索化右子树
        if (node.getRightType() == 0) {
            threadedMidNode(node.getRight());
        }

    }
    //构造二叉树时线索化二叉树
    public ThreadedBinaryTree(Node root) {
        this.root = root;
        threadedMidNode();//线索化
    }

    //插入
    public void insert(int i) {
        if (root==null) {
            root = new Node(i);
            return;
        }else {
            relieve(root);//解除线索化
           root.insert(i);
           threadedMidNode();//线索化

        }
    }

    public void delete(int no) {
        relieve(root);//解除线索化
        if (root != null) {
            Node node = root.search(no);//要删除的节点
            if (node == null) {//要删除的节点不存在
                return;
            }
            if (root.right == null && root.left == null) {//如果只有一个节点
                root=null;
                return;
            }
            Node parentNode = root.searchParent(no);
            if (parentNode == null&&root.left!=null) {//如果父节点为null说明为根节点
                 root.setNo(this.getMax(root.left));//将根节点的左子树中的最大值设置为根节点的值，并删除拥有该最大值的叶子节点
                 return;
            }
            if (parentNode == null && root.right != null) {//如果父节点为null说明为根节点
                root.setNo(this.getMin(root.right));//将根节点的右子树中的最小值设置为根节点的值，并删除拥有该最小值的叶子节点
                return;
            }
            //当要删除的节点为叶子节点时
            if (node.left==null && node.right== null ) {
                if (parentNode.left.no == node.no) {
                    parentNode.left=null;

                }else {
                    parentNode.right=null;
                }
                threadedMidNode();//线索化
            } else if (node.left!=null&&node.right!=null) {//当要删除的节点拥有两个子节点时
                 node.setNo(this.getMax(node.left));//从该节点的左子树找到最大值替换到该节点，并删除

            }else {//当要删除的节点只有一个子节点时
                if (node.left != null) {//当要删除节点的左节点不为空时
                    if (parentNode.left.no == node.no) {
                        parentNode.left=node.left;
                    }else {
                        parentNode.right=node.left;
                    }
                }else {//当要删除节点的右节点不为空时
                    if (parentNode.left.no == node.no) {
                        parentNode.left=node.right;
                    }else {
                        parentNode.right=node.right;
                    }
                }
                threadedMidNode();//线索化
            }
        }else {
            return;
        }
    }

    //解除线索化
    public void relieve(Node node) {
        if (node.left!=null&&node.leftType==0) {
            relieve(node.left);
        }
        if (node.leftType == 1) {
            node.left=null;
            node.leftType=0;
        }
        if (node.rightType == 1) {
            node.right=null;
            node.rightType=0;
        }
        if (node.right != null && node.rightType == 0) {
            relieve(node.right);
        }
    }
     //得到以node为根节点的子树中节点的最大值
    public int getMax(Node node) {
        Node cur=node;
        while (cur.right != null&&cur.rightType==0) {
            cur=cur.right;
        }
        delete(cur.no);
        return cur.no;
    }

    //得到以node为根节点的子树中节点的最小值
    public int getMin(Node node) {
        Node cur=node;
        while (cur.leftType == 0) {
            cur=cur.left;
        }
        delete(cur.no);
        return cur.no;
    }
}
