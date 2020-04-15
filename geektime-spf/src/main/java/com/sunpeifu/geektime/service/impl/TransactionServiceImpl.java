package com.sunpeifu.geektime.service.impl;

import com.sunpeifu.geektime.entity.FlatAmount;
import com.sunpeifu.geektime.mapper.FlatAmountMapper;
import com.sunpeifu.geektime.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/30
 * 描述:
 */
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Resource
    FlatAmountMapper mapper;


    @Override
    public void methodA(String a) {
        FlatAmount flatAmount = new FlatAmount();
        flatAmount.setId(a);
        int insert = mapper.insert(flatAmount);
        this.methodB(a + 1);

    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void methodB(String b) {

        FlatAmount flatAmount = new FlatAmount();
        flatAmount.setId(b);
        mapper.insert(flatAmount);
        int a = 1 / 0;


    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void methodC(String c) {
        methodD(c + "666666");
        FlatAmount flatAmount = new FlatAmount();
        flatAmount.setId(c);
        int insert = mapper.insert(flatAmount);
        int a = 1 / 0;


    }

    // 注意 ,这个是Requireds-New  即不管是谁调用我,我都会新开一个事务
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void methodD(String c) {
        FlatAmount flatAmount = new FlatAmount();
        flatAmount.setId(c);
        int insert = mapper.insert(flatAmount);
    }


}
