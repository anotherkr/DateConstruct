package horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/** 马踏棋盘算法(骑士周游算法)
 * @author yanhuanzhan
 * @date 2021/10/27 - 20:28
 */
public class HorseChessDemo {
    private static int X;//棋盘的列数
    private static int Y;//棋盘的行数
    //创建一个数组,标记棋盘的各个位置是否被访问过
    private static boolean isVisited[];
    //使用一个属性,标记是否棋盘的所有位置都被访问过
    private static boolean isFinished;//如果为true表示成功
    public static void main(String[] args) {
        X=8;
        Y=8;
        int row=1;
        int column=1;
        //创建棋盘
        int[][] chessBoard = new int[X][Y];
        isVisited = new boolean[X * Y];//初始值都是false
        //测试一下耗时
        long start = System.currentTimeMillis ( );
        traversalChessboard (chessBoard,row-1,column-1,1);
        long end = System.currentTimeMillis ();
        System.out.println ("共耗时"+(end-start)+"毫秒" );
        System.out.println ("运行后棋盘的情况:" );
        for (int[] rows : chessBoard) {
            for (int step : rows) {
                System.out.print (step+"\t" );
            }
            System.out.println ( );
        }
    }

    /**
     *  功能:根据当前的位置(Point)对象,计算马儿还能走哪些位置并记录放进ArrayList中,最多有8个位置
     * @param curPoint 当前位置
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> ps = new ArrayList<> ( );
        Point p1 = new Point ( );
        //往左两格，往上一格
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add (new Point (p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add (new Point (p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add (new Point (p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add (new Point (p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add (new Point (p1));
        }
        if ((p1.x = curPoint.x +1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add (new Point (p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add (new Point (p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1)  < Y) {
            ps.add (new Point (p1));
        }
       return ps;
    }

    /**
     *
     * @param chessBoard
     * @param row 马所在行,从0开始
     * @param column 马所在列,从0开始
     * @param step 是第几步,初始位置是第一步
     */
    public static void traversalChessboard(int[][] chessBoard, int row, int column, int step) {
        chessBoard[row][column] = step;
        //row*X+column代表从0，0开始从左到右从上到下数的第几个,这样可以保证不重复，
        //不使用二维数组是因为一维数组占空间小
        isVisited[column*X+row] = true;
        //获取当前位置可以走的下一步的集合
        ArrayList<Point> ps = next (new Point (row, column));
        //排序，优化算法
        sort (ps);
        while (!ps.isEmpty ( )) {
            //取出下一个可以走的位置
            Point p = ps.remove (0);
            //判断该点是否访问过
            if (!isVisited[p.y * X + p.x]) {//还没有被访问过
                //递归
                traversalChessboard (chessBoard,p.x,p.y,step+1);
            }
        }
        //判断马儿是否完成了任务,所有step和应该走的步数比较
        //如果没有达到数量,则表示没有完成任务,将整个棋盘置0
        if (step < X * Y && !isFinished) {
            chessBoard[row][column] = 0;
            isVisited[column*X+row]=false;
        }else {
            isFinished=true;
        }
    }
    //对算法进行优化
    //根据当前的点的下一步可以选择的点的下一步可以选择的点的个数进行排序
    //以此减少回溯的次数
    public static void sort(ArrayList<Point> ps){
        ps.sort (new Comparator<Point> ( ) {
            @Override
            public int compare(Point o1, Point o2) {
                //获取o1的下一步可选择位置的个数
                int count1 = next (o1).size ();
                int count2 = next (o2).size ();
                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                }else {
                    return -1;
                }
            }
        });
    }
}
