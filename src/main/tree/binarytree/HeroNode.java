package tree.binarytree;

/**
 * 节点类
 *
 * @author yanhuanzhan
 * @date 2021/10/3 - 2:00
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //编写前序遍历
    public void preOrder() {
        System.out.println (this);//从根节点开始
        if (left != null) {
            this.left.preOrder ( );
        }
        if (right != null) {
            this.right.preOrder ( );
        }
    }

    //编写中序遍历
    public void midOrder() {
        //先移动到最左边的节点
        if (left != null) {
            this.left.midOrder ( );
        }
        System.out.println (this);
        if (right != null) {
            this.right.midOrder ( );
        }
    }

    //编写后序遍历
    public void postOrder() {
        if (left != null) {
            this.left.postOrder ( );
        }
        if (right != null) {
            this.right.postOrder ( );
        }
        System.out.println (this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        //比较当前节点
        if (this.no == no) {
            return this;
        }
        HeroNode heroNode = null;
        //如果不等于，则判断当前节点的左节点是否为空，如果不为空，则递归前序查找
        if (this.left != null) {
            heroNode = this.left.preOrderSearch (no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch (no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        return heroNode;
    }

    //中序遍历查找
    public HeroNode midOrderSearch(int no) {
        //比较当前节点

        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.midOrderSearch (no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            heroNode = this.right.midOrderSearch (no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        return heroNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {

        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.postOrderSearch (no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.postOrderSearch (no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        //比较当前节点
        if (this.no == no) {
            return this;
        }
        return heroNode;
    }

    //递归删除节点
    //1，如果删除的是叶子节点，则删除该节点
    //2，如果删除的是非叶子节点则删除该删除该子树
    public void delNode(int no) {
        //思路:
        //1，因为我们的二叉树是单向的，所以我们是判断当前节点的子节点是否需要删除节点，
        // 而不能判断当前这个节点是不是需要被删除的节点
        //2，如果该节点的左右节点都不是所找的节点，那么就先向左递归后向右递归
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode (no);
        }
        //向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode (no);
        }
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}
