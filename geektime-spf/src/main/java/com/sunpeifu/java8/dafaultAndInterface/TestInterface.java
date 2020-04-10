package com.sunpeifu.java8.dafaultAndInterface;
// 测试接口
public interface TestInterface {

    void interfaceMethod();

    public static void thisIsInterfaceStatisMethod() {
        System.out.println("this is interface static method");
    }

    default void interfaceDefaultMethod(){
        System.out.println("his is interface default method");
    }
}
