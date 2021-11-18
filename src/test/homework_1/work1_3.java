package test.homework_1;

/**
 * @author yanhuanzhan
 * @date 2021/10/15 - 12:20
 */
public class work1_3 {
    public static void main(String[] args) {
        int a = 100;
        int b = 65;
        System.out.println ("a,b的最大公约数:"+gcb (b,a%b) );
        System.out.println ("最小公倍数:"+gcb2 (a,b) );
        System.out.println ("a,b,c的最大公约数:"+gcb3 (200,100,5) );
    }
    //最大公约数
    public static int gcb(int a, int b){
        int m = Math.abs (a);
        int n = Math.abs (b);
        int res=1;
        if (n == 0) {
            return res=m;
        }
        res = gcb (b,a%b);
        return res;
    }
//最小公倍数
    public static int gcb2(int a, int b) {
         int res = 0;
         int mcf = 0;
         mcf = gcb(a,b);//最大公约数
         res = a*b/mcf;//结果
        return res;
    }

    //求abc的最大公约数
    public static int gcb3(int a, int b, int c) {
        int mcf1 = gcb(a,b);
        int mcf2 = gcb (b,c);
        int res = gcb (mcf1, mcf2);
        return res;
    }
}
