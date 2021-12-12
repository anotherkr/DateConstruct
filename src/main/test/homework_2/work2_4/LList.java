package test.homework_2.work2_4;

/**
 * @author yanhuanzhan
 * @date 2021/10/24 - 16:06
 */
public interface LList<E> {
    public void add(E e);
    public void list();
    public void remove(Object o);
    public boolean contain(Object o);
    public void clear();
    public void set(int index, Object o);
}
