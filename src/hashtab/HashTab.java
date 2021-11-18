package hashtab;

/**
 * @author yanhuanzhan
 * @date 2021/9/29 - 22:33
 */
public class HashTab {
    private EmpLinkedList[] empLinkedListsArray;
    private int size;//表示链表个数
    public HashTab(int size) {
        this.size = size;
        //初始化
        empLinkedListsArray = new EmpLinkedList[size];
        //?留一个坑,这是不要忘了分别初始化每一个链表，不然会报空指针
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i] = new EmpLinkedList ();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id，得到该员工应该添加到哪条链表
      int empLinkedListNO = hashFun (emp.id);
      //将emp添加到对应的链表中
        empLinkedListsArray[empLinkedListNO].add(emp);
    }



    //遍历所有链表，遍历hashtab
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i].list (i);
        }
    }

    //根据输入的id，查找雇员
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表
        int empLinkedListNO = hashFun (id);
        Emp emp = empLinkedListsArray[empLinkedListNO].findEmpById (id);
        if (emp != null) {//找到
            System.out.printf ("在第%d条链表找到雇员id=%d\n",empLinkedListNO+1,id );
        }else {
            System.out.println ("在哈希表中没有找到该雇员" );
        }
    }
    //编写散列函数，使用一个简单取模法
    public int hashFun(int id) {
        return id%size;
    }
}
