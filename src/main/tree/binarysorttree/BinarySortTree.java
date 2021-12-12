package tree.binarysorttree;

/** 二叉排序树
 * @author yanhuanzhan
 * @date 2021/10/25 - 15:08
 */
public class BinarySortTree {
    private Node root;

    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        }else {
            return root.search (value );
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }else {
            return root.searchParent (value);
        }
    }

    //删除节点
    public void delete(int value) {
        if (root == null) {
            return;
        }else {
            //先找到要删除的节点
            Node targetNode = search (value);
            //如果没有找到要删除的节点
            if (targetNode == null) {
                return;
            }
            //如果二叉树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //得到targetNode的父节点
            Node parent = searchParent (value);
            //如果父节点为空
            if (parent == null && targetNode.left != null) {
                root=targetNode.left;
                return;
            }
            if (parent == null && targetNode.right != null) {
                root=targetNode.right;
                return;
            }
            //第一种情况:如果要删除的节点是叶子节点
            if(targetNode.left== null&&targetNode.right==null){
                //要删除该节点,不是让targetNode==null,而是让它的父节点的left或right==null
                if (parent.left != null && parent.left.value == value) {
                    parent.left=null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right=null;
                }
                //第二种情况:如果要删除的节点有两颗子树
            } else if (targetNode.left != null && targetNode.right != null) {
                //可以从左子树找最大的，也可以从右子树找最小的
                int minVal = delRightTreeMin (targetNode.right);
                targetNode.value=minVal;
            } else {//第三种情况:如果要删除的节点只有一颗子树
                //如果要删除的节点有左子树
                if (targetNode.left != null) {
                    //如果targetNode是parent的左子节点
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;//找target左子树最大的节点代替target
                    } else {//target是parent的右子节点
                        if (parent.left.value == value) {
                            parent.right = targetNode.left;
                        }
                    }

                } else {//如果要删除的节点有右子树
                    //如果targetNode是parent的左子节点
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else {//如果targetNode是parent的右子节点
                        parent.right = targetNode.right;
                    }
                }
            }

        }
    }

    //编写一个将node视为根节点查找该子树value的最小值并返回(用于delete方法中,删除的节点有两个子树时的情况)
    //然后删除最小值的所在节点(替换掉要删除的节点)
    /**
     *
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target=target.left;
        }
        //这时target指向最小节点
        //删除
        delete (target.value);
        return target.value;
    }
//有序添加节点
    public void add(Node node) {
        if (root == null) {
            root = node;//如果root为空,直接让root指向node
        }else {
            root.add (node);
        }
    }

    //中序遍历
    public void midOrder() {
        if (root != null) {
            root.midOrder ( );
        } else {
            System.out.println ("二叉排序树为空,不能遍历" );
        }
    }

}
