package main.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author yanhuanzhan
 * @date 2021/10/30 - 10:36
 */
public class Graph {
    private ArrayList<String> vertexList;//存储顶点的集合
    private int[][] edges;//存储图对应的邻结矩阵
    private int numOfEdges;//表示边的数目
    private boolean[] isVisited;//标记某个节点是否被访问
    public static void main(String[] args) {
        int n=8;
        String vertexValue[] = {"1", "2", "3", "4", "5","6","7","8"};
        Graph graph = new Graph (n);
        for (String value : vertexValue) {
            graph.inserVertex (value);
        }
        //添加边
        //
        graph.insertEdge (0,1,1);
        graph.insertEdge (0,2,1);
        graph.insertEdge (1,3,1);
        graph.insertEdge (1,4,1);
        graph.insertEdge (3,7,1);
        graph.insertEdge (4,7,1);
        graph.insertEdge (2,5,1);
        graph.insertEdge (2,6,1);
        graph.insertEdge (5,6,1);
        graph.showGraph ();
        //测试一把dfs遍历
        System.out.println ("深度遍历" );
        graph.dfs ();//1->2->4->8->5->3->6->7->
//        System.out.println ("广度优先" );
//        graph.bfs ();//1=>2=>3=>4=>5=>6=>7=>8
    }
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<> ( );
        numOfEdges=0;


    }

    //得到第一个邻接节点的下标
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size ( ); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //第一个邻接节点走不通后，编写一个方法:根据第一个邻接节点的
    // 下标来获取下一个邻接节点的下标
    /**
     *
     * @param v1 代表该节点
     * @param v2 代表该节点的第一个邻接节点
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size ( ); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;//代表没有邻接节点
    }

    //深度优先遍历算法
    public void dfs(boolean[] isVisited, int i) {
        //首先我们访问该节点
        System.out.print (getValueByIndex (i)+"->" );
        //将该节点设置为已经访问
        isVisited[i]=true;
        int w = getFirstNeighbor (i);
        while (w != -1) {//说明有邻接节点
            if (!isVisited[w]) {
                dfs (isVisited,w);
            }
            //如果已经被访问过
            w = getNextNeighbor (i, w);
        }
    }

    //对dfs进行重载,遍历我们所有的节点,进行dfs(因为有可能某些节点与其他所有节点不连通)
    public void dfs() {
        isVisited = new boolean[vertexList.size ()];//标记某个节点是否被访问
        for (int i = 0; i < getNumOfVertex ( ); i++) {
            if (!isVisited[i]) {
                dfs (isVisited,i);
            }
        }
    }

    //对一个节点进行广度优先遍历的方法
    public void bfs(boolean[] isVisited, int i) {
        int u;//表示队列头节点对应的下标
        int w;//邻接节点
        //队列:记录节点访问的顺序
        LinkedList queue = new LinkedList ( );
        //访问节点,输出节点的信息
        System.out.print (getValueByIndex (i)+"=>" );
        //标记为已访问
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast (i);
        while (!queue.isEmpty ( )) {
            //取出队列的头节点下标
            u=(Integer) queue.removeFirst ();
            //得到第一个邻接点的下标
            w = getFirstNeighbor (u);
            while (w != -1) {//说明有邻接点
                //是否访问过
                if (!isVisited[w]) {
                    System.out.print (getValueByIndex (w)+"=>" );
                    //标记已经访问
                    isVisited[w]=true;
                    //入队
                    queue.addLast (w);
                }
                //以u为前驱点(可能是上级，也可能是上上级等),找w后面的下一个临接节点
                w = getNextNeighbor (u, w);//体现出广度优先

            }
        }
    }

    //遍历所有的节点,都进行广度优先遍历(因为有些节点可能与其他节点不连接)
    public void bfs() {
        isVisited = new boolean[vertexList.size ()];//标记某个节点是否被访问
        for (int i = 0; i < getNumOfVertex ( ); i++) {
            if (!isVisited[i]) {
                bfs (isVisited,i);
            }
        }
    }
    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }
    //返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size ();
    }

    //返回节点i(下标)对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get (i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println (Arrays.toString (link));
        }
    }
    //插入节点
    public void inserVertex(String vertex) {
        vertexList.add (vertex);
    }
//添加边
    /**
     *
     * @param v1 表示点的下标，即表示第几个顶点
     * @param v2 表示另一个顶点对应的下标
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }
}
