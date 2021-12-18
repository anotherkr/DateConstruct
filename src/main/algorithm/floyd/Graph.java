package main.algorithm.floyd;

import java.util.Arrays;

/** 图
 * @author yanhuanzhan
 * @date 2021/11/9 - 23:07
 */
public class Graph {
    private char[] vertex;//存放顶点的数组
    private int[][] dis;//保存,从各个顶点出发到其他顶点的距离,最后的结果也是保留在该数组中
    private int[][] pre;//保存到达目标节点的前驱节点

    /**
     *
     * @param length 大小
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex=vertex;
        this.dis=matrix;
        this.pre = new int[length][length];
        //对pre数组初始化,注意存放的是前驱顶点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i],i);

        }
    }

    //显示pre数组和dis数组
    public void show() {
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]]+" ");
            }
            System.out.println();
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[k]+"到"+vertex[i]+"的最短距离是"+dis[k][i]+" ");
            }
            System.out.println();
            System.out.println();
        }
    }

    //弗洛伊德算法
    public void floyd() {
        int len=0;//保存距离
        //对中间顶点进行遍历
        for (int k = 0; k < dis.length; k++) {
            //从i顶点开始出发{'A', 'B', 'C', 'D', 'E', 'F', 'G'}
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];//求出从i顶点出发经过中间顶点k到达j顶点的距离
                    if (len < dis[i][j]) {
                        dis[i][j]=len;
                        pre[i][j] = pre[k][j];//更新前驱节点
                    }
                }
            }
        }
    }
}
