package main.test.homework_2.work2_10;

import java.util.Scanner;

/**
 * @author yanhuanzhan
 * @date 2021/10/22 - 17:27
 */
public class RandomLinkedListDemo {
    public static void main(String[] args) {
        RandomLinkedList list = new RandomLinkedList ( );
        initial (list);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner (System.in);
        while (true) {
            System.out.println ("a(add):添加曲目" );
            System.out.println ("d(delete):添加曲目" );
            System.out.println ("l(list):播放曲目" );
            key = scanner.next ( ).charAt (0);
            switch (key) {
                case 'a':
                    System.out.println ("请输入添加的曲目:" );
                    int value = scanner.nextInt ();
                    list.add (value);
                      break;
                 case 'd':
                     System.out.println ("请输入删除的曲目:" );
                         value = scanner.nextInt ();
                         list.delete (value);
                         break;
                case 'l':
                      list.list ();
                      break;
            }
        }

    }

    //初始化
    public static void initial(RandomLinkedList list) {
        for (int i = 0; i < 10; i++) {
            list.add (i);
        }
    }
}
