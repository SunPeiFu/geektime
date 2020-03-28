package com.sunpeifu.study.data_structure.list;

import com.sunpeifu.demo.bean.Product;

import java.util.ArrayList;

/**
 * 作者:  daike
 * 日期:  2020/3/21
 * 描述:
 */
public class ListTest {
    public static void main(String[] args) {
            ArrayList<Product> list = new ArrayList<>();
            Product p1= new Product();
            p1.setProductName("商品1");

            Product p2= new Product();
            p2.setProductName("商品2");

            Product p3= new Product();
            p3.setProductName("商品3");

            list.add(p1);
            list.add(p2);
            list.add(p3);

//            list.forEach(e->{
//                if (e.getProductName().equals("商品2")){
//                    list.remove(e);
//                }
//            });
            // 上述这种lambda方式会报空指针,因为这个紫色list根本没有被定义,是空的

        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).getProductName().equals("商品2")){
                list.remove(list.get(i));
                //list.remove(i);
                System.out.println("remove success");
            }
        }
        // 这种方式是可以remove掉的,不会出现for Map remove ConcurrentModificationException异常

        System.out.println(list);


    }
}
