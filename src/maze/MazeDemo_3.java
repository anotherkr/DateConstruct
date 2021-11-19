package maze;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 迷宫问题,用队列的方式解决(广度优先遍历)
 *
 * @author yanhuanzhan
 * @date 2021/11/6 - 22:57
 */
public class MazeDemo_3 {
    public static void main(String[] args) {
        int[][] map = new int[8][8];
        //设1表示墙体，或路线走不通
        //设2为通路
        //设3表示该点走不通
        for (int i = 0; i < 8; i++) {
            //上下左右4个临界设置为墙
            map[i][0] = 1;
            map[i][7] = 1;
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //布置墙体
        map[1][3] = 1;
        map[2][1] = 1;
        map[2][5] = 1;
        map[3][3] = 1;
        map[3][5] = 1;
        map[4][2] = 1;
        map[4][4] = 1;
        map[5][4] = 1;
        map[5][6] = 1;
        map[6][1] = 1;
        map[6][2] = 1;
        map[6][3] = 1;
        map[6][4] = 1;
        map[6][6] = 1;
        //设置终点
        map[7][5] = 0;
        System.out.println("初始地图:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
        //开始寻路
        findWay(map, new Spot(1, 1), new Spot(7, 5));
        System.out.println("寻路后的地图:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void findWay(int[][] map, Spot start, Spot end) {
        Spot[][] mark = new Spot[map.length][map[0].length];//用于标记该点的前驱节点,为了寻找最短路径
        //设置出发点的前驱节点为自己
        mark[start.getX()][start.getY()] = start;
        map[start.x][start.y] = 2;
        Queue<Spot> queue = new LinkedList();
        queue.add(start);
        while (!queue.isEmpty()) {
            Spot headSpot = queue.poll();

            int x = headSpot.getX();
            int y = headSpot.getY();

            if (map[x + 1][y] == 0) {//向右
                if (mark[x + 1][y] == null) {//未被访问
                    queue.add(new Spot(x + 1, y));
                    //标记前驱节点
                    mark[x + 1][y] = headSpot;
                    if (x + 1 == end.getX() && y == end.getY()) {//找到终点
                        break;
                    }
                }

            }
            if (map[x][y + 1] == 0) {//向下
                if (mark[x][y + 1] == null) {
                    queue.add(new Spot(x, y + 1));
                    mark[x][y + 1] = headSpot;//标记前驱节点
                    if (x == end.getX() && y + 1 == end.getY()) {//找到终点
                        break;
                    }
                }
            }
            if (map[x - 1][y] == 0) {//向左
                if (mark[x - 1][y] == null) {
                    queue.add(new Spot(x - 1, y));
                    mark[x - 1][y] = headSpot;
                    if (x - 1 == end.getX() && y == end.getY()) {//找到终点
                        break;
                    }
                }
            }
            if (map[x][y - 1] == 0) {
                if (mark[x][y - 1] == null) {
                    queue.add(new Spot(x, y - 1));
                    mark[x][y - 1] = headSpot;
                    if (x == end.getX() && y - 1 == end.getY()) {//找到终点
                        break;
                    }
                }
            }
            if (map[x][y - 1] != 0 && map[x - 1][y] != 0 && map[x][y + 1] != 0 && map[x + 1][y] != 0) {//没有下一个点
                map[x][y] = 3;//标记为走不通
            }
        }
        if (mark[end.getX()][end.getY()] != null) {
            System.out.println("寻路成功");
            Spot spot = new Spot(end.getX(), end.getY());
            while (spot != start) {
                map[spot.x][spot.y] = 2;//标记为通路
                spot = mark[spot.x][spot.y];
            }
        } else {
            System.out.println("寻路失败");
        }
    }
}
