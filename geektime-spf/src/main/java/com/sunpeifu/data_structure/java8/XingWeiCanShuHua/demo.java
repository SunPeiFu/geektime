package com.sunpeifu.data_structure.java8.XingWeiCanShuHua;

import com.sunpeifu.data_structure.bean.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者:  daike
 * 日期:  2020/3/29
 * 描述:
 */
public class demo {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        Product p1= new Product();
        p1.setProductName("商品1");
        p1.setProductPrice(new BigDecimal("50"));

        Product p2= new Product();
        p2.setProductName("商品2");
        p2.setProductPrice(new BigDecimal("100"));


        Product p3= new Product();
        p3.setProductName("商品3");
        p3.setProductPrice(new BigDecimal("150"));
        list.add(p1);
        list.add(p2);
        list.add(p3);
        // 使用实现类的方式
        List<Product> result = getProductListByPrecate(list, new ProductPricePrecate());
        System.out.println(result);

        // 使用匿名内部类的凡是,此种方式和上面一样,代码也是啰嗦冗余
        getProductListByPrecate(list, new ProductPredicate<Product>() {
            @Override
            public boolean test(Product product) {
                return product.getProductPrice().compareTo(new BigDecimal("100")) > 0;
            }
        });



        // ==  > 上面两种 代码都比较冗余 啰嗦,使用lambda的方式,代码明显简介了不少
        List<Product> lambda = getProductListByPrecate(list, (Product p) -> p.getProductPrice().compareTo(new BigDecimal("100")) > 0);
        System.out.println(lambda);

        Runnable r1 =() -> System.out.println();
        new Runnable() {
            @Override
            public void run() {

            }
        };

    }

    public  static List<Product> getProductListByPrecate1(List<Product> list, ProductPredicate<Product> p) {
        List<Product> result = new ArrayList<>();
        for (Product product : list) {
            if (p.test(product)) {
                result.add(product);
            }
        }
        return result;
    }

    // 上面的getProductListByPrecate在继续抽象
    public static <T> List<T> getProductListByPrecate(List<T> list, ProductPredicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : result) {
            if (p.test(t)) {
                result.add(t);
            }

        }
        return result;
    }
}
