package main.search;

/**
 * @author yanhuanzhan
 * @date 2021/9/27 - 14:45
 */
public class test {
    public static void main(String[] args) {
        int n =3;
        int count = 0;
        for(int i=1;i<=n;i++){
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k <= j; k++) {
                    count++;
                }
            }
        }
        System.out.println (count );
    }
}
