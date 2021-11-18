package test.homework_3.work3_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/** 骑士游历问题,用队列实现
 * @author yanhuanzhan
 * @date 2021/11/1 - 11:39
 */
public class KnightTravelDemo2 {
    private static int X=8;
    private static int Y=8;
    private static int[][] map = new int[X][Y];//地图
    private static boolean[] isVisited = new boolean[X * Y];//判断地图的点是否已经走过
    public static void main(String[] args) {

    }
    //编写骑士寻路方法
    public void findWay(Spot2 spot) {
        LinkedList<Spot2> queue = new LinkedList<> ();//队列
        spot.setStep(1);
        //标记地图
        boolean[] isVisited =new boolean[X*Y];
        isVisited[spot.y * X + spot.x]=true;

        queue.add (spot);

        while (queue.isEmpty ( )) {

            Spot2 headSpot = queue.removeFirst ();
            int step=headSpot.getStep()+1;//标记马在图上走的第几步


            //headSpot的所有下一步能走的点的集合
            ArrayList<Spot2> nextList = next (headSpot);
            sort (nextList);//优化算法,进行排序

            while (nextList.size ( ) != 0) {
                Spot2 next = nextList.remove (0);
                queue.addLast (next);
            }
        }
        System.out.println ("寻路失败" );
        return;

    }

    //编写一个判断马走的路径是否越界的方法
    public boolean isOut(int x, int y) {
        if (x < X && x >= 0 && y < Y && y >= 0) {
            return false;
        }else {
            return true;
        }
    }
    //编写一个输出该点的下一步能走的点的集合
    public static ArrayList<Spot2> next(Spot2 spot) {
        ArrayList<Spot2> nextList = new ArrayList<> ( );
        int x=spot.x;
        int y=spot.y;
        if (x + 1 < X && y - 2 >= 0&&map[x+1][y-2]==0) {
            nextList.add (new Spot2 (x + 1, y - 2));
        }
        if (x + 2 < X && y - 1 >= 0&&map[x+2][y-1]==0) {
            nextList.add (new Spot2 (x + 2, y - 1));
        }
        if (x + 2 < X && y + 1 < Y&&map[x+2][y+1]==0) {
            nextList.add (new Spot2 (x + 2, y + 1));
        }
        if (x + 1 < X && y + 2 < Y&&map[x+1][y+2]==0) {
            nextList.add (new Spot2 (x + 1, y + 2));
        }
        if (x - 1 >= 0 && y + 2 < Y&&map[x-1][y+2]==0) {
            nextList.add (new Spot2 (x - 1, y + 2));
        }
        if (x - 2 >= 0 && y + 1 < Y&&map[x-2][y+1]==0) {
            nextList.add (new Spot2(x - 2, y + 1));

        }
        if (x - 2 >= 0 && y - 1 >= 0&&map[x-2][y-1]==0) {
            nextList.add (new Spot2 (x - 2, y - 1));
        }
        if (x - 1 >= 0 && y - 2 >= 0&&map[x-1][y-2]==0) {
            nextList.add (new Spot2 (x - 1, y - 2));
        }
        return nextList;
    }

    //对算法进行优化,对每个点nextList集合进行排序
    private static void sort(ArrayList<Spot2> spots) {
        spots.sort (new Comparator<Spot2> ( ) {

            @Override
            public int compare(Spot2 o1, Spot2 o2) {
                //得到o1的所有可选点的集合的大小
                int count1=next (o1).size ();
                int count2=next (o2).size ();
                if (count1-count2 > 0) {
                    return 1;
                } else if (count1 == count2) {
                    return 0;
                }else {
                    return -1;
                }
            }
        });
    }
}
