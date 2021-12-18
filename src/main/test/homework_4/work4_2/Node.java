package main.test.homework_4.work4_2;

/**
 * @author yanhuanzhan
 * @date 2021/11/13 - 16:15
 */
public class Node {
    int no;
    Node left;
    Node right;
    Node parent;

    //查找节点
    public Node searchNode(int no) {
        if (this.no > no) {
            return this.left.searchNode(no);
        } else if (this.no < no) {
            return this.right.searchNode(no);
        }else {
            return this;
        }
    }
    //获取父母节点
    public Node searchParent(int no) {
        if ((this.left!=null&&this.left.no == no)||(this.right!=null&&this.right.no==no)) {
            return this;
        }else {
            if (this.no > no&&this.left!=null) {
                    return this.left.searchParent(no);
            }else if (this.no<no&&this.right != null) {
                    return this.right.searchParent(no);
            }else {
                return null;
            }

        }
    }
    //中序遍历
    public void midOrderList() {
        if (this.left != null) {
            this.left.midOrderList();
        }
        System.out.println(this.toString());
        if (this.right != null) {
            this.right.midOrderList();
        }
    }
   //添加
    public void add(int no) {
        if (this.no > no) {
            if (this.left != null) {
                this.left.add(no);
            }else {
                this.left = new Node(no,this);
            }
        }else {
            if (this.right != null) {
                this.right.add(no);
            }else {
                this.right = new Node(no,this);
            }
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node(int no) {
        this.no = no;
    }

    public Node(int no, Node parent) {
        this.no = no;
        this.parent = parent;
    }

    public Node() {
    }
}
