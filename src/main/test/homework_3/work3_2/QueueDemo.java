package test.homework_3.work3_2;

/**
 * @author yanhuanzhan
 * @date 2021/10/29 - 20:06
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<> ( );
        queue.add ("野兽先辈");
        queue.add ("西索");
        queue.add ("田所浩二");
        queue.peek ();
        queue.poll ();
        queue.poll ();
        queue.poll ();
        queue.poll ();
    }
}
