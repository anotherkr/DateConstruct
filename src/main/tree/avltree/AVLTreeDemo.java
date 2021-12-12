package tree.avltree;

/**AVL树(平衡二叉树)
 * @author yanhuanzhan
 * @date 2021/10/26 - 15:15
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 7, 6, 8, 11, 9};
        AVLTree avlTree = new AVLTree ( );

        //添加节点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add (new Node (arr[i]));
        }
        avlTree.delete(8);
        System.out.println ("遍历" );
        avlTree.midOrder ();

        System.out.println ("树的高度"+avlTree.getRoot ().height () );
        System.out.println ("左子树的高度"+avlTree.getRoot ().leftHeight () );
        System.out.println ("右子树的高度"+avlTree.getRoot ().rightHeight () );

    }
}
