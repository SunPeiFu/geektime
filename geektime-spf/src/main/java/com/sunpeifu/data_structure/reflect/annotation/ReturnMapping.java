package com.sunpeifu.data_structure.reflect.annotation;
/**
 * @author sunpeifu
 * @since  2020/3/16
 */
public @interface ReturnMapping {

    /***
     * 是否需要映射
     */
    boolean isNeed() default true;
}
