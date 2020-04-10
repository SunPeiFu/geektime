package com.sunpeifu.java8.dafaultAndInterface;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 作者:  daike
 * 日期:  2020/4/5
 * 描述:
 */
public class InterfaceImpl implements TestInterface {

    @Override
    public void interfaceMethod() {
        // 实现接口中的方法,并且调用接口中的默认实现方法
        interfaceDefaultMethod();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new InterfaceImpl().interfaceMethod();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> submit = executorService.submit(() -> executeThread());
        Object o = submit.get();

    }
    public static void executeThread(){
        System.out.println("thread execute");
    }

}
