package main.test.homework_4.work4_1;

public class Binarytree<E> {
Node<E> root;

    public Binarytree(Node<E> root) {
        this.root = root;
    }

    //添加节点
    public void add(Node<E> newNode) {
        if (root != null) {
            root.add(newNode);
        }else {
            System.out.println("根节点为空");
        }
    }

    //后序遍历
    public void postList() {
        if (root != null) {
            root.postList();
        }else {
            System.out.println("根节点为空");
        }
    }
    //前序遍历
    public void preList() {
        if (root != null) {
            root.preList();
        }else {
            System.out.println("根节点为空");
        }
    }
    //编辑一个方法输出叶子节点
    public void listLeafNode() {
        if(root!=null){
            root.listLeafNode();
        }else {
            System.out.println("根节点为空");
        }
    }

    //编写一个方法返回二叉树叶子节点个数
    public int numOfleafNode() {
        if (root != null) {
            return root.numOfLeafNode();
        }else {
            return 0;
        }
    }
    //编写一个方法将节点的左子树与右子树交换
    public void changeLeftToRight() {
        if (root != null) {
            root.changeLeftToRight();
        }else {
            System.out.println("根节点为空");
        }
    }

    //编写一个方法求n2
    public int getN2() {
        if (root != null) {
            return root.getN2();
        }else {
            return 0;
        }
    }//编写一个方法输出值大于k的节点
    public void listBigThanK(int k) {
        if (root != null) {
            root.listBigThanK(k);
        }else {
            System.out.println("根节点为空");
        }

    }

    //编写一个方法判断两个二叉树是否相等
    public boolean equals(Node node){
        if (this.root == null && node == null) {
            return true;
        } else if (this.root == null || node == null) {
            return false;
        }else {
            return root.equals(node);
        }
    }

    //求节点所在层次
    public int getLevel(Node<E> node) {
        if (root != null) {
            return root.getLevel(node);
        }else {
            System.out.println("根节点为空");
            return -1;
        }
    }

    //求二叉树在后序遍历下第一个访问的结点。
    public Node<E> getFirstNodeByPostList() {
        if (root != null) {
            return root.getFirstNodeByPostList();
        } else {
            System.out.println("根节点为空");
            return null;
        }
    }
    //复制一颗二叉树
    public Binarytree<E> copyTree(){
        if (root != null) {
            return new Binarytree<>(root.copyTree());
        }else {
            System.out.println("根节点为空");
            return null;
        }
    }
    //判断一颗二叉树是否为完全二叉树
    public boolean isCompleteBinaryTree(){
        if (root != null) {
          return root.isCompleteBinaryTree();
        }else {
            System.out.println("根节点为空");
            return false;
        }
    }
    //实现的后序遍历的非递归形式(用两个栈实现)
    public void postListNoRecursion(){
        if (root != null) {
            root.postListNoRecursion();
        }else {
            System.out.println("根节点为空");
        }
    }
}
