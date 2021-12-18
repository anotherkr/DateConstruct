package main.algorithm.kruskal;

import java.util.Arrays;

/** 克鲁斯卡尔算法
 * @author yanhuanzhan
 * @date 2021/11/4 - 20:26
 */
public class KruskalCase {
    private int edgeNum;//边的个数
    private  char[] vertexs;//顶点数组
    private int[][] maxtrix;//邻接矩阵
    //使用INF表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        //输出邻接矩阵
        kruskalCase.print();
        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertexs, int[][] maxtrix) {
        //初始化顶点数和边的个数
        this.vertexs = vertexs;
        this.maxtrix = maxtrix;
        //统计边的条数
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (this.maxtrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index=0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];//用于生成"最小生成树
        //创建结果数组,保存最后的最小生成树
        EData[] res = new EData[edgeNum];
        //获取所有边的集合
        EData[] edges = getEdges();
        //按照边的权值大小进行排序
        sortEdges(edges);
        //遍历edata数组,将边添加到最小生成树中时,判断是否准备加入的边是否形成回路，如果没有就加入res数组
        for (int i = 0; i < edgeNum; i++) {
            //获取第i条边的第一个顶点
            int p1 = getPosition(edges[i].start);
            //获取第i条边的第二个顶点
            int p2 = getPosition(edges[i].end);
            //获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(ends, p1);
            //获取p2这个顶点在已有最小生成树中的终点
            int n= getEnd(ends, p2);
            //是否构成回路
            if (n != m) {
                ends[m]=n;
                res[index++] = edges[i];
            }
        }
        //统计并打印"最小生成树",输出res
        System.out.println("最小生成树为="+ Arrays.toString(res));
    }
    public void print() {
        System.out.println("邻接矩阵为:\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d\t",maxtrix[i][j]);
            }
            System.out.println();
        }
    }
    //对边的权值进行排序
    public void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j+1]=tmp;
                }
            }
        }
    }
    //查找顶点在vertexs数组对应的下标
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //获取图中边，放到EData[]数组中，后面我们需要遍历该数组
    private EData[] getEdges() {
        int index=0;
        EData[] edges =new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {//j=i+1即跳过顶点本身
                if (maxtrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], maxtrix[i][j]);
                }

            }
        }
        return edges;
    }

    /**
     * 功能:获取下标为i的顶点的终点，用于后面判断两个顶点的终点是否相同
     * @param ends 记录了各个顶点对应的终点是哪一个,ends数组是在遍历过程中逐步形成
     * @param i
     * @return
     */
    private int getEnd(int[] ends,int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}
