package test.homework_3.work3_4;

/** 作为一个点
 * @author yanhuanzhan
 * @date 2021/10/26 - 16:10
 */
public class Spot {
    int x;
    int y;

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
