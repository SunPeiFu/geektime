package com.sunpeifu.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/19
 * 描述:  es中的实体
 */
@Data
// indexName 索引库名   type 即库中表名
@Document(indexName = "item" ,type= "docs")
public class OrderItem {
    @Id
    private Long productId;//商品ID

    @Field(type = FieldType.Keyword)
    private String productName;//商品名称

    @Field(type =FieldType.Double)
    private Double productPrice;//商品价格

    @Field(type=FieldType.Integer)
    private Integer productQuantity;//商品数量

    @Field(type = FieldType.Text)
    private String msg; // 商品描述

}
