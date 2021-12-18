package main.tree.binarysorttree;

/** 节点类
 * @author yanhuanzhan
 * @date 2021/10/25 - 15:08
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //查找要删除的节点

    /**
     *
     * @param value 希望删除的节点的值
     * @return 如果找到返回该节点,否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        }else if (value<this.value){
            //如果左子节点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search (value);
        }else {
            if (this.right == null) {
                return null;
            }
            return this.right.search (value);
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else  {
            if (value < this.value && this.left != null) {
                return this.left.searchParent (value);
            }else if(value>=this.value&&this.right!=null){
                return this.right.searchParent (value);
            }else {//没有找到父节点(左右节点都为空)
                return null;
            }
        }
    }
    //添加节点的方法
    //递归的方式添加节点,注意需要满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left=node;
            }else {
                this.left.add (node);
            }
        }else{
            if (this.right == null) {
                this.right=node;
            }else {
                this.right.add (node);
            }
        }

    }

    //中序遍历
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder ();
        }
        System.out.println (this );
        if (this.right != null) {
            this.right.midOrder ();
        }
    }
}
