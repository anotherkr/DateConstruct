package main.hashtab;

/**
 * 链表
 *
 * @author yanhuanzhan
 * @date 2021/9/29 - 19:42
 */
public class EmpLinkedList {
    //头指针，执行第一个Emp，因此这个链表的head直接指向第一个Emp
    private Emp head;

    //添加雇员到链表
    //说明:
    //假定当添加雇员时id是自动增长的，即id是从小到大
    //因此将雇员直接添加到链表的最后即可
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则用辅助指针帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    //遍历链表信息
    public void list(int no){
        if (head == null) {
            System.out.println ("第"+(no+1)+"链表为空" );
            return;
        }
        System.out.print ("第"+(no+1)+"链表的信息为" );
        Emp curEmp = head;
        while (true) {
            System.out.printf ("=>id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println ( );
    }
    //根据id查找雇员
    public Emp findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println ("链表为空" );
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {//找到
                break;
            }
            if (curEmp.next == null) {//说明没找到
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
