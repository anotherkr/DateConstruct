package search;

import java.util.Arrays;

/**
 * 插值查找算法
 * 也要求数组是有序的
 * 对于数据量较大,关键字发布较均匀的查找表来说，采用插值查找速度较快
 * 关键字发布不均匀的情况下，该方法不一定比折半查找要好
 *
 * @author yanhuanzhan
 * @date 2021/9/19 - 18:19
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println (Arrays.toString (arr));
        int res = insertValueSearch (arr, 0, arr.length - 1, 1);
        System.out.println (res);
    }


    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        //findVal<arr[0] || findVal > arr[arr.length-1]必须要写，不然数据量大时mid很可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        //重点
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (findVal < arr[mid]) {
            return insertValueSearch (arr, left, mid - 1, findVal);
        } else if (findVal > arr[mid]) {
            return insertValueSearch (arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }


}
