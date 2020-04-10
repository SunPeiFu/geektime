package com.sunpeifu.geektime.Lambda;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/1
 * 描述:  流相关
 */
public class StreamTest {
    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(4);
//        list.add(10);
//        minBy(list);
        joining();
    }

    // 区间包括首尾
    public static void testRangClosed(int n) {
        IntStream.rangeClosed(1, n).forEach(System.out::println);
    }

    // 区间包括首,不包尾
    public static void testRang(int n) {
        IntStream.range(1, n).forEach(System.out::println);
    }

    public static void wuXianStream() {
        List<Integer> collect = Stream.iterate(1, x -> ++x).limit(10).collect(Collectors.toList());

    }

    // 求最大值,第一种会有装箱拆箱的开销,推荐第二种写法,会返回一个Optional对象
    public static void maxBy(List<Integer> list) {
        Integer max = list.stream().collect(Collectors.maxBy(Comparator.comparing(Integer::intValue))).get();
        int asInt = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println(max);
        System.out.println(asInt);
    }

    public static void minBy(List<Integer> list) {
        Integer minBy = list.stream().collect(Collectors.minBy(Comparator.comparing(Integer::intValue))).get();
        OptionalInt optionalInt = list.stream().mapToInt(Integer::intValue).min();
        System.out.println(minBy);
        System.out.println(optionalInt.getAsInt());
    }

    // 第一种和第二种的方法区别在于 后者返回的Int的流,里面有各种求值api
    public static void sum (List<Integer> list) {
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(Integer::intValue).summaryStatistics();
        long sum1 = intSummaryStatistics.getSum();
    }

    public static void joining() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("ok");
        String collect1 = list.stream().collect(Collectors.joining());
        String collect2 = list.stream().collect(Collectors.joining(","));
        String collect3 = list.stream().collect(Collectors.joining(",", "[", "]"));

        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println(collect3);
        /***
         * helloworldok
           hello,world,ok
           [hello,world,ok]
         */
    }
    public static void testMap(){
        HashMap map = new HashMap<>();
        map.put("c", 3);
        map.put("a", 1);
        map.put("b", 2);
        map.put("d",10);


    }
}
