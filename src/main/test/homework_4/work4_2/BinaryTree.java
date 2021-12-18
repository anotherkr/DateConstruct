package main.test.homework_4.work4_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanhuanzhan
 * @date 2021/11/13 - 16:15
 */
public class BinaryTree {
    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }
    //添加
    public void add(int no) {
        if (root == null) {
            root = new Node(no,null);
        }else {
            root.add(no);
        }
    }
    //中序遍历
    public void midOrderList() {
        if(root==null){
            return;
        }else {
            root.midOrderList();
        }
    }
    //获取父母节点
    public Node searchParent(int no) {
        if (root != null) {
            if (root.no == no) {
                System.out.println("根节点无父母节点");
                return null;
            }else {
                return root.searchParent(no);
            }
        }else {
            return null;
        }
    }

    //返回node的所有祖先节点
    public List<Node> searchAncestors(int no) {
        if (root == null) {
            return null;
        }else {
            Node node = root.searchNode(no);
            if (node != null) {
                List<Node> nodes = new ArrayList<>();
                while (node.parent != null) {
                    node=node.getParent();
                    nodes.add(node);
                }
                return nodes;
            }else {
                System.out.println("未查找到该节点");
                return null;
            }
        }
    }

    //查询两个节点最近的共同祖先节点
    public Node searchCommon(int no1,int no2) {
        if (root != null) {
            Node node1 = root.searchNode(no1);
            Node node2 = root.searchNode(no2);
            if (node1 == null) {
                System.out.println("节点"+no1+"不存在");
                return null;
            }
            if (node2 == null) {
                System.out.println("节点"+no2+"不存在");
                return null;
            }

            while (node1 != node2) {
                node2 = node2.getParent();
                while (node1 != null) {
                    node1 = node1.getParent();
                    if (node1 == node2) {
                        break;
                    }
                }
            }
            return node1;
        }else {
            System.out.println("二叉树不存在");
            return null;
        }

    }
}
