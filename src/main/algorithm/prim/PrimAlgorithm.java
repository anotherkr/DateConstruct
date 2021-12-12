package algorithm.prim;

/** 普利姆算法
 * @author yanhuanzhan
 * @date 2021/11/4 - 16:38
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵用二维数组表示,10000表示两个点不联通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000,10000, 2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        //创建图对象
        MGraph mGraph = new MGraph(verxs);
        //创建最小生成树对象
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        minTree.showGrapgh(mGraph);
        minTree.prim(mGraph,0);//234547

    }
}
