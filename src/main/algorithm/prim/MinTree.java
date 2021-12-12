package algorithm.prim;

import java.util.Arrays;

/** 最小生成树
 * @author yanhuanzhan
 * @date 2021/11/4 - 16:50
 */
public class MinTree {
    //创建图的邻接矩阵

    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        for (int i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGrapgh(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     *  编写prim算法,得到最小生成树
     * @param graph 圆
     * @param v 表示从图的第几个顶点开始生成‘A'->0 'B'->1
     */
    public void prim(MGraph graph,int v) {
        //标记顶点是否被访问过
        boolean isVisited[] = new boolean[graph.verxs];
        //把当前这个节点标记为已访问
        isVisited[v] = true;
        //h1和h2记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        int minWeight = 10000;//先初始化成较大数,后面比较过程中会被替换
        for (int k = 1; k < graph.verxs; k++) {//因为graph.verxs顶点在普利姆算法结束后会有graph.verxs-1条边
            //这个是确定每一次生成的子图和哪一个节点的距离最近
            for (int i = 0; i < graph.verxs; i++) {//i节点表示被访问过的节点
                for (int j = 0; j < graph.verxs; j++) {//j节点表示未被访问过的节点
                    if (isVisited[i] && !isVisited[j] && graph.weight[i][j] < minWeight) {
                        //替换minWeight
                        minWeight = graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }
            //退出两层for循环后找到已访问顶点和未访问顶点之间的最小边
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">权值:"+minWeight);
            //将下标为j的顶点标记为已访问
            isVisited[h2]=true;
            //重置minWeight
            minWeight=10000;

        }


    }
}
