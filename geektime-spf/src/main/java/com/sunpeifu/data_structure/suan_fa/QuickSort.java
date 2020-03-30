package com.sunpeifu.data_structure.suan_fa;

/**
 * 作者:  daike
 * 日期:  2020/3/28
 * 描述:
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] arr = {4,6,3,1};
        quickSortInternally(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println();
        }
    }

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {

    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r)
            return;
        // 获取分区点
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        // 选择最后一个元素
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println("i=" + i);
        return i;
    }
}
