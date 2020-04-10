package com.sunpeifu.geektime.Lambda.design.strategy;


import com.sunpeifu.data_structure.bean.Product;

import java.util.Optional;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/2
 * 描述:  lambda策略上下文
 */
// 具体策略传入T
public class LambdaStategy<T> implements Strategy<T> {


    private Strategy<T> strategy;

    public LambdaStategy(Strategy<T> strategy) {
        this.strategy = strategy;
    }


    @Override
    public boolean isApply(T t) {
        return false;
    }


    public static void main(String[] args) {
        Product product = new Product();
        product.setProductName("456");
        Optional.of(product).ifPresent(e -> testStrategyLambda(product));
    }

    public static boolean testStrategyLambda(Product product) {

        // 此时构造传入的是具体的策略判断方法,第一种写法,比较好理解,每个策略有每一个策略的判断
        LambdaStategy<Product> productLambdaStategy = new LambdaStategy<>((Product p) -> p.getProductName().equals("123"));
        boolean result1 = productLambdaStategy.isApply(product);

        // 级联点调用
        // 此时  (product -> p.getProductName().equals("123"))  即为构造方法的条件,因为构造里传入的是functionStrategy,里面的方法就是根据入参T 返回boolean
//        boolean result2 = new LambdaStategy<Product>(product -> p.getProductName().equals("123")).isApply(p);
//        System.out.println(result1);
//        System.out.println(result2);
        return result1;

    }


}
