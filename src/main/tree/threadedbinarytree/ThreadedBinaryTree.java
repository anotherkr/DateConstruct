package main.tree.threadedbinarytree;


import java.util.Stack;

/**
 * 线索化二叉树
 *
 * @author yanhuanzhan
 * @date 2021/10/8 - 15:48
 */
public class ThreadedBinaryTree {
    private HeroNode root;
    //为了实现线索化，需要创建指向当前节点的前驱节点的指针
    //递归进行线索化时，pre总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //遍历中序线索化二叉树的方法
    public void threadedMidList() {
        //定义一个变量来存储当前的节点
        HeroNode node = root;
        while (node != null) {
            //先找到leftType == 1的节点且左子节点为空的节点,即中序遍历的第一个节点
            while (node.getLeft ()!=null&&node.getLeftType ( ) == 0) {
                node = node.getLeft ( );
            }
            //打印当前节点
            System.out.println (node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType ( ) == 1) {
                //获取当前节点的后继节点
                node = node.getRight ( );
                System.out.println (node);
            }
            node = node.getRight ( );
        }
    }

    //前序遍历线索化二叉树的方法
    public void threadedProList() {
        //定义一个变量来存储当前节点
        HeroNode node = root;
        System.out.println (node );//先输出当前节点
        while (node != null) {
            //判断当前节点的左节点是否为前驱节点，如果不是且不为空则输出其左节点
            while (node.getLeft ()!=null&&node.getLeftType ( ) == 0) {
                System.out.println (node.getLeft () );
                node = node.getLeft ();
                continue;
            }
            //判断当前节点的右节点是否为后继节点，如果不是且不为空则输出其右节点
            while (node.getRight ()!=null&&node.getRightType ( ) == 0) {
                System.out.println (node.getRight () );
                node = node.getRight ();
                continue;
            }
            //判断当前节点的右节点是否为后继节点，如果是则直接输出后继节点
            while (node.getRightType ( ) == 1) {
                System.out.println (node.getRight () );
                node = node.getRight ();
            }
            //作为最后的退出条件，除了最后一个节点以外，node.getRight()都不会为空
            if (node.getRight ( ) == null) {
                break;
            }
        }
    }
//重载
    public void threadedPostList2(){
        threadedPostList2 (root);
    }
    //遍历后序线索化二叉树(递归方式)
    public void threadedPostList2(HeroNode node) {
        if (node.getLeft ()!=null&&node.getLeftType ( ) == 0) {
            threadedPostList2 (node.getLeft ());
        }
        if (node.getRight ()!=null&&node.getRightType ( ) == 0) {
            threadedPostList2 (node.getRight ());
        }
        System.out.println (node );
    }
    //遍历后序线索化二叉树
    //由于后序遍历不使用递归难以回到子节点的父节点，因此采用栈输出的方式
    //即以中右左的顺序压入栈，再从栈输出的方式遍历
    public void threadedPostList() {
        HeroNode node = root;
        Stack<HeroNode> stack = new Stack<> ( );
        stack.push (node);//先把根节点压入
        while (node != null) {
            while (node.getRight ()!=null&&node.getRightType ( ) == 0) {
                stack.push (node.getRight ());
                node = node.getRight ( );
                continue;
            }
            while (node.getLeft ()!=null&&node.getLeftType ( ) == 0) {
                stack.push (node.getLeft ( ));
                node = node.getLeft ();
                continue;
            }
            //node!=null极其关键，不然会导致最后一个元素的左节点（null）使用getLeftType时出现空指针
            while (node!=null&&node.getLeftType ()== 1) {
                  stack.push (node.getLeft ());
                  node = node.getLeft ();
            }
        }
        while (!stack.isEmpty ()) {
            System.out.println (stack.pop ().toString() );
        }
    }
    //重载
    public void threadedMidNode() {
        threadedMidNode (root);
    }

    //编写对二叉树进行中序线索化的方法
    public void threadedMidNode(HeroNode heroNode) {

        if (heroNode == null) {
            return;
        }
        //先线索化左子树
        if (heroNode.getLeftType ( ) == 0) {
            threadedMidNode (heroNode.getLeft ( ));
        }

        //线索化当前节点(有难度)
        //1,处理当前节点的前驱节点
        if (heroNode.getLeft ( ) == null) {
            //让当前节点的左指针指向前驱节点
            heroNode.setLeft (pre);
            //修改当前节点的左指针类型
            heroNode.setLeftType (1);
        }
        //2，处理后继节点
        if (pre != null && pre.getRight ( ) == null) {
            //让前驱节点的右值针值向当前节点
            pre.setRight (heroNode);
            //修改前驱节点的右指针类型
            pre.setRightType (1);
        }
        //每处理完一个节点后，让前驱节点成为下一个节点的前驱节点
        pre = heroNode;
        //线索化右子树
        if (heroNode.getRightType ( ) == 0) {
            threadedMidNode (heroNode.getRight ( ));
        }
    }

    //重载
    public void threadedPreNode() {
        threadedPreNode (root);
    }

    //编写前序线索化二叉树的方法
    public void threadedPreNode(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeft ( ) == null) {
            node.setLeft (pre);
            node.setLeftType (1);
        }
        if (pre != null && pre.getRight ( ) == null) {
            pre.setRight (node);
            pre.setRightType (1);
        }
        pre = node;
        if (node.getLeftType ( ) == 0) {//鉴定该节点是否线索化，防止死循环
            threadedPreNode (node.getLeft ( ));
        }
        if (node.getRightType ( ) == 0) {//鉴定该节点是否线索化，防止死循环
            threadedPreNode (node.getRight ( ));
        }
    }

    //重载
    public void threadedPostNode() {
        threadedPostNode (root);
    }

    //编写后序线索化二叉树的方法
    public void threadedPostNode(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeftType ( ) == 0) {
            threadedPostNode (node.getLeft ( ));
        }
        if (node.getRightType ( ) == 0) {
            threadedPostNode (node.getRight ( ));
        }
        if (node.getLeft ( ) == null) {
            node.setLeft (pre);
            node.setLeftType (1);
        }
        if (pre != null && pre.getRight ( ) == null) {
            pre.setRight (node);
            pre.setRightType (1);
        }
        pre = node;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder ( );
        } else {
            System.out.println ("二叉树为空,无法遍历");
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder ( );
        } else {
            System.out.println ("二叉树为空,无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder ( );
        } else {
            System.out.println ("二叉树为空,无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch (no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode midOrderSearch(int no) {
        if (root != null) {
            return root.midOrderSearch (no);
        } else {
            return null;
        }
    }

    //后序遍历查
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch (no);
        } else {
            return null;
        }
    }

    //删除节点
    public void delNode(int no) {
        if (this.root != null) {
            if (root.getNo ( ) == no) {
                root = null;
            } else {
                root.delNode (no);
            }

        } else {
            System.out.println ("空树,不能删除");
        }
    }
}
