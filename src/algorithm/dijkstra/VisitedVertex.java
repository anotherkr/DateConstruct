package algorithm.dijkstra;

import java.util.Arrays;

/** 已访问点的集合
 * @author yanhuanzhan
 * @date 2021/11/8 - 15:55
 */
public class VisitedVertex {
    //记录各个顶点是否访问过,1表示访问过,0表示未访问,会动态更新
    public int[] already_arr;
    //每个下标对应的值为前一个顶点的下标，会动态更新
    public int[] pre_visited;
    //记录出发点到其他所有点的距离,比如G为出发点,就会记录G到其他顶点的距离,会动态更新,求的最短距离就会存放到dis
    public int[] dis;

    /**
     *  构造器
     * @param length 表示顶点的个数
     * @param index 表示出发顶点对应的下标
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化
        Arrays.fill(dis,65535);
        this.already_arr[index]=1;//设置出发顶点被访问过
        this.dis[index]=0;//设置出发顶点到自己的距离为0
    }

    /**
     *  功能: 判断index顶点是否访问过
     * @param index
     * @return 如果访问过返回true，否则返回false
     */
    public boolean in(int index) {
        return already_arr[index]==1;
    }

    /**
     *  功能:更新出发顶点到index顶点的距离
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        dis[index]=len;
    }

    /**
     *  功能:更新pre顶点的前驱为index顶点
     * @param pre
     * @param index
     */
    public void updatePre( int index,int pre) {
        pre_visited[pre]=index;
    }

    /**
     *  功能:返回出发顶点到index顶点的距离
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }

    //继续选择并返回新的访问顶点，比如这里的G访问完后，就是A作为新的访问顶点(注意不是出发顶点)
    public int updateArr() {
        int min=65535;
        int index=0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min=dis[i];
                index=i;
            }
        }
        //更新index顶点被访问过
        already_arr[index]=1;
        return index;
    }

    //显示最后结果，即将三个数组输出
    public void show() {
        System.out.println("==================");
        System.out.println("输出already_arr:");
        for (int i : already_arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("输出pre_visited");
        for (int i : pre_visited) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("输出dis数组:");
        for (int i : dis) {
            System.out.print(i+" ");
        }
        System.out.println();
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count=0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count]+"("+i+")");
            }else {
                System.out.print("N");
            }
            count++;
        }
    }
}
