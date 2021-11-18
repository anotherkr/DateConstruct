package test.homework_3.work3_5;

/**
 * @author yanhuanzhan
 * @date 2021/11/6 - 22:03
 */
public class Spot2 {
    int x;
    int y;
    int step;//记录所在点的步数

    public Spot2(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public Spot2(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
