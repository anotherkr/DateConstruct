package main.algorithm.binarysearch;

/** 二分查找(非递归)
 * @author yanhuanzhan
 * @date 2021/11/1 - 20:33
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 87};
        int index=binarySearch (arr, -2);
        System.out.println ("index="+index );
    }

    private static int binarySearch(int[] arr, int target) {
        int left=0;
        int right = arr.length;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right=mid-1;//需要向左边查找
            }else {
                left=mid+1;//需要向右边查找
            }
        }
        return -1;
    }
}
