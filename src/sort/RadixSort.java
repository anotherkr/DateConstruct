package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**基数排序--80万数据仅需89毫秒
 * 基数排序是对传统桶排序的扩展，速度很快.
 * 2)基数排序是经典的空间换时间的方式，占用内存很大,当对海量数据排序时，容易造成OutOfMemoryError。
 * 3)基数排序时稳定的。[注:假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，
 * 这些记录的相对次序保持不变，即在原序列中，r[i]=r[j]，且r[i]在r[j]之前，而在排序后的序列中，
 * r[i]仍在r[j]之前，则称这种排序算法是稳定的；否则称为不稳定的]
 * 4)有负数的数组，我们不用基数排序来进行排序
 * @author yanhuanzhan
 * @date 2021/9/18 - 14:51
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random ( ) * 8000000);
        }
        Date date1 = new Date ( );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-mm-dd HH:mm:ss-S");
        String date1Str = simpleDateFormat.format (date1);
        System.out.println ("排序前的时间是" + date1Str);

        //开始排序
        radixSort (arr);
        Date date2 = new Date ( );
        String date2Str = simpleDateFormat.format (date2);
        System.out.println ("排序后的时间是" + date2Str);
//   System.out.println(Arrays.toString(arr));
    }
//    基数排序方法
    public static void radixSort(int[] arr) {
        //1,得到数组中最大数的位数
        int max = arr[0];//假设第一个数是最大数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length ();

        //定义一个二维数组表示10个桶，每个桶就是一个一维数组
        //说明
        //1，二维数组包含10个一维数组
        //2，为了防止放入数的时候，数据溢出，则每个一维数组的大小定为length
        //3，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中实际存放了多少数据，定义一个一维数组记录各个桶每次存放的数据个数
        int[] bucketElementCounts = new int[10];
        for(int i=0,n=1;i<maxLength;i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位,十位，百位。。。
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序依次取出数据，放回原来数组
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才把数据放回原数组
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出数据放回原数组arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第一轮处理后，需要将记录存入每个的有效数据个数的bucketElements[k]重置
                bucketElementCounts[k] = 0;
            }
        }
    }
}
