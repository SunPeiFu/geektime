package com.sunpeifu.data_structure.suan_fa;

/**
 * 作者:  daike
 * 日期:  2020/3/28
 * 描述:  桶排序
 */
public class TongSort {
    public static void main(String[] args) {
        int[] arr = {7,3,5,1,2,8,8,7,9,3};
        tongSort(arr);
    }

    public static void tongSort(int[] arr) {
        // 初始化桶,代表分数的集合
        int [] buckets = new int[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = 0;
        }
        // 传入的arr即为薛恒的  分数集合

        for (int i = 0; i < arr.length; i++) {
          // 需要在遍历分数的数组,如果分数在木桶中,则数值加1
                // 学生的分数
                int fen = arr[i];
                // 分数桶
                //buckets[fen]
                buckets[fen]++;


        }
        for (int i = 0; i < buckets.length; i++) {
            System.out.println(buckets[i]);

        }
    }
}
