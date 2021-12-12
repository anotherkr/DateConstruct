package tree.arraybinarytree;

/**顺序存储二叉树
 * @author yanhuanzhan
 * @date 2021/10/5 - 3:29
 */
public class ArrayBinaryTree {
    int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //重载
    public void preOrder(){
        preOrder (0);
    }
//index指arr数组下标
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println ("数组为空" );
            return;
        }
        //输出该下标的元素
        System.out.println (arr[index] );
        //向左递归
        if (index * 2 + 1 < arr.length) {
            preOrder (index*2+1);
        }
        //向右递归
        if (index * 2 + 2 < arr.length) {
            preOrder (index*2+2);
        }
    }
}
