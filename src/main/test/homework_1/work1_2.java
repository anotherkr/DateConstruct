package main.test.homework_1;

import java.util.Arrays;

/** 数组逆置
 * @author yanhuanzhan
 * @date 2021/10/15 - 16:55
 */
public class work1_2 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,8,9,0};
        int[] newArr = turnRound (arr);
        System.out.println ("翻转后的数组为"+Arrays.toString (newArr ) );
    }
    public static int[] turnRound(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[Math.abs (arr.length-1-i)];
        }
        return newArr;
    }

}
