package main.tree.avltree;

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
        //当添加完一个节点后,如果(右子树的高度-左子树的高度)>1，左旋转
        if (rightHeight ( ) - leftHeight ( ) > 1) {
            //如果它的右子树的左子树大于它的右子树的右子树的高度
            if (right.leftHeight ( ) > right.rightHeight ( )) {
                //则将它的右子树右旋转
                right.rightRoate ();
            }
            leftRotate ();
            return;//此出return是因为运行了这个方法后该二叉树已经平衡，
                   //没必要运行下面的方法
        }
        //当添加完一个节点后，如果(左子树的高度-右子树的高度)>1,右旋转
        if (leftHeight ( ) - rightHeight ( ) > 1) {
            //如果它的左子树的右子树的长度大于它的右子树的左子树
            if (left.rightHeight ( ) > left.leftHeight ( )) {
                //那么将它的左子树左旋转
                left.leftRotate ();

            }
            rightRoate ();
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

    //编写一个方法,返回以当前节点为根节点的树的高度
    public int height() {
        return Math.max (left == null ? 0 : left.height ( ), right == null ? 0 : right.height ( ))+1;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height ();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height ();
    }

    //左旋转方法
    public void leftRotate() {
        //创建新节点，以当前根节点的值为值
        Node node = new Node (value);
        //把新节点的左子树设置为当前节点的左子树
        node.left = left;
        //把新节点的右子树设置为当前节点的右子树的左子树
        node.right = right.left;
        //把当前节点的值替换成右子树的值
        this.value=right.value;
        //把当前节点的右子树设置成右子树的右子树
        this.right = right.right;
        //把当前节点的左子节点设置成新的节点
        this.left = node;
    }

    //向右旋转的方法
    public void rightRoate() {
        Node newNode = new Node (value);
        newNode.right=right;
        newNode.left=left.right;
        this.value=left.value;
        this.left=left.left;
        this.right=newNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
