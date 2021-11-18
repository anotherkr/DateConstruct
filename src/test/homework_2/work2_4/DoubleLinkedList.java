package test.homework_2.work2_4;

import java.util.*;
import java.util.function.UnaryOperator;

/** 双链表实现list接口
 * @author yanhuanzhan
 * @date 2021/10/24 - 15:58
 */
public class DoubleLinkedList<E> implements LList<E> {
Node<E> head = new Node<> ();
    @Override
    public void add(E e) {
        Node<E> cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
         Node<E> newNode = new Node<> (e);
        if (cur.next == null) {
            newNode.pre=cur;
            cur.next=newNode;
        }else {
            newNode.next = cur.next;
            cur.next.pre = newNode;
            cur.next=newNode;
            newNode.pre=cur;
        }
    }

    @Override
    public void list() {
        if (head.next == null) {
            System.out.println ("链表为空" );
            return;
        }
        Node<E> cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            System.out.println (cur.next.toString () );
            cur = cur.next;
        }
    }
    @Override
    public void remove(Object o) {

        Node<E> cur = head;
        boolean flag = false;//标记是否找到
        while (true) {
            if (cur.next == null) {
                break;
            }
            if(o.equals (cur.next.e)){
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {//找到
            if (cur.next.next == null) {
                cur.next=null;
            }else {
                cur.next.next.pre=cur;
                cur.next = cur.next.next;
            }

        }else {//没找到
            System.out.println ("该节点不存在" );
        }
    }

    @Override
    public boolean contain(Object o) {
        Node<E> cur = head;
         boolean flag = false;//标记是否找到
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.e.equals (o)) {
                flag=true;
                break;
            }
            cur = cur.next;
        }
        return flag;
    }

    @Override
    public void clear() {
        head.next=null;
    }

    @Override
    public void set(int index, Object o) {
       Node<E> cur = head;
       boolean flag = false;//标记是否超出范围
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                flag=true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            System.out.println ("超出范围" );
        }else {
            cur.setE ((E)o);
        }
    }
}
