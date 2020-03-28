package com.sunpeifu.geektime.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 作者:  daike
 * 日期:  2020/3/19
 * 描述:
 */
@Data
public class Order {

    private Long id;
    private Long customerId;//顾客ID
    private String customerName;//顾客姓名
    private List<OrderItem> orderItemList;
    private Double totalPrice;//总价格
    private LocalDateTime placedAt;//下单时间

}
