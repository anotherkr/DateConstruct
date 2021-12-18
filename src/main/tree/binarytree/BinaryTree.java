package main.tree.binarytree;

/**
 * @author yanhuanzhan
 * @date 2021/10/3 - 1:59
 */
public class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder ();
        }else {
            System.out.println ("二叉树为空,无法遍历" );
        }
    }
    //中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        }else {
            System.out.println ("二叉树为空,无法遍历" );
        }
    }
    //前序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder ();
        }else {
            System.out.println ("二叉树为空,无法遍历" );
        }
    }
    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (root != null) {
            return root.preOrderSearch (no);
        }else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode midOrderSearch(int no) {
        if (root != null) {
            return root.midOrderSearch (no);
        }else {
            return null;
        }
    }

    //后序遍历查
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch (no);
        }else {
            return null;
        }
    }

    //删除节点
    public void delNode(int no) {
        if (this.root != null) {
            if(root.getNo ()==no){
                root = null;
            }else {
                root.delNode (no);
            }

        }else {
            System.out.println ("空树,不能删除" );
        }
    }
}
