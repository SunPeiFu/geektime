package com.sunpeifu.demo.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 作者:  daike
 * 日期:  2020/3/25
 * 描述:
 */
@Data
public class Item {

    private String id;

    private BigDecimal productPrice;

    private String productName;

    private Boolean isDeleted;
}
