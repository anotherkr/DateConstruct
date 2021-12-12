package kmp.kmpalgorithm;

import java.util.Arrays;

/**
 * @author yanhuanzhan
 * @date 2021/10/19 - 20:14
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "aaabaaaab";
        String str2 = "aaaa";
        int index = kmpSearch (str1, str2,kmpNext (str2));
        System.out.println (index );
        int[] arr = kmpNext (str2);
        System.out.println (Arrays.toString (arr));
        int[] next = getNext ("aaaa");
        System.out.println (Arrays.toString (next) );
        System.out.println (indexOf ("aaabaaab","aaaa",0) );
    }

    //写出我们的kmp搜索算法

    /**
     *
     * @param str1 待匹配字符串
     * @param str2 子串
     * @param next 部分匹配表,是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到,否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        int count=0;
        //遍历
        for (int i = 0, j = 0; i < str1.length ( ); i++) {
            if(j==0&&str1.charAt (i) != str2.charAt (j)){
                count++;
            }
            //需要处理str1.charAt(i)!=str2.charAt(j),去调整j大小
            //KMP算法核心
            while (j > 0 && str1.charAt (i) != str2.charAt (j)) {
                count++;
                j = next[j - 1];
            }
            if (str1.charAt (i) == str2.charAt (j)) {
                count++;
                j++;
            }
            if (j == str2.length ( )) {
                return i-j+1;
            }
        }
        System.out.println ("g"+count );
        return -1;
    }
    //获取一个字符串(子串)的部分匹配值
    public static int[] kmpNext(String dest) {
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length ( )];
        next[0] = 0;//如果字符串长度为1,部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length ( ); i++) {
            //当dest.charAt(i)!=dest.charAt(j),我们需要从next[j-1]获取新的j
            //直到我们发现有dest.charAt(i)==dest.charAt(j)成立才退出
            while (j > 0 && dest.charAt (i) != dest.charAt (j)) {//核心
                j = next[j - 1];//j-1是指已经与后缀匹配的前缀
            }

            if (dest.charAt (i) == dest.charAt (j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int[] getNext2(String pattern) {
        int j=0;
        int k =-1;
        int[] next = new int[pattern.length ( )];
        next[0]=-1;
        while (j < pattern.length ( ) - 1){
            if (k == -1 || pattern.charAt (j) == pattern.charAt (k)) {
                j++;
                k++;
                if (pattern.charAt (j) != pattern.charAt (k)) {
                    next[j] = k;
                }else {
                    next[j] = next[k];
                }
            }else {
                k = next[k];
            }
        }
        return next;
    }

    public static int[] getNext(String pattern) {
        int j=0;
        int k = -1;
        int[] next = new int[pattern.length ( )];
        next[0]= -1;
        while (j < pattern.length ( ) - 1) {
            if (k==-1||pattern.charAt (j)==pattern.charAt (k)) {
                j++;
                k++;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }
    public static int indexOf(String target, String pattern,int begin) {
        int n = target.length ();
        int m = pattern.length ();
        if (begin < 0) {
            begin = 0;
        }
        if (n == 0 || n < m || begin >= n) {
            return -1;
        }
        int[] next = getNext (pattern);
        int i = begin;
        int j = 0;
        int count=0;
        while (i < n && j < m) {
            if (j == -1 || target.charAt (i) == pattern.charAt (j)) {
                if (j != -1) {
                    count++;
                }

                i++;
                j++;
            }else {
                count++;
                j = next[j];
                if (n - i + 1 < m - j + 1) {
                    break;
                }
            }
        }
        System.out.println ("比较次数:"+count );
        if (j == m) {
            return i-j;
        }
        return -1;
    }
}
