package test.homework_2.work2_4;

import java.util.LinkedList;

/**
 * @author yanhuanzhan
 * @date 2021/10/24 - 16:40
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<> ();
        list.add ("吉良吉影");
        list.add ("西索");
        list.add ("野兽先辈");
        System.out.println ("测试添加" );
        list.list ();
        System.out.println ("测试删除" );
        list.remove ("野兽先辈");
        list.list ();
        System.out.println ("测试contian西索:"+list.contain ("西索") );
        System.out.println ("测试set:" );
        list.set (1,"野兽先辈");
        list.list ();
        list.clear ();
        System.out.println ("测试清空" );
        list.clear ();
        list.list ();
    }

}
