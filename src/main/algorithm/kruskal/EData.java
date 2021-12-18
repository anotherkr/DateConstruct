package main.algorithm.kruskal;

/** 创建一个类,它的对象实例就是一条边
 * @author yanhuanzhan
 * @date 2021/11/4 - 20:49
 */
public class EData {
    char start;//边的起点
    char end;//边的另外一个点
    int weight;//边的权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    //重写toString

    @Override
    public String toString() {
        return "EData[<" +
                  start +
                ", " + end +
                ", weight=" + weight +
                ">]";
    }
}
