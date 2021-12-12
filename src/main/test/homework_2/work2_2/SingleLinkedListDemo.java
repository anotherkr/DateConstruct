package test.homework_2.work2_2;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

/**
 * @author yanhuanzhan
 * @date 2021/10/19 - 14:45
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        String[] str = {"吉良吉影","揍敌客","西索"};
        SingleLinkedList<String> list1 = new SingleLinkedList<String> (str );
        System.out.println ("由指定数组中的多个对象构造单链表,遍历如下" );
        list1.list ();
        SingleLinkedList<String> list2 = new SingleLinkedList<String> (list1);
        System.out.println ("以单链表list1构造新的单链表,遍历如下:" );
        list2.list ();

        System.out.println ("将指定链表list2接在list1链表之后,遍历如下" );
        list1.concat (list2);//链接两个链表
        list1.list ();

        Node<String> searchNode = list1.search (new String ("西索"));
        System.out.println ("使用查找方法查找节点西索,结果为"+searchNode.toString () );

        System.out.println ("使用contain方法查找西索,结果为"+list1.contain ("西索") );

        list1.remove ("西索");
        System.out.println ("list1链表remove西索之后,遍历链表" );
        list1.list ();
        list1.replace ("西索","jojo");
        System.out.println ("将西索替换为jojo,遍历后为" );
        list1.list ();
        SingleLinkedList<String> list3 = new SingleLinkedList<String> (list1);
        System.out.println ("链表list1是否与list3相等:"+list1.equals (list3) );
        System.out.println ("链表list1是否与list2相等:"+list1.equals (list2) );
    }
}
