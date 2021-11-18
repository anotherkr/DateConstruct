package kmp.violenceMatch;

/** 暴力匹配
 * @author yanhuanzhan
 * @date 2021/10/19 - 18:41
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        //测试暴力匹配
        String str1 = "jojojjojjojjojjj";
        String str2 = "jjj";
        int index = violenceMatch (str1, str2);
        System.out.println (index );
    }

    //暴力匹配算法实现
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray ();
        char[] s2 = str2.toCharArray ();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0;//索引指向s1
        int j = 0;//索引指向s2
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                //如果匹配失败
                i = i - (j - 1);
                j = 0;
            }

        }
        //判断是否匹配成功
        if (j == s2Len) {
            return i - 1;
        } else {
            return -1;
        }
    }
}
