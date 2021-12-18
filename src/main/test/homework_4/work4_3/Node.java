package main.test.homework_4.work4_3;

/**
 * @author yanhuanzhan
 * @date 2021/11/7 - 18:34
 */
public class Node {
    int no;
    String name;
    Node left;
    Node right;
    //1，如果leftType==0表示的是左子树，如果是1则表示指向前驱节点
    //2，如果rightType==0表示指向的是右子树，如果是1则表示的是后继节点
    int rightType;
    int leftType;
//插入
    public void insert(int i) {
        Node newNode = new Node(i);
        if (newNode.no < this.no) {
            if (this.left!=null) {
                this.left.insert(i);
            }else {
                this.left=newNode;
            }
        } else  {
            if (this.right!=null) {
                this.right.insert(i);
            }else {
                this.right=newNode;
            }
        }
    }
    //查找节点
    public Node search(int no) {

        if (this.no > no) {
            return this.left.search(no);
        }else if (this.no<no){
            return this.right.search(no);
        }else {
            return this;
        }
    }
    //查找父节点
    public Node searchParent(int no) {
        if ((this.left != null && this.left.no == no) || (this.right != null) && this.right.no == no) {
            return this;
        }else {
            if (no < this.no&&this.left!=null) {
                return this.left.searchParent(no);
            } else if (no > this.no && this.right != null) {
                return this.right.searchParent(no);
            }else {//找不到
                return null;
            }
        }
    }
    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
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

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    public Node(int no, String name) {
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

    public Node(int no) {
        this.no = no;
    }
}
