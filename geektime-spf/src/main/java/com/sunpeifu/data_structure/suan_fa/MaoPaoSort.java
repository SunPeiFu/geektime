package com.sunpeifu.data_structure.suan_fa;

/**
 * 作者:  daike
 * 日期:  2020/3/28
 * 描述:
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 5, 13, 9, 6, 11};
        //maoPaoSort(arr);
        maoPaoSortYouHua(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void maoPaoSortYouHua(int[] arr){
        // 从大到小排序

        // 定义外层循环,注意这里从1开始,为什么循环length-1次就可以了即 一共有5个元素,4次就可以了
        // 因为第四次的时候,4个元素已经排好了,第五个已经不用再排序了
        for (int i = 1; i < arr.length - 1; i++) {
           // 这里注意 j <= 是arr.length-i 为什么是这样的,因为每次外层循环一轮,最后一个元素就已经确定了,所以是length-i
            // 注意是i 不是 111
            for (int j = 0; j < arr.length -i ; j++) {
                // 冒泡排序,每次只比较相邻的两个元素
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }

            }

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
