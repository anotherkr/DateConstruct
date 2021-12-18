package main.test.homework_3.work3_5;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 * 骑士周游,用栈解决
 *
 * @author yanhuanzhan
 * @date 2021/10/26 - 20:20
 */
public class KnightTravelDemo {
    private static int X=8;//棋盘的列数
    private static int Y=8;//棋盘的行数
    private static int[][] map = new int[X][Y];
    public static void main(String[] args) {

        System.out.println ("输出原始地图:" );
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                System.out.print (map[i][j]+"\t" );
            }
            System.out.println ( );
        }
        long start = System.currentTimeMillis ( );
        findWay(new Spot(3, 3));
        long end = System.currentTimeMillis ();
        System.out.println ("寻路后的地图----" );
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print (map[j][i]+"\t" );
            }
            System.out.println ( );
        }
        System.out.println ("共耗时:"+(end-start)+"毫秒" );
    }

    //编写一个方法，判断马走的路径是否越界
    public static boolean isOut(int x,int y) {
        if (x >= 0 && x < X && y >= 0 && y < Y) {
            return false;
        }else {
            return true;
        }
    }
    public static Stack<Spot> findWay(Spot start) {
        Stack<Spot> stack = new Stack<> ( );
        stack.push (start);
        int step=1;

        while (true){

            if (stack.isEmpty ( )) {
                System.out.println ("寻路失败" );
                return null;
            }
            Spot spot = stack.pop ();
            ArrayList<Spot> nextList = next (spot);
            sort (nextList);
            map[spot.x][spot.y]=step;
            //成功条件
            if (step == X * Y) {
                return stack;
            }
            step++;
            if (nextList.size () != 0) {
                Spot nextSpot = nextList.remove (0);
                spot.setNextList (nextList);

                stack.push (spot);
                stack.push (nextSpot);
            }else {
                map[spot.x][spot.y]=0;
                step--;
            }

        }
    }

//编写一个输出该点的下一步能走的点的集合
    public static ArrayList<Spot> next(Spot spot) {
        ArrayList<Spot> nextList = new ArrayList<> ( );
        int x=spot.x;
        int y=spot.y;
        if (x + 1 < X && y - 2 >= 0&&map[x+1][y-2]==0) {
            nextList.add (new Spot (x + 1, y - 2));
        }
        if (x + 2 < X && y - 1 >= 0&&map[x+2][y-1]==0) {
            nextList.add (new Spot (x + 2, y - 1));
        }
        if (x + 2 < X && y + 1 < Y&&map[x+2][y+1]==0) {
            nextList.add (new Spot (x + 2, y + 1));
        }
        if (x + 1 < X && y + 2 < Y&&map[x+1][y+2]==0) {
            nextList.add (new Spot (x + 1, y + 2));
        }
        if (x - 1 >= 0 && y + 2 < Y&&map[x-1][y+2]==0) {
            nextList.add (new Spot (x - 1, y + 2));
        }
        if (x - 2 >= 0 && y + 1 < Y&&map[x-2][y+1]==0) {
            nextList.add (new Spot (x - 2, y + 1));

        }
        if (x - 2 >= 0 && y - 1 >= 0&&map[x-2][y-1]==0) {
            nextList.add (new Spot (x - 2, y - 1));
        }
        if (x - 1 >= 0 && y - 2 >= 0&&map[x-1][y-2]==0) {
            nextList.add (new Spot (x - 1, y - 2));
        }
        return nextList;
    }
    //对算法进行优化,通过对nextList集合进行非递减排序,即将可下一步可选择的点的下一步可选择的点的个数
//排序,可选择少的在前面,便能减少循环次数
    public static void sort(ArrayList<Spot> nextList) {
        nextList.sort (new Comparator<Spot> ( ) {
            @Override
            public int compare(Spot o1, Spot o2) {
                //o1的可选择的点的个数
                int count1 = next (o1).size ( );
                int count2 = next (o2).size ();
                if (count1 > count2) {
                    return 1;
                } else if (count1 == count2) {
                    return 0;
                }else{
                    return -1;
                }

            }
        });
    }
}

