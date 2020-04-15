package com.sunpeifu.es.entity.controller;

import com.sunpeifu.es.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/14
 * 描述:
 */
public class EsController {

    private ElasticsearchTemplate elasticsearchTemplate;


    @RequestMapping("testEs")
    public void testEs(){
        // 使用模板,创建索引对象
        boolean index = elasticsearchTemplate.createIndex(OrderItem.class);

    }
}
