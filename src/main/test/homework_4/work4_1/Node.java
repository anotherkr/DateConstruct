package test.homework_4.work4_1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node<E> {
    E e;
    Node<E> left;
    Node<E> right;
    static int leaf=0;//以该节点为根节点的二叉树的叶子节点个数,这里要为静态，否则递归时无法改变它的值
    static int n2;//两条腿的节点的个数,这里要为静态，否则递归时无法改变它的值
    static int level=0;//节点所在层次
    static boolean isFind=false;//标记节点是否找到
    //添加节点
    public void add(Node<E> newNode) {
        if ((Integer)this.e > (Integer) newNode.e) {
            if (this.left == null) {
                this.left=newNode;
                return;
            }else {
                this.left.add(newNode);
            }
        }else {
            if(this.right==null){
                this.right = newNode;
                return;
            }else {
                this.right.add(newNode);
            }
        }
    }

    //前序遍历
    public void preList() {
        System.out.println(this.toString());
        if (this.left != null) {
            this.left.preList();
        }
        if (this.right != null) {
            this.right.preList();
        }

    }
    //后序遍历
    public void postList() {

        if (this.left != null) {
            this.left.postList();
        }
        if (this.right != null) {
            this.right.postList();
        }
        System.out.println(this.toString());
    }
    //编写一个方法输出叶子节点
    public void listLeafNode() {
        if (this.left == null && this.right == null) {
            System.out.println(this.toString());
        }
        if (this.left != null) {
            this.left.listLeafNode();
        }
        if (this.right != null) {
            this.right.listLeafNode();
        }

    }

    //编写一个方法返回二叉树叶子节点个数
    public int numOfLeafNode() {
        if (this.left == null && this.right==null) {
           leaf++;
        }
        if (this.left != null) {
            this.left.numOfLeafNode();
        }
        if (this.right != null) {
            this.right.numOfLeafNode();
        }
        return leaf;
    }

    //编写一个方法将以该节点为根节点的二叉树的节点的左子树与右子树交换
    public void changeLeftToRight() {
        Node node=this.left;//保存左子树
        this.left=this.right;
        this.right=node;

        if (this.left != null) {
            this.left.changeLeftToRight();
        }
        if (this.right != null) {
            this.right.changeLeftToRight();
        }

    }
    //编写一个方法求n2
    public int getN2() {
        if (this.left != null && this.right != null) {
            n2++;
        }
        if (left != null) {
            left.getN2();
        }
        if (right != null) {
            right.getN2();
        }
        return n2;
    }

    //编写一个方法输出值大于k的节点
    public void listBigThanK(int k) {
        if ((Integer) e > k) {
            System.out.println(this.toString());
        }
        if (this.left != null) {
            left.listBigThanK(k);
        }
        if (this.right != null) {
            right.listBigThanK(k);
        }

    }

    //编写一个方法判断两个二叉树是否相等
    public boolean equals(Node node) {
        if (this == null && node == null) {
            return true;
        } else if (this == null || node == null) {
            return false;
        } else if (!this.e.equals(node.e)) {
            return false;
        }else {
            return left.equals(node.left) && right.equals(node.right);
        }
    }

    //求节点所在的层次
    public int getLevel(Node<E> node) {
        if (node.e.equals(this.e)) {
            isFind=true;
            return ++level;
        }
        if ((Integer) node.e < (Integer) this.e) {
            if (this.left != null) {
                level = left.getLevel(node)+1;
            }
        }else {
            if (this.right != null) {
                level = right.getLevel(node)+1;
            }
        }
        if (isFind) {
            return level;
        }else {
            return -1;
        }
    }

    //求二叉树在后序遍历下第一个访问的结点。
    public Node<E> getFirstNodeByPostList() {
        if (left != null) {
            return left.getFirstNodeByPostList();
        }
        if (right != null) {
            return right.getFirstNodeByPostList();
        }
        return this;
    }
    //复制一颗二叉树
    public Node<E> copyTree() {
        Node<E> node = new Node<>(this.e);
        if (left != null) {
            node.left=left.copyTree();
        }
        if (right != null) {
            node.right=right.copyTree();
        }
        return node;
    }

    //判断一颗二叉树是否为完全二叉树
    public boolean isCompleteBinaryTree() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(this);
        boolean isLeaf=false;//判断是否开启叶子节点
        //先判断根节点然后判断根节点的左子节点再判断根节点的右子节点，以此类推
        while (!queue.isEmpty()) {
            //从队头取出节点
            Node<E> node=queue.poll();
            //如果节点有右子树而没有左子树,则返回false
            if (node.left == null && node.right != null) {
                return false;
            }
            //如果节点的左右节点空或只有一个左节点,则开启叶子节点的判断
            if (node.left == null || node.left != null && node.right == null) {
                isLeaf=true;
            }
            //叶子节点判定,如果isLeaf=true,且其左节点不为空或右节点不为空，则返回false
            if (isLeaf && (node.left != null || node.right != null)) {
                return false;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return true;
    }

    //实现的后序遍历的非递归形式(用两个栈实现)
    public void postListNoRecursion() {
        Stack<Node> stack = new Stack<>();//过程栈
        Stack<Node> res = new Stack<>();//结果栈
        stack.push(this);
        while (!stack.isEmpty()) {
            Node<E> node = stack.pop();
            res.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        //开始遍历
        while (!res.isEmpty()) {
            System.out.println(res.pop().toString());
        }
    }
    public Node(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "e=" + e +
                '}';
    }
}
