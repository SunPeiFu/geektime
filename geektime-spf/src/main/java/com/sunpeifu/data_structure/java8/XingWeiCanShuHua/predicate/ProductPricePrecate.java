package com.sunpeifu.data_structure.java8.XingWeiCanShuHua.predicate;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/29
 * 描述:  具体参数化的接口,实现具体行为方法
 */
public class ProductPricePrecate<T> implements ProductPredicate<T> {
    @Override
    public boolean test(T t) {
        return false;
    }
}
