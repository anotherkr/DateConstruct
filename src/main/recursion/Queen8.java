package main.recursion;

/** 八皇后问题
 * @author yanhuanzhan
 * @date 2021/12/6 - 22:15
 */
public class Queen8 {
    //定义一个max表示有多少个皇后
    static int max = 8;
    static int count = 0;//记录八皇后问题的解法数
    //定义数组queen,保存皇后放置位置的结果
    //queen的下标表示行,存放的数据表示列
    static int[] queen = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        findSpace(1);
        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    //判断某个皇后是否与已有皇后冲突
    public static boolean available(int pointi, int pointj) {
        for (int i = 1; i < pointj; i++) {
            if (pointi == queen[i]) {//同一列
                return false;
            }
            if (pointj - i == (pointi - queen[i])) {//同一主对角线
                return false;
            }
            if ((pointj - i) + (pointi - queen[i])==0) {//同一副对角线
                return false;
            }
        }
        return true;
    }

    //    在queenNumber行能找到放皇后的位置
    public static void findSpace(int queenNumber) {
        for (int i = 1; i < 9; i++) {//从1-8遍历这一行的8个空位
            if (available(i, queenNumber)) {
                //如果可以放则记录下第queenNumber个皇后的位置
                queen[queenNumber] = i;
                //如果8个皇后都放满了，统计一下
                if (queenNumber == 8) {
                    count++;
                    return;//返回上一层，尝试其他位置
                }
                //还有皇后没递归放下一个皇后
                int nextNumber=queenNumber+1;
                findSpace(nextNumber);
            }
        }
        //如果这一行没有可放的位置说明上一行皇后放的位置不行，要为上一个皇后寻找新的可放的位置
    }

}
