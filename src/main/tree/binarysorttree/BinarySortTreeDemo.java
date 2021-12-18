package main.tree.binarysorttree;

/**
 * @author yanhuanzhan
 * @date 2021/10/25 - 15:22
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,2};
        BinarySortTree tree = new BinarySortTree ( );
        for (int i = 0; i < arr.length; i++) {
            tree.add (new Node (arr[i]));
        }
        tree.delete (7);
        tree.midOrder ();
    }




}
