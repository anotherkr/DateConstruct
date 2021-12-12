package test.homework_3.work3_5;

import java.util.ArrayList;

/**
 * @author yanhuanzhan
 * @date 2021/10/26 - 20:18
 */
public class Spot {
    int x;
    int y;
    ArrayList<Spot> nextList;//记录该点的下一步能走的点的集合

    public ArrayList<Spot> getNextList() {
        return nextList;
    }

    public void setNextList(ArrayList<Spot> nextList) {
        this.nextList = nextList;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
