package tree.arraybinarytree;

/**
 * @author yanhuanzhan
 * @date 2021/10/5 - 3:42
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();//1245367
    }
}
