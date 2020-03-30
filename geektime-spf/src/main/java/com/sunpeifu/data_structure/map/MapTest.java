package com.sunpeifu.data_structure.map;

import com.sunpeifu.data_structure.bean.Product;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 作者:  daike
 * 日期:  2020/3/21
 * 描述:  Map结构测试
 */
public class MapTest {

    public static void main(String[] args) {
        HashMap<String, Product> map = new HashMap<>();

        Product p1= new Product();
        p1.setProductName("商品1");

        Product p2= new Product();
        p2.setProductName("商品2");

        Product p3= new Product();
        p3.setProductName("商品3");

        map.put(p1.getProductName(), p1);
        map.put(p2.getProductName(), p2);
        map.put(p3.getProductName(), p3);

//        for (String key : map.keySet()) {
//            if (key.equals(map.get(key).getProductName())){
//                map.remove(key);
//            }
//        }
        // Exception in thread "main" java.util.ConcurrentModificationException 会报错
        // 使用如下方式则不会
        Iterator<Map.Entry<String, Product>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Product> entry = it.next();
            if (entry.getKey().equals("商品2")){
                map.remove(entry.getKey());
            }
        }
        System.out.println(map);

    }
}
