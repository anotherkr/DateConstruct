package linkedlist.singlelinkedlist;

/**
 * @author yanhuanzhan
 * @date 2021/9/23 - 11:51
 */
public class SingleLinkedList {
    Node head = new Node (0, "", 0);

    //添加节点到单向链表
    //思路:当不考虑编号顺序时
    //1,找到当前链表的最后节点
    //2,将最后这个节点的next指向新的节点
    public void add(Node newNode) {
        //创建一个辅助节点
        Node temp = head;
        while (true) {
            if (temp.getNext ( ) == null) {
                break;
            }
            temp = temp.getNext ( );
        }
        //循环结束后temp指向链表的最后一个节点
        temp.setNext (newNode);
    }

    //考虑按编号顺序添加节点
    public void addByOrder(Node newNode) {
        //创建一个辅助节点
        Node temp = head;
        //标记链表内是否已有节点与新节点id相同
        boolean flag = false;
        while (true) {
            //因为单链表只能找到下一个节点,所以我们找的temp是位于添加位置的前一个节点
            //否则插入不了
            if (temp.getNext ( ) == null) {
                break;
            }
            if (newNode.getId ( ) < temp.getNext ( ).getId ( )) {
                break;
            } else if (newNode.getId ( ) == temp.getNext ( ).getId ( )) {
                flag = true;
                break;
            }
            temp = temp.getNext ( );
        }
        if (flag) {
            System.out.println ("节点编号" + temp.getId ( ) + "已经存在");
        } else {
            newNode.setNext (temp.getNext ( ));
            temp.setNext (newNode);

        }
    }

    //删除节点
    //思路
    //1,head不能动,需要一个temp辅助节点找到待删除节点的前一个节点
    //2,说明我们在比较时,是temp.next.no和需要删除的节点的no比较
    public void del(int id) {
        Node temp = head;
        //标记是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp.getNext ( ) == null) {
                break;
            }
            if (temp.getNext ( ).getId ( ) == id) {
                flag = true;
                break;
            }
        }
        if (flag) {
            temp.setNext (temp.getNext ( ).getNext ( ));
        } else {
            System.out.println ("要删除的节点不存在");
        }
    }

    public void list() {
        Node temp = head;
        //判断是否为空
        if (temp.getNext ( ) == null) {
            System.out.println ("链表为空");
            return;
        }
        while (true) {
            System.out.println (temp);
            if (temp.getNext ( ) == null) {
                break;
            }
            temp = temp.getNext ( );
        }

    }
    public void update(Node newNode){
        //判断是否为空
        Node temp = head.getNext ();
        if (head.getNext ( )==null) {
            System.out.println ("链表为空" );
            return;
        }
        //标记是否找到要修改的节点
        boolean flag = false;
        while (true) {
            if(temp==null){
                break;
            }
            if (newNode.getId ( ) == temp.getId ( )) {
                flag = true;
                break;
            }
            temp = temp.getNext ();
        }
        if (flag) {
            temp.setName (newNode.getName ());
            temp.setAge (newNode.getAge ());
        }else {
            System.out.println ("找不到编号为"+newNode.getId ()+"的节点" );
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
