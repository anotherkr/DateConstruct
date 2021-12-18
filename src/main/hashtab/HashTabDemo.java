package main.hashtab;

import java.util.Scanner;

/**
 * 谷歌公司的一个上机yu题:
 * 有一个公司，当有员工来报道时，要求该员工将信息加入
 * （id，性别，年龄，地址），当输入该员工的id时，要求找到该员工的所有信息
 * 要求：不使用数据库，速度越快越好=>哈希表(散列)
 * 添加时，保证按照id从低到高插入（课后思考题：如果id不是从低到高插入，但要求各链表仍是从低到高，怎么解决？
 *
 * @author yanhuanzhan
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab (7);
        //写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner (System.in);
        while (true) {
            System.out.println ("add: 添加雇员");
            System.out.println ("find:查找雇员" );
            System.out.println ("list: 显示雇员");
            System.out.println ("exit:退出系统");
            key = scanner.next ( );
            switch (key) {
                case "add":
                    System.out.println ("输入id");
                    int id = scanner.nextInt ( );
                    System.out.println ("输入名字");
                    String name = scanner.next ( );
                    //创建雇员
                    Emp emp = new Emp (id, name);
                    hashTab.add (emp);
                    break;
                    case"find":
                        System.out.println ("请输入要查找的id" );
                         id = scanner.nextInt ();
                        hashTab.findEmpById (id);
                case "list":
                    hashTab.list ( );
                    break;
                case "exit":
                    scanner.close ();
                    System.exit (0);
                default:
                    break;
            }


        }
    }
}
