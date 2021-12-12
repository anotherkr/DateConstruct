package algorithm.prim;

/** 图
 * @author yanhuanzhan
 * @date 2021/11/4 - 16:39
 */
public class MGraph {
    int verxs;//表示图的节点数
    char[] data;//存放节点数据
    int[][] weight;//存放边,即邻接矩阵
    public MGraph(int verxs) {
        this.verxs=verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
