package com.sunpeifu.data_structure.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/5
 * 描述:  List切割工具
 */
public class ListUtil {

    public static List<List<?>> subListByLen(List<?> sourceList, int len) {
        if (null == sourceList || sourceList.size() == 0) {
            return null;
        }
        ArrayList<List<?>> resultList = new ArrayList<>();
        // 原始集合的长度
        int size = sourceList.size();
        // 分多少组
        int groupCount = (size) / (len - 1);
        for (int i = 0; i < groupCount; i++) {
            // subList方法需要fromIndex 和 toIndex
            // 注意三元表达式的判断,如果大于了集合长度,则toIndex就是size
            List<?> tempList = sourceList.subList(i * len, (i + 1) * len > size ? size : (i + 1) * len);
            resultList.add(tempList);
        }


        return resultList;

    }

    public static void main(String[] args) {


    }

    public static void testSubList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            list.add(i);
        }
        List<List<?>> lists = subListByLen(list, 10);
        System.out.println("结果list的长度:" + lists.size());
    }
}
