package com.sunpeifu.geektime.entity;

import lombok.Data;

/**
 * 作者:  daike
 * 日期:  2020/3/19
 * 描述:
 */
@Data
public class OrderItem {

    private Long productId;//商品ID
    private String productName;//商品名称
    private Double productPrice;//商品价格
    private Integer productQuantity;//商品数量
}
