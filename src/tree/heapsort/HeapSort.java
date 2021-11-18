package tree.heapsort;

import java.util.ArrayList;
import java.util.Arrays;

/**堆排序(时间复杂度O(nlogn))
 * 升序排序用大顶堆，降序排序用小顶堆
 * @author yanhuanzhan
 * @date 2021/10/9 - 16:22
 */
public class HeapSort {
    public static void main(String[] args) {
        //要求升序排列
        int arr[] = {4, 6, 8, 5, 9,-1,111,222};
        heapSort (arr);
    }

    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        System.out.println ("堆排序!!");
        //将无序序列构成一个堆
        for (int i = arr.length / 2 -1; i >= 0;i--) {//arr.length / 2 -1可取到该二叉树最低端的非叶子节点
            adjustHeap (arr,i,arr.length);//从下往上不断排，直到成为大顶堆
        }
        //将堆顶元素与末尾元素交换，将最大元素沉到数组末端
        for (int j = arr.length - 1; j > 0; j--) {//注意j是>0而不是>=
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap (arr,0,j);//重新调整成大顶堆，堆顶为除了已经沉没的元素以外的最大值
        }
        System.out.println ("数组:"+ Arrays.toString (arr ));
    }

    //将数组(二叉树),调整成一个大顶堆

    /**
     * @param arr    待调整数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length是在逐渐的减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //k=i*2+1是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//说明左子节点小于右子节点的值
                k++;//k指向右子节点
            }
            if (arr[k] > temp) {//如果左子节点大于父节点
                arr[i] = arr[k];//把较大的值赋给当前节点
                i = k;//i移向子节点
            } else {
                break;//直接返回，因为后面的节点必定小于arr[k]
            }
        }//for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶上
        arr[i] = temp;//把父节点的初始值放在i的最终位置
    }

}