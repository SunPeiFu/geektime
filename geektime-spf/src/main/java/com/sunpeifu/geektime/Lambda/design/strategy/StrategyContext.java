package com.sunpeifu.geektime.Lambda.design.strategy;

/**
 * 作者:  daike
 * 日期:  2020/4/3
 * 描述:
 */
public class StrategyContext<T> {

    private Strategy<T> strategy;

    public StrategyContext(Strategy<T> strategy){
        this.strategy = strategy;
    }

    public static void main(String[] args) {
    }

}
