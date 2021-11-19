package algorithm.dijkstra;

/**
 * @author yanhuanzhan
 * @date 2021/11/23 - 20:36
 */
public class DijkstraAlgorithm_2 {
    static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    static int[][] matrix = new int[vertex.length][vertex.length];
    static int N = Integer.MAX_VALUE;//作为无穷大

    public static void main(String[] args) {

        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        dijkstra(6);

    }

    /**
     * @param begin 起始点
     */
    public static void dijkstra(int begin) {
        int dis[] = new int[vertex.length];//记录起始点与其他顶点的距离
        //初始化dis数组
        for (int i = 0; i < vertex.length; i++) {
            dis[i] = matrix[begin][i];
        }
        //标记顶点是否访问过
        boolean[] isVisited = new boolean[vertex.length];
        isVisited[begin] = true;//标记起始点为已访问
        //记录前驱顶点
        int[] pre = new int[vertex.length];
        //初始化pre数组
        for (int i = 0; i < pre.length; i++) {
            pre[i] = begin;//没有中间顶点时,顶点的前驱为初始顶点
        }
        //循环vertex.length-1次，依次以其他顶点作为中间顶点
        int mid = 0;//中间顶点的下标
        for (int i = 0; i < vertex.length - 1; i++) {
            int min = N;
            for (int j = 0; j < vertex.length; j++) {
                //寻找未访问的且与初始顶点距离最小的顶点作为中间顶点
                if (isVisited[j] == false && dis[j] < min) {
                    min = dis[j];
                    mid = j;
                }
                isVisited[mid] = true;//标记为已访问
                //以中间顶点为跳板,更新初始顶点与其他顶点的最短距离
                for (int k = 0; k < vertex.length; k++) {
                    //matrix[mid][k] + dis[mid]表示初始顶点经过中间顶点到k顶点的距离
                    int temp = (matrix[mid][k] == N ? N : (matrix[mid][k] + dis[mid]));
                    if (temp < dis[k]) {//说明temp为目前初始顶点到k顶点的最短距离
                        dis[k] = temp;
                        pre[k] = mid;//更新k的前驱顶点为mid
                    }
                }

            }
        }
        //输出结果dis数组
        for (int i = 0; i < dis.length; i++) {
            System.out.println("顶点" + vertex[begin] + "到顶点" + vertex[i] + "的距离为:" + dis[i]);
        }
        //输出前驱节点
        System.out.println("pre数组:");
        for (int i = 0; i < vertex.length; i++) {
            System.out.println("顶点" + vertex[i] + "的前驱顶点为:" + vertex[pre[i]]);
        }

    }
}
