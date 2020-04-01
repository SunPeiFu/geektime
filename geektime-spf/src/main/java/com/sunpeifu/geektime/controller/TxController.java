package com.sunpeifu.geektime.controller;

import com.sunpeifu.geektime.service.TransactionService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/30
 * 描述:  SpringBoot事务测试
 */
@RestController
public class TxController {

    @Resource
    TransactionService service;

    @RequestMapping("testTx")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void verifyAmount(@RequestParam("type") String type) {
        if ("1".equals(type)) {
            service.methodA(type);
        } else {
            service.methodC(type);
        }
    }
}
