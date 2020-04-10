package com.sunpeifu.geektime.Lambda.design.strategy;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/2
 * 描述:
 */
public interface Strategy<T> {

   boolean isApply(T t);
}
