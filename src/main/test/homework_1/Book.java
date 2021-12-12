package test.homework_1;

/**
 * @author yanhuanzhan
 * @date 2021/10/15 - 17:25
 */
public class Book implements Comparable {
   public int id;
    @Override
    public int compareTo(Object o) {
        o = new Book ();
        return this.id- ((Book) o).id;
    }

    public Book(int id) {
        this.id = id;
    }

    public Book() {
    }
}
