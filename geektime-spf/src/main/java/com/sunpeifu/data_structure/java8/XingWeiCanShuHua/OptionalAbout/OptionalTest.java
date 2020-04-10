package com.sunpeifu.data_structure.java8.XingWeiCanShuHua.OptionalAbout;

import com.sunpeifu.data_structure.bean.Product;

import java.util.Optional;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/1
 * 描述:
 */
public class OptionalTest {
    public static void main(String[] args) {
        Product product = new Product();
        product.setProductName("商品1");
        // Optional.of 会直接报错 如果是空
        Optional<Product> product2 = Optional.ofNullable(product);
        // Optional.ofNullable可以接受空值
        Optional.ofNullable(product).ifPresent((e)-> System.out.println(e.getProductName()));
        // 如果为空,可以返回一个默认值
        Product product3 = Optional.ofNullable(product).orElseGet(Product::new);


    }
}
