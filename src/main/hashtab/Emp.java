package main.hashtab;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**表示一个员工
 * @author yanhuanzhan
 * @date 2021/9/29 - 17:27
 */
public class Emp {
    public int id;
    public String name;
    public Emp next;//默认值1为null
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
