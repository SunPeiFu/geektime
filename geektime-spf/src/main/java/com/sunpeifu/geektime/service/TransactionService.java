package com.sunpeifu.geektime.service;

import org.springframework.context.annotation.Primary;

/**
 * 作者:  daike
 * 日期:  2020/3/30
 * 描述:
 */
@Primary
public interface TransactionService {

    void methodA(String a);

    void methodB(String b);

    void methodC(String c);

    void methodD(String c);

}
