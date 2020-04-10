package com.sunpeifu.data_structure.suan_fa;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/4
 * 描述:
 */
public class QuickSort1 {

    private static int[] arr = {4, 6, 3, 1};
    public static void main(String[] args) {

        quickSortInternally( 0, arr.length - 1);
        for (int i : arr) {
            System.out.println();
        }
    }

    private static void quickSortInternally(int left, int right) {
        // temp 即为基准元素
        int temp = arr[left];
        int i = left;
        int j = right;
        int a ;
        if (left > right) {
            System.out.println("不满足条件 return ");
        }
        // 从右边开始往左,索引j元素的value都大于temp,

        // 从左开始往右,索引i对应的元素value都小于temp

        // 循环开始,因为j-- i++索引只要 i != j 就一直循环
        while (i != j ) {
            // j需要先开始,因为只要>临时基准位,就需要-- 当且仅仅i<j的时候

            while (arr[j] >= temp && i < j) {
                j--;
            }

            // 同理 i 从左往右走
            while (arr[i] <= temp && i < j) {
                i++;
            }

            // 当两个数没有相遇的时候,交换元素之间的位置

            if (i < j) {
                a = arr[i];
                arr[i] = arr[j];

                arr[j] = a;
            }

        }
        // 当第一轮循环结束 代表i 和 j已经相遇,此时i = j 所以和基准位置互换
        // 交换和基准位的位置
        arr[left] = arr[i];
        arr[i] = temp ;

        // 这样,基准位已经复位,现在我们只需要按照同样的办法,整理基准为左边和右边的数组即可
        // 排序左边的
        quickSortInternally(left,i-1);
        // 排序右边的
        quickSortInternally(i+1,right);
        return;
    }
}
