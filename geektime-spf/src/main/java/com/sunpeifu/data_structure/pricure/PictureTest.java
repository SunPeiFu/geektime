package com.sunpeifu.data_structure.pricure;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.LongAdder;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/21
 * 描述:  图数据结构测试,使用广度优先算法
 */
public class PictureTest {

    public static void main(String[] args) {
        // 用最快的方式找出我的朋友中名字叫 麻瓜的人


        // 定义查找的数据,key为人名,value为这个人的朋友
        HashMap<String, List<String>> map = new HashMap<>();
        // 第一维度的数据
        // 小明的朋友
        ArrayList xiaomingPeople = new ArrayList<>();
        xiaomingPeople.add("小红");
        xiaomingPeople.add("小蓝");
        xiaomingPeople.add("小绿");

        // 大鹏的朋友
        ArrayList dapengPeople = new ArrayList<>();
        dapengPeople.add("大A");
        dapengPeople.add("小B");
        dapengPeople.add("小C");

        // 我的朋友
        ArrayList myPeople = new ArrayList<>();
        myPeople.add("小明");
        myPeople.add("大鹏");


        // 第二维度的数据
        ArrayList xiaohongPeople = new ArrayList<>();
        myPeople.add("小红123");
        myPeople.add("小红456");

        // 存储数据第一维度
        map.put("小明", xiaomingPeople);
        map.put("大鹏", dapengPeople);
        // 存储数据第二维度
        map.put("小红",xiaohongPeople);


        Queue<List<String>> queue = new LinkedBlockingDeque<>();

        // 需求找出我身边人的名字叫 小红123 的人,先从我最近的朋友开始找,如果没有的话,在从我我最近的朋友的朋友中开始找,往后延伸
        // 把数据都加入到队列中, FIFO 先加入一维数据,在加入二维数据,以此类推
        queue.add(xiaomingPeople);
        queue.add(dapengPeople);
        // 上述两个List都是一维的,都是我的直接朋友,下面加入
        LongAdder count = new LongAdder();

        // 验证是否重复的集合
        Set<String> set = new HashSet<>();

        while(!queue.isEmpty()){

            // 弹出队列是个元素
            List<String> list = queue.poll();
            for (String s : list) {
                // 如果当前这个人之前已经查找过了,则跳过,进行下一次
                if (set.contains(s)){
                    continue;
                }
                // 如果验证过当前这个人,则无需进行重复验证
                if (s.equals("小红123")){
                    System.out.println("find success");
                    count.add(1);
                    break;
                } else {
                    // 此时注意,因为是队列,我们的一维数据已经初始化好了,进入这里添加的已经是二维的数据了
                    // 没有找到对应的人,在队列尾部追加当前这个人的朋友
                    queue.add(map.get(s) != null? map.get(s) : new ArrayList());
                    set.add(s);
                    count.add(1);

                }
            }
        }
        System.out.println(count.intValue()); // 结果为6 第6次的时候找到了

        // TODO  如何把Map<key List<String>> 映射成自动的关系, 而不是我们手动知道  小明 -> 对应三个朋友的名字这种



    }
}