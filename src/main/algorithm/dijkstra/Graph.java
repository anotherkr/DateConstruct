package main.algorithm.dijkstra;

import java.util.Arrays;

/** 图
 * @author yanhuanzhan
 * @date 2021/11/8 - 15:43
 */
public class Graph {
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vv;//已经访问的点的集合
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示图
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     *  迪杰斯特拉算法的实现
     * @param index 表示出发顶点对应的下标
     */
    public void dsj(int index) {
         vv = new VisitedVertex(vertex.length, index);
         update(index);//更新index顶点到周围顶点的距离和前驱顶点
        for (int j = 1; j < vertex.length; j++) {
            index=vv.updateArr();//选择并返回新的访问顶点
            update(index);//更新index顶点到周围顶点的距离和前驱节点
        }

    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
    public void update(int index) {
        int len=0;
        //遍历matrix[index]行
        for (int j = 0; j < matrix[index].length; j++) {
            //len的含义:出发顶点到index顶点的距离+从index顶点到j顶点的距离和
            len = vv.getDis(index)+matrix[index][j];
            //如果j顶点没有被访问过,并且len小于出发顶点到j顶点的距离，就需要更新
            if (!vv.in(j) && len < vv.getDis(j)) {
                vv.updatePre(j,index);//更新j顶点的前驱为index顶点
                vv.updateDis(j,len);//更新出发顶点到j顶点的距离

            }
        }
    }

    //显示结果
    public void showDijkstra() {
        vv.show();
    }
}
