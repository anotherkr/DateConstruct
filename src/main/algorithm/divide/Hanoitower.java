package algorithm.divide;

/** 分治算法解决汉诺塔问题
 * @author yanhuanzhan
 * @date 2021/11/1 - 21:48
 */
public class Hanoitower {
    public static void main(String[] args) {
       hanoiTower (3,'A','B','C');
    }

    //汉诺塔的移动方法
    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println ("第一个从盘"+a+"->"+c );
        }else {
            //如果从盘大于等于2,就可以把整体看成两个从盘,最下面是盘2,其他盘是盘1
            //1，把最上面的从盘从A移到B，移动过程会用到C
            hanoiTower (num-1,a,c,b);
            //2，把最下面的盘从A移到C
            System.out.println ("第"+num+"个盘从"+a+"->"+c );
            //3，把B中的所有盘从B移到C,移动过程中用到A塔
            hanoiTower (num-1,b,a,c);
        }
    }
}
