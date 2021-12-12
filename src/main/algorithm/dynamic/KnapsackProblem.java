package algorithm.dynamic;

/** 动态规划算法
 * @author yanhuanzhan
 * @date 2021/11/2 - 1:49
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//保存物品的重量
        int[] val = {1500, 3000, 2000};//保存物品的价值
        int m=4;//背包容量
        int n=val.length;//物品个数

        //创建表格，v[i][j]代表在前i个物品中能够装入的物品的最大价值
        int[][] v = new int[n + 1][m + 1];
        //为了记录放入的商品情况,我们定义一个二维数组
        int[][] path = new int[n + 1][m + 1];
        //第一行和第一列，默认为0
        //动态规划处理
        for (int i = 1; i < v.length; i++) {//不处理第一行，i从1开始
            for (int j = 1; j < v[0].length; j++) {//不处理第一列，j从1开始
                //i代表第几个物品，j代表背包容量
                //当物品重量大于背包容量时
                if (w[i-1] > j) {//因为程序从1开始,为了与物品对应,w应该-1
                    v[i][j]=v[i-1][j];
                }else {
                    //因为二维数组的i从1开始，所以val和w的下标都要-1
//                    v[i][j] = Math.max (v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品放入到背包的情况,我们不能简单使用上面的式子，应该为ifelse形式
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //记录到path
                        path[i][j]=1;
                    }else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }

        }
//输出v查看结果
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print (v[i][j]+" " );
            }
            System.out.println ( );
        }
        //输出应该放入哪些商品
        int i=path.length-1;//行的最大下标
        int j=path[0].length-1;//列的最大下标
        while (i > 0 && j > 0) {//从path最后开始找
            if (path[i][j] == 1) {
                System.out.println ("第"+i+"个商品加入背包" );
                j -= w[i - 1];
            }
            i--;
        }
    }

}
