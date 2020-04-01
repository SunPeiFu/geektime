package com.sunpeifu.data_structure.java8.XingWeiCanShuHua.consumer;

import com.sunpeifu.data_structure.bean.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/29
 * 描述:  Consumer ,接收一个T,并且无返回
 */
public class ConsumerDemo {
    public static void main(String[] args) {

        foreach(Arrays.asList(1, 5, 3, 6),
                (Integer i) -> System.out.println());

    }

    //
    // 接收两个参数 ,前者list 后者为consumer 其accpet方法只接收参数 没有返回 void
    public static <T> void foreach(List<T> list, Consumer<T> c) {
        ArrayList<Product> list1 = new ArrayList<>();


    }
}
