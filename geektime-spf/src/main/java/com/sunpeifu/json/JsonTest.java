package com.sunpeifu.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunpeifu.data_structure.bean.Product;
import com.sunpeifu.geektime.entity.Order;
import com.sunpeifu.geektime.entity.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * 作者:  daike
 * 日期:  2020/4/9
 * 描述:
 */
public class JsonTest {

    public static void main(String[] args) throws JsonProcessingException {
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

        ArrayList<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(item);
        orderItems.add(item2);

        Order order1 = new Order();
        order1.setId(1L);
        order1.setCustomerId(66L);
        order1.setCustomerName("客户A");
        order1.setPlacedAt(LocalDateTime.now());
        order1.setOrderItemList(orderItems);
        order1.setTotalPrice(60.00);
        order1.setOrderItemList(orderItems);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(order1);
        System.out.println(jsonStr);
        //
        //
        //
    }
}
