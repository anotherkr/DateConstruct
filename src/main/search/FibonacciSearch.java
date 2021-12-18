package main.search;

import java.util.Arrays;

/**斐波那契查找算法
 * @author yanhuanzhan
 * @date 2021/9/19 - 20:28
 */
public class FibonacciSearch {
    public  static int maxSize = 20;
    public static void main(String[] args) {

    }

    //因为后面我们mid = low + F(k-1)-1,需要使用到斐波那契数列，因此我们需要先获得一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize++; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    /**
     * 使用非递归的方式编写
     * @param arr
     * @param key 需要查找的值
     * @return
     */
    public static int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        int k = 0;//表示斐波那契分割数值对应的下标
        int mid = 0;//存放mid值
        int f[] = fib ();//获取斐波那契数列
        //获取斐波那契分割数值下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]可能大于arr的长度,因此需要使用Arrays类，构造一个新的数组，并指向a[]
        int[] temp = Arrays.copyOf (arr, f [k]);//不足的部分会使用0填充
        //实际上需要使用arr数组最后的数填充temp，以保证arr有序
        for (int i = high+1; i < temp.length; i++) {
               temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k-1]-1;
            if (key < temp[mid]) {//我们应该向数组的前面查找
                high = mid -1;
                //为什么是k--？
                //说明
                //1，全部元素 = 前面的元素 + 后面元素
                //2，f[k] = f[k-1] + f[k-2]
                //前面有f[k-1]个元素，继续拆分成f[k-1] = f[k-2]+f[k-3]
                //即k--
                k--;
            } else if (key > temp[mid]) {
                low = mid +1;
                //为什么是k-2？
                //说明
                //1，全部元素 = 前面的元素 + 后面元素
                //2，f[k] = f[k-1] + f[k-2]
                //因为后面部分是k-2
                k -=2;
            }else{//找到
                if (mid <= high) {
                    return mid;
                }else{
                    return  high;
                }
            }
        }
        return -1;
    }
}
