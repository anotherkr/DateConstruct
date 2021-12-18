package main.test.homework_3.work3_1;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author yanhuanzhan
 * @date 2021/10/29 - 16:39
 */
public class work3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println ("请输入数字:" );
        int value = scanner.nextInt ();
        String binaryValue = change (value);
        System.out.println ("转化为二进制后为:"+binaryValue );
    }

    public static String change(int value) {
        Stack<Integer> stack = new Stack<> ( );
        while (value!=0) {
             int remainder=value%2;//余数
             value=value/2;
            stack.push (remainder);
        }
        StringBuilder stringBuilder = new StringBuilder ( );
        while (stack.size ( ) != 0) {
            int i=stack.pop ();
            stringBuilder.append (i);
        }
        return String.valueOf (stringBuilder);
    }
}
