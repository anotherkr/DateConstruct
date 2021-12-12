package huffmancode;

import java.io.*;
import java.util.*;

/** 赫夫曼编码
 * @author yanhuanzhan
 * @date 2021/10/11 - 19:58
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        //将字符串编码成byte序列并存到byte[]数组中
        byte[] contentBytes = content.getBytes ();
//        System.out.println (contentBytes );//40
//        List<Node> nodes = getNodes (contentBytes );
//        System.out.println (nodes );
//        System.out.println ("赫夫曼树-----" );
//        Node root = creatHuffmanTree (nodes);
//        preOrder (root);
//        //测试赫夫曼编码
//        getCodes (root,"",stringBuilder);
//        System.out.println ("赫夫曼编码表----"+huffmanCodes );
//        //测试哈夫曼编码对应的byte数组
//        byte[] huffmanCode = zip (contentBytes,huffmanCodes);
//        System.out.println (Arrays.toString (huffmanCode));//17个
        //封装后
//        byte[] huffmanCodeByte = huffmanZip (contentBytes);
//        System.out.println (Arrays.toString (huffmanCodeByte) );
//        byte[] sourceBytes = decode (huffmanCodes, huffmanCodeByte);
//        System.out.println ("解码后:"+new String (sourceBytes));
//         测试压缩文件
//        String src = "e://测试哈夫曼压缩文件/ChromeSetup.exe";//要压缩的文件
//        String dst = "e://测试哈夫曼压缩文件/jojo2.zip";
//        zipFile (src,dst);
//        System.out.println ("压缩成功!" );
        //测试解压文件
        String zipFile = "e://测试哈夫曼压缩文件/jojo2.zip";
        String dstFile = "e://测试哈夫曼压缩文件/ChromeSetup2.exe";
        unZipFile (zipFile,dstFile);
        System.out.println ("解压成功!" );
    }

    //前序遍历
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder ();
        }else {
            System.out.println ("空树,不能遍历" );
        }
    }
//
    /** 编写一个将contentBytesn数组中的数据及数据出现次数(权值)存进list中,方便后续生成赫夫曼树
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<> ( );
        //遍历bytes，统计每一个相同byte出现的次数->map[key,value]
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get (b);
            //如果这个字符第一次出现，count会为null而不是0
            if (count == null) {
                counts.put (b, 1);
            }else {
                //map中如果出现相同的键，后来的键会替代先前的
                counts.put (b, count+1);
            }
        }
      //把每一个键值对转换成一个Node对象,并加入到nodes集合
        //遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet ( )) {
            nodes.add (new Node (entry.getKey (),entry.getValue ()));
        }
        return nodes;
    }

    //通过list创建对应的赫夫曼树
    private static Node creatHuffmanTree(List<Node> nodes) {
        while (nodes.size ( ) > 1) {
            //排序，从大到小排（为了在集合remove的时候不会导致整个数组发生移动，取最后两个节点,即值最小的两个节点)
            Collections.sort (nodes);
            //创建一个新的二叉树，它的根节点没有data,只有权值
            Node parent = new Node (null,nodes.get (nodes.size ( ) - 1).getWeight () + nodes.get (nodes.size () - 2).getWeight ());
            parent.setLeft (nodes.get (nodes.size ()-1));
            parent.setRight (nodes.get (nodes.size ()-2));
            nodes.remove (nodes.get (nodes.size ( ) - 1));
            nodes.remove (nodes.get (nodes.size ( ) - 1));
            nodes.add (parent);
        }
        return nodes.get (0);
    }

    //生成赫夫曼树对应的赫夫曼编码
    //思路:
    //1,将赫夫曼编码表放在Map<Byte,String>
    static Map<Byte, String> huffmanCodes = new HashMap<> ( );
    //2,在生成赫夫曼编码时，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder ( );

    /**
     *  功能:将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入huffmanCodes集合
     * @param node 传入的节点
     * @param code 路径:左子节点是0,右子节点是1
     * @param stringBuilder 是用于拼接路径的
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder (stringBuilder );
        stringBuilder2.append (code);
        if (node != null) {
            //判断当前是叶子节点还是非叶子节点
            if (node.data == null) {//非叶子节点
                //递归处理
                //向左，为编码路径为0
                getCodes (node.left,"0",stringBuilder2);
                //向右递归，编码路径为1
                getCodes (node.right,"1",stringBuilder2);

            }else {//说明是个叶子节点,将赫夫曼编码放进集合
                huffmanCodes.put (node.data, stringBuilder2.toString ( ));
            }
        }
    }

    //编写一个方法,将字符串对应的byte[]数组,通过生成的哈夫曼编码表,返回一个哈夫曼编码压缩后的byte[]
    /**
     *
     * @param bytes 原始字符串对应的byte[]
     * @param huffmanCodes 保存哈夫曼编码表的map
     * @return 返回哈夫曼编码处理后的byte[]
     *
     *
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1，利用哈夫曼编码表，将bytes转成对应的字符串
        StringBuilder stringBuilder = new StringBuilder ( );
        //遍历得到字符串
        for (byte b : bytes) {
            stringBuilder.append (huffmanCodes.get (b));
        }
        System.out.println ("原始字符串的哈夫曼编码"+stringBuilder.toString () );
        //统计返回byte[] huffmanCodeBytes的长度
        int len;
        if (stringBuilder.length ( ) % 8 == 0) {
            len = stringBuilder.length ()/8;
        }else {
            len = stringBuilder.length ()/8+1;
        }
        //也可以用一句话搞定:int len = (stringBuilder+7)/8
//        创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个byte
        for (int i = 0; i < stringBuilder.length ( ); i+=8) {//因为每8位对应一个byte
            String strByte;
            //如果不够8位
            if (i + 8 > stringBuilder.length ( )) {
                strByte = stringBuilder.substring (i);//有多少位取多少位
                //如果最后是00100之类情况,要计算最后几位前面有几个0，防止解压时漏掉一些编码
                int zeroCount = 0;
                int j=0;//索引
                while (true) {
                    if(strByte.charAt (j)=='0'){
                       zeroCount++;
                       j++;
                    }else {
                        break;
                    }
                }
                huffmanCodes.put (null, String.valueOf (zeroCount));
            }else {
                strByte = stringBuilder.substring (i, i + 8);//前索引取得到，后索引取不到
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt (strByte,2);//表示2进制
            index++;

        }
        return huffmanCodeBytes;
    }

    //使用一个方法，将前面的方法封装起来,便于使用

    /**
     *
     * @param bytes 原始字符串对应的字节数组
     * @return 哈夫曼编码处理后的数组(压缩后的数组)
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //得到bytes对应的节点集合
        List<Node> nodeList = getNodes (bytes);
        //创建哈夫曼树
       Node root = creatHuffmanTree (nodeList);
        Map<Integer, String> map = new HashMap<> ( );
        //得到哈夫曼编码表
        getCodes (root,"",stringBuilder);
        byte[] huffmanCodeByte = zip (bytes, huffmanCodes);
             return huffmanCodeByte;
    }

    //完成数据的解压

    /**
     * 将byte转成二进制的字符串
     * @param huffmanCodes 要传入哈夫曼编码表，不然解压调用的是全局那个为null的编码表，导致解压失败
     * @param flag 标志是否位最后一位,如果是最后一个字节，无需补高位
     * @return
     */
    private static String byteToBitString(boolean flag,byte b,Map<Byte,String> huffmanCodes) {
        int temp = b;//转成int
        if(flag) {
            //如果是正数要补高位
            temp |= 256;//按位或 256二进制:1 0000 0000
        }
        String str = Integer.toBinaryString (temp);//返回的是temp对应的二进制的补码
        if (flag) {
            return str.substring (str.length ( ) - 8);//int有4个字节32位
        }else {
            //若最后一位不足8位
            if(str.length ()<8){
                //从哈夫曼编码表取出之前存在null位置的数据(即最后一位前面0的个数)
                int zeroCount = Integer.parseInt (huffmanCodes.get (null));
                for (int i = 0; i < zeroCount; i++) {
                    //将0补回去
                    str = '0'+str;
                }
            }
            return str;
        }
    }

    //编写一个方法，完成对压缩数据的解码

    /**
     *
     * @param huffmanCodes 哈夫曼编码表
     * @param huffmanBytes 哈夫曼编码得到的字节数组
     * @return 原来字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes) {
        //1,先得到huffmanBytes 对应的二进制字符串,形式1010100010111...
        StringBuilder stringBuilder = new StringBuilder ( );
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length;i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag,b,huffmanCodes));
        }
        System.out.println ("解压后的哈夫曼编码:"+stringBuilder.toString () );
        //把字符串转成bytes
        //把哈夫曼编码表进行调换,因为反向查询 a->100 100->a
        Map<String, Byte> map = new HashMap<> ( );
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet ( )) {
            map.put (entry.getValue ( ), entry.getKey ( ));
        }
        //创建集合存放byte,因为byte个数未知
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length ( ); ) {
            int count = 1;//得到byte的个数
            boolean flag = true;
            Byte b = null;
            while (flag) {
                //取出一个'1' '0'
                String key = stringBuilder.substring (i, i + count);
                b = map.get (key);
                if (b == null) {
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add (b);
             i+= count;
        }
        //当for循环结束后,list存放了"i like like java do you a java"
        //把list的数据放入byte[]返回
        byte[] b = new byte[list.size ( )];
        for (int i = 0; i < list.size ( ); i++) {
            b[i] = list.get (i);
        }
        return b;
    }

    //编写一个方法,将文件进行压缩

    /**
     *
     * @param srcFile 需要压缩的文件的全路径
     * @param dstFile 压缩后将压缩文件放到哪个目录
     */
    public static void zipFile(String srcFile, String dstFile) {
        //创建输出流
        FileInputStream is = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            //创建文件的输入流
            is = new FileInputStream (srcFile);
            //创建输出流
            os = new FileOutputStream (dstFile);
            //创建一个和文件输出流相关联的Object流
            oos = new ObjectOutputStream (os);
            //创建和源文件大小一样的byte[]
            byte[] b = new byte[is.available ( )];
            is.read (b);
            byte[] huffmanByte = huffmanZip (b);
            oos.writeObject (huffmanCodes);
            oos.writeObject (huffmanByte);


        } catch (Exception e) {

        }finally {
            try {
               oos.close ();
               os.close ();
               is.close ();
            } catch (IOException e1) {
                e1.printStackTrace ( );
            }
        }
    }

    //编写一个方法,完成对压缩文件的解压
    public static void unZipFile(String zipFile,String dstFile) {
        //定义文件输入流
        InputStream is = null;
        //定义对象输入流
        ObjectInputStream ois = null;
        //定义文件输出流
        OutputStream os = null;
        try {
            is = new FileInputStream (zipFile);
            //创建一个和is关联的对象输入流
            ois = new ObjectInputStream (is);
            os = new FileOutputStream (dstFile);

            //读取哈夫曼编码表
            Map<Byte,String> huffmanCodes = (Map<Byte, String>) ois.readObject ();
            //读取哈夫曼编码
            byte[] huffmanBytes = (byte[]) ois.readObject ( );
            //解码
            byte[] bytes = decode (huffmanCodes, huffmanBytes);
            //将bytes写入到文件
            os.write (bytes);


        } catch (Exception e) {
            System.out.println (e.getMessage () );
        }finally {

            try {
                os.close ();
                ois.close ();
                is.close ();
            } catch (IOException e) {
                e.printStackTrace ( );
            }
        }
    }
}