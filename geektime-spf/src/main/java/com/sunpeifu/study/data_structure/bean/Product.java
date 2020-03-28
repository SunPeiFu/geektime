package com.sunpeifu.demo.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 作者:  daike
 * 日期:  2020/3/14
 * 描述:
 */
@Data
public class Product {

    private BigDecimal productPrice;

    private String productName;

    private Boolean isDeleted;

    // 子商品数量
    private List<Integer> childProductCount;

//    private void setMoreParam(String productName , BigDecimal productPrice){
//        System.out.println("方法执行成功:" + productName + " 价格是: " + productPrice);
//    }

    private void setData(String productName , Boolean isDeleted){
        System.out.println("方法执行成功:" + productName + " 是否删除: " + isDeleted);

    }

}
