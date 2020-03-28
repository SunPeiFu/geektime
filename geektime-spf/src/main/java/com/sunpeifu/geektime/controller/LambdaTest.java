package com.sunpeifu.geektime.controller;

import com.sunpeifu.geektime.entity.Order;
import com.sunpeifu.geektime.entity.OrderItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 作者:  daike
 * 日期:  2020/3/19
 * 描述:
 */
public class LambdaTest {

    public static void main(String[] args) {

        // 初始化两个商品
        OrderItem item = new OrderItem();
        item.setProductId(1L);
        item.setProductName("商品A");
        item.setProductPrice(2.0);
        item.setProductQuantity(10);

        OrderItem item2 = new OrderItem();
        item2.setProductId(2L);
        item2.setProductName("商品B");
        item2.setProductPrice(2.0);
        item2.setProductQuantity(20);

        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(item);
        orderItems.add(item2);

        Order order1 = new Order();
        order1.setId(1L);
        order1.setCustomerId(66L);
        order1.setCustomerName("客户A");
        order1.setPlacedAt(LocalDateTime.now());
        order1.setOrderItemList(orderItems);
        order1.setTotalPrice(60.00);

        Order order2 = new Order();
        order2.setId(2L);
        order2.setCustomerId(88L);
        order2.setCustomerName("客户B");
        order2.setPlacedAt(LocalDateTime.now());
        order2.setOrderItemList(orderItems);
        order2.setTotalPrice(100.00);


        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order1);
        orderList.add(order2);


        //最近半年的金额大于40的订单

        // 有筛选条件,使用过滤函数filter
        List<Order> collect = orderList.stream()
                // 首先过滤空值
                .filter(Objects::nonNull)
                // 最近半年
                .filter(order -> order.getPlacedAt().isAfter(LocalDateTime.now().minusMonths(6)))
                // 过滤金额> 40
                .filter(order -> order.getTotalPrice() > 40)
                .collect(toList());

        // 计算所有商品的数量
        LongAdder longAdder = new LongAdder();
        orderList.stream().forEach(order -> order.getOrderItemList().forEach(orderItem -> longAdder.add(orderItem.getProductQuantity())));
        System.out.println("商品数量:" + longAdder);

        // 同上,不定义额外变量来进行处理
        LongStream longStream = Optional.of(orderList).get()
                // 想要统计先转成流
                .stream()
                // 获取每一个订单中的商品集合
                .mapToLong(order -> order.getOrderItemList().stream()
                        // 统计每一个商品的数量,最后求和
                        .mapToLong(OrderItem::getProductQuantity).sum());
        System.out.println("商品数量:" + longStream.sum());


        // 计算该笔订单的总价格
        double sum = orderList.stream()
                // List流化后,flat+map 相当于平铺展开,无需再次遍历,注意此行末尾 .stream(),实在flatMap()这个括号里,即平铺展开了每一个
                .flatMap(order -> order.getOrderItemList().stream())
                // 获取每一个订单的价格,进行求和
                .mapToDouble(orderItem -> orderItem.getProductPrice() * orderItem.getProductQuantity()).sum();
        System.out.println("商品的总价为:" + sum);

        // 计算订单总价,使用定义的变量
        DoubleAdder doubleAdder = new DoubleAdder();
        orderList.stream().filter(Objects::nonNull)
                .forEach(order -> order.getOrderItemList()
                        .forEach(orderItem -> doubleAdder.add(orderItem.getProductQuantity() * orderItem.getProductPrice())));
        System.out.println("商品的总价为:" + doubleAdder.sum());


        // 找出大于 50 元订单的按价格倒序取前 5，可以通过
        List<Order> collect1 = orderList.stream()
                .filter(Objects::nonNull)
                .filter(order -> order.getTotalPrice() > 50)
                // comparator比较默认是Asc,所以需要倒过来
                .sorted(Comparator.comparing(Order::getTotalPrice).reversed())
                // 取前5条
                .limit(5)
                // 转化为集合
                .collect(Collectors.toList());
        System.out.println(collect1.size());

        // 找出订单中重复下单的用户
        // 去重distinct,这里需要注意,如果不指定属性,是默认使用的Object 的equals和hashcode的方法
        String joining = orderList.stream()
                .map(order -> order.getCustomerName())
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println(joining);

        // 查询A用户购买过的商品名称(productName不能重复)
        String customerName = "客户A";
        String result = orderList.stream()
                .filter(Objects::nonNull)
                .filter(order -> customerName.equals(order.getCustomerName()))
                // 把orderList平铺展开,flatMap接收的是一个Stream流
                .flatMap(order -> order.getOrderItemList().stream())
                // 映射寻找的属性
                // map为映射元素,可以理解为sql中的 sql,并且可以把一种类型转换为另外一种类型
                .map(orderItem -> orderItem.getProductName()).distinct()
                .collect(Collectors.joining(","));
        System.out.println("去重的商品名称是" + result);

        // 按照下单时间排序，查询前 2 个订单的顾客姓名和下单时间；
        List<String> collect2 = orderList.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(order -> order.getPlacedAt()))
                .limit(2)
                // 使用map作为映射,一次只能映射出一种属性, 如果一个对象里有多个属性,则必须转换为同一种属性,如下映射成String
                .map(order -> order.getCustomerName() + order.getPlacedAt())
                // 最后收集
                .collect(Collectors.toList());
        collect2.forEach(
                System.out::print
        );

        // 按照下单时间排序，查询第 3 和第 4 个订单的顾客姓名和下单时间。
        List<String> collect3 = orderList.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(order -> order.getPlacedAt()))
                // skip2 即跳过了 0 1索引的值
                .skip(2)
                // 从索引2位startIndex, 往后面+2 即limit2 即为3 4号元素
                .limit(2)
                // 使用map作为映射,一次只能映射出一种属性, 如果一个对象里有多个属性,则必须转换为同一种属性,如下映射成String
                .map(order -> order.getCustomerName() + order.getPlacedAt())
                // 最后收集
                .collect(Collectors.toList());

        // 找出所有下单的用户名,不能重复
        String joinString = orderList.stream()
                .map(order -> order.getCustomerName()).distinct()
                .collect(Collectors.toSet())
                // collect是最后进行终结操作,collect之后就不能再进行filter,map,flatMap等操作,如果想要继续,则需要继续转换成流
                .stream()
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinString);

        // 把上述操作结果转换这其他类型
        HashSet<String> collect4 = orderList.stream()
                .map(order -> order.getCustomerName()).distinct()
                .collect(Collectors.toSet())
                // collect是最后进行终结操作,collect之后就不能再进行filter,map,flatMap等操作,如果想要继续,则需要继续转换成流
                .stream()
                .collect(toCollection(HashSet::new));
        System.out.println("转成HashMap" + collect4);

        // 按照id进行分组
        Map<Long, List<Order>> collect5 = orderList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(order -> order.getId()));
        System.out.println("=====");
        collect5.entrySet().stream().forEach(System.out::println);
        System.out.println("=====");
        for (Map.Entry<Long, List<Order>> entry : collect5.entrySet()) {
            System.out.println(entry);
        }
        // 将结果转换成map key为订单id  value 为下单用户名
        orderList.stream()
                .collect(toMap(Order::getId, Order::getCustomerName)).entrySet().forEach(System.out::println);

        // 获取下单用户名+最近一次下单时间的Map
        Optional<String> first = orderList.stream()
                .sorted(Comparator.comparing(Order::getPlacedAt).reversed())
                .map(order -> order.getCustomerName() + "时间是:" + order.getPlacedAt())
                .findFirst();
        System.out.println(first.isPresent()); // isNotEmpty的意思  true 不为空
        System.out.println(first.get());

        // 同上,使用另一种方式
        Map<String, LocalDateTime> map =
                orderList.stream()
                        .collect(toMap(Order::getCustomerName, Order::getPlacedAt, (x, y) -> x.isAfter(y) ? x : y));

        // 订单平均购买的商品数量
        Double collect6 = orderList.stream()
                // 先从外层进行收集
                .collect(averagingInt(order -> order.getOrderItemList().stream()
                        // 收集一笔订单中商品的数量
                        .collect(summingInt(OrderItem::getProductQuantity))));
        System.out.println(collect6);

        //按照用户名分组，使用 Collectors.counting 方法统计每个人的下单数量，再按照下单数量倒序输出。

        // 先按照用户名进行分组
        List<Map.Entry<String, Long>> collect8 = orderList.stream()
                .collect(groupingBy(Order::getCustomerName, counting()))
                // 转成map后再次流化
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(toList());

        // 按照姓名分组,之后统计订单金额,在按照统计金额倒序排列
        List<Map.Entry<String, Double>> collect7 = orderList.stream()
                .collect(groupingBy(Order::getCustomerName, summingDouble(Order::getTotalPrice)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(toList());

        // 按照名称分组,统计每个人采购的商品的数量
        orderList.stream()
                // 进行分组,key为用户名,value为商品的数量
                .collect(groupingBy(Order::getCustomerName,
                        // 第一次sum,为每个人订单的数量
                        summingInt(order -> order.getOrderItemList().stream()
                                // 第二次sum,为每个商品的数量,两次求和
                                .collect(summingInt(orderItem -> orderItem.getProductQuantity())))))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(toList());

        // 统计被采购最多的商品

        //根据下单年月分组，统计订单ID列表
        Map<String, List<Long>> collect9 = orderList.stream()
                .collect(
                        groupingBy(order -> order.getPlacedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                                mapping(order -> order.getId(), toList())));

        //根据下单年月+用户名两次分组，统计订单ID列表
        Map<String, Map<String, List<Long>>> collect10 = orderList.stream()
                // 第一次分组的条件,为日期
                .collect(groupingBy(order -> order.getPlacedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        // 第二次分组的条件为订单,id,value为一个集合
                        , groupingBy(order -> order.getCustomerName()
                                , mapping(order -> order.getId(), toList()))
                )); // 最终则转换为map套map的结构

        // partitioningBy 分组,分组的条件是一个boolean类型,只会存在两种情况true false

        Map<Boolean, List<Order>> collect11 = orderList.stream()
                .collect(Collectors.partitioningBy(order -> order.getId().equals("123")));

        List<String> list = Arrays.asList("a1","a2","a3");
        System.out.println("<======>");
        list.stream().map(s->s+"test").forEach(System.out::println);//一对一的处理，在每个字符串后面加上test输出
        System.out.println("<======>");
        list.stream().map(s->s.split("")).forEach(System.out::println);
        System.out.println("<======>");
        list.stream().flatMap(s -> Stream.of(s.split(""))).forEach(System.out::println);//一对多的处理，把每个字符串拆成一个个字符，输出，这点map就无法做到。
        System.out.println("<======>");

    }
}
