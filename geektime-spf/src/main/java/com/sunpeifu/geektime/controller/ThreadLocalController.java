package com.sunpeifu.geektime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/11
 * 描述:
 */
@RestController
public class ThreadLocalController {

    // 定义类成员属性线程本地变量,考虑到spring默认为单列
    private ThreadLocal<Integer> current= ThreadLocal.withInitial(()->null);


    @GetMapping("testThreadLocal")
    public Object wrong(@RequestParam("userId") Integer userId){

        // 获取之前线程中的value
        String before = Thread.currentThread().getName()+":"+ current.get();
        // 设置传入的值
        current.set(userId);
        // 获取设置之后的值
        String after = Thread.currentThread().getName()+":"+ current.get();
        Map map = new HashMap<>();
        map.put("before", before);
        map.put("after", after);
        return map;
        // 第一次尝试,设置tomcat最大线程为1
        // 此时的结果为{"before":"http-nio-8080-exec-1:null","after":"http-nio-8080-exec-1:666"}  线程号固定为1
        // 当我们在来请求一次,用其他人的用户id,结果就是{"before":"http-nio-8080-exec-1:666","after":"http-nio-8080-exec-1:888"}  出现了别人的id
        // 造成这种的原因是,我们的web程序运行在tomcat上,使用的是tomcat的线程,此时我们的最大线程数设置成了1,所以一直用的一个线程处理请求,所以就会有这个问题,得到的before是null而不是666
        // 修改如下即可
    }
    @GetMapping("testThreadLocal")
    public Object right(@RequestParam("userId") Integer userId){
        // 获取之前线程中的value
        String before = Thread.currentThread().getName()+":"+ current.get();
        // 设置传入的值
        current.set(userId);
        // 获取设置之后的值
        String after = Thread.currentThread().getName()+":"+ current.get();
        Map map = new HashMap<>();
        map.put("before", before);
        map.put("after", after);
        return map;
    }

    public static void main(String[] args) {
        String a = "123Y456";
        int y = a.indexOf("Y");
        System.out.println(a.substring(0,y));
    }
}
