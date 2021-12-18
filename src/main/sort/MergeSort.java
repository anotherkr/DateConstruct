package main.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**归并排序--80万数据仅需151毫秒
 * @author yanhuanzhan
 * @date 2021/9/17 - 17:56
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random ( ) * 8000000);
        }
        Date date1 = new Date ( );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-mm-dd HH:mm:ss-S");
        String date1Str = simpleDateFormat.format (date1);
        System.out.println ("排序前的时间是" + date1Str);
        //准备一个临时数组
        int[] temp = new int[arr.length];
        //开始排序
        mergeSort (arr, 0, arr.length - 1, temp);
        Date date2 = new Date ( );
        String date2Str = simpleDateFormat.format (date2);
        System.out.println ("排序后的时间是" + date2Str);
//   System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
         int  mid = (left+right)/2;
            //从左边开始递归
            mergeSort (arr,left,mid,temp);
            //从右边开始递归
            mergeSort (arr,mid+1,right,temp);//注意mid+1才是右边有序序列的第一个索引
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 分开的方法
     * @param arr
     * @param left
     * @param mid 中间下标，即左边有序序列的最后一个数据
     * @param right
     * @param temp
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int i = left;
        int j = mid+1;//从右边有序序列开始的索引
        int t = 0;//作为临时数组temp的索引
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                 temp[t] = arr[i];
                 i++;
                 t++;
            }else{
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //如果左边有序序列有剩余数据没进temp数组
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        //如果右边有序序列有剩余数据没进temp数组
        while (j <= right ){
            temp[t] = arr[j];
            j++;
            t++;
        }
        //将temp数组填充进原本的arr数组
        t = 0;//初始化索引
        int tempLeft = left;//临时索引
        while(tempLeft<=right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }


}
