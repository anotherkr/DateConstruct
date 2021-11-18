package test.homework_2.work2_7;

/**
 * @author yanhuanzhan
 * @date 2021/10/21 - 20:16
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<> ();
        list.add ("士兵1");
        list.add ("士兵2");
        list.add ("士兵3");
        list.add ("士兵4");
        list.add ("士兵5");
        //从第1个开始，数到第二个出圈
        list.josefu (1, 2);
    }
}
