package main.test.homework_1;

import main.test.homework_1.Book;

/**
 * @author yanhuanzhan
 * @date 2021/10/15 - 16:47
 */
public class work1_1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,6};
        System.out.println ("数组arr是否排序"+isSort (arr) );
         Book[] books = {new Book (1),new Book(5),new Book (3),new Book (4)};
        System.out.println ("Book数组是否排序"+isSort (books) );
    }
    //数组排序
    public static boolean isSort(int[] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[i] > arr[j]) {
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        return flag;
    }
    //判断对象数组是否排序
    public static boolean isSort(Comparable[] table) {
        boolean flag = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = i + 1; j < table.length ; j++) {
                if (table[i].compareTo (table[j])>=0) {
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        return flag;
    }

}
