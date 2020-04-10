package com.sunpeifu.data_structure.java8.XingWeiCanShuHua.predicate;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/29
 * 描述:
 */
public interface ProductPredicate<T> {

    // 行为参数化接口
    boolean test(T t);
}
