package com.sunpeifu.geektime.Lambda.design.template;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 作者:  daike
 * 日期:  2020/4/3
 * 描述:
 */
public abstract class AbstractTemplate<T> {

    @Autowired
    BaseMapper<T> mapper;

    // 抽象方法
    public void getObjectById(String id){
        T t = mapper.selectById(id);
        execute(t);
    }

    abstract void execute(T t);
}
