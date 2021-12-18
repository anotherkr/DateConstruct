package main.maze;



import java.util.Stack;

/**
 * 迷宫问题,用栈的方式解决(深度优先遍历)
 *
 * @author yanhuanzhan
 * @date 2021/10/26 - 19:52
 */
public class MazeDemo_2 {
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
        Stack<Spot> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Spot spot = stack.peek();
            map[spot.getX()][spot.getY()] = 2;//标记走过的路径
            if (spot.getX() == end.getX() && spot.getY() == end.getY()) {
                System.out.println("成功找到通路");
                return;
            }
            if (map[spot.getX() + 1][spot.getY()] == 0) {//向右走
                stack.push(new Spot(spot.getX() + 1, spot.getY()));
                continue;
            }
            if (map[spot.getX()][spot.getY() + 1] == 0) {//向下走
                stack.push(new Spot(spot.getX(), spot.getY() + 1));
                continue;
            }
            if (map[spot.getX() - 1][spot.getY()] == 0) {//向左走
                stack.push(new Spot(spot.getX() - 1, spot.getY()));
                continue;
            }
            if (map[spot.getX()][spot.getY() - 1] == 0) {//向上走
                stack.push(new Spot(spot.getX(), spot.getY() - 1));
                continue;
            }
            //到这里没有continue说明该点上下左右都走不通
            //标记该点为3,为走不通的点
            map[spot.getX()][spot.getY()] = 3;
            //栈将其弹出
            stack.pop();
        }
    }
}
