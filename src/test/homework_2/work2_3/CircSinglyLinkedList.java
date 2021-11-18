package test.homework_2.work2_3;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @author yanhuanzhan
 * @date 2021/10/21 - 16:45
 */
public class CircSinglyLinkedList<E> implements List {
    Node head = new Node ("");

    int size;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        return indexOf (o)!=-1;
    }

    @Override
    public Iterator iterator() {
        Iterator<E> iterator = new Iterator<E>
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {

    }

    @Override
    public void sort(Comparator c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (head.next == null) {
            return -1;
        }
        if (o == null) {//如果查找目标为空
            for (Node<E> i = head.next; i != head; i = i.next) {
                if (i.e == null) {
                    return index;
                }
                index++;
            }
        }else {//如果查找目标不为空
            for (Node<E> i=head.next; i != head; i = i.next) {
                if (i.e.equals (o)) {
                    return index;
                }
                index++;
            }
        }
      return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
