package main.maze;

/**
 * 迷宫问题(递归方式)
 *
 * @author yanhuanzhan
 * @date 2021/11/19 - 22:16
 */
public class Maze {
    //设置终点
    static int endX = 7;
    static int endY = 5;

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
        findWay(map, 1, 1);
        System.out.println("寻路后的地图:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }

    }

    //寻路方法
    public static boolean findWay(int map[][], int x, int y) {
        if (map[endX][endY] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) {//该点未走过
                map[x][y] = 2;//假设该点走得通
                if (findWay(map, x, y + 1)) {//向下走
                    return true;
                } else if (findWay(map, x + 1, y)) {//向右走
                    return true;
                } else if (findWay(map, x - 1, y)) {//向左走
                    return true;
                } else if (findWay(map, x, y - 1)) {//向上走
                    return true;
                } else {
                    //说明该点走不通
                    map[x][y] = 3;
                    return false;
                }
            } else {//该点不为0，说明该点已经走过或走不通
                return false;
            }
        }
    }
}
