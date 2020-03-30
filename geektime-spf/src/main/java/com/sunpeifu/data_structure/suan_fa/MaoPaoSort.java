package com.sunpeifu.data_structure.suan_fa;

/**
 * 作者:  daike
 * 日期:  2020/3/28
 * 描述:
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 5, 13, 9, 3, 6, 11};
        maoPaoSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void maoPaoSort(int[] arr) {

        // 先外层遍历,外层控制轮次
        for (int i = 0; i < arr.length-1; i++) {
            // 内层控制次数,每次递加两个两个比对
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // 按照从小到大的顺序排序
                    int temp = arr[j];

                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp;


                }

            }

        }

    }
}
