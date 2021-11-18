package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**二分法查找(递归方式)
 * @author yanhuanzhan
 * @date 2021/9/19 - 6:36
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {12,222,333,333,333,333,44444,56671,13011111};
       List<Integer> resIndexList =binarySearch (arr,0,arr.length-1,333);
        Collections.sort (resIndexList);//给结果排序
        System.out.println (resIndexList );
    }
    public static List<Integer> binarySearch(int[] arr, int left, int right, int value) {
        if(left>right){
            return new ArrayList<Integer> ();
        }
        int mid = (right+left)/2;
        if (value > arr[mid]) {
           return binarySearch (arr,mid+1,right,value);//注意mid要加1与中间值错开
        } else if (value < arr[mid]) {
           return binarySearch (arr,left,mid-1,value);//注意mid要减1与中间值错开
        }else {
            //若value出现重复，在找到mid索引值时不要马上返回
            //分别向mid左右两边扫描，找到与value值相等的对应下标，并加入到集合中一起返回
            List<Integer> resIndexList = new ArrayList<Integer> ();
            resIndexList.add (mid);
            int temp = mid -1 ;
            while (true){
                if (temp < 0 || arr[temp] != value) {
                    break;
                }
                resIndexList.add (temp);
                temp--;
            }

             temp = mid +1;
            while (true) {
                if (temp > arr.length || arr[temp] != value) {
                    break;
                }
                resIndexList.add (temp);
                temp++;
            }
            return resIndexList;
        }

    }
}
