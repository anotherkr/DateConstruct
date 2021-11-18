package algorithm.greedyalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/** 贪心算法
 * @author yanhuanzhan
 * @date 2021/11/3 - 23:09
 */
public class Greedy {
    public static void main(String[] args) {
        //创建广播电台,放入到map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放进broadcasts
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        //加入到map
        broadcasts.put("K1",hashSet1);
        broadcasts.put("K2",hashSet2);
        broadcasts.put("K3",hashSet3);
        broadcasts.put("K4",hashSet4);
        broadcasts.put("K5",hashSet5);
        //allAreas存放所有的地区
        HashSet<Object> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        //创建ArrayList,存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();
        //定义一个临时集合，在遍历过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();
        //定义maxKey,保存在一次遍历过程中，能够覆盖最大未覆盖的地区的电台
        //如果maxKey不为null，则会加入到selects
        String maxKey = null;
        while (allAreas.size() != 0) {//=0说明覆盖到所有的地区
            //每进行一次循环需要把maxKey置空
            maxKey=null;

            //遍历broadcast，取出对应的key
            for (String key : broadcasts.keySet()) {
//                每进行一次循环需要把tempSet置空
                tempSet.clear();
                //当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);//addall是将指定集合的所有元素添加进该集合中
                //求出tempSet和allAreas集合的交集，交集会赋值给tempSet
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择结果是"+selects);
    }
}
