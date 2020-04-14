package com.sunpeifu.data_structure.reflect.annotation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/9
 * 描述:  字段映射且切面
 */
@Aspect
@Component
public class FieldMappingAspect {

    @Pointcut("@annotation(com.sunpeifu.data_structure.reflect.annotation.ReturnMapping)")
    public void mapping() {
    }


    @Before(value = "mapping()")
    public void executeBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(e -> {
            System.out.println("方法参数是: " + e);
        });
        System.out.println();
        System.out.println(joinPoint.getSignature().getName() + "方法名称是");
    }

    @AfterReturning(pointcut = "mapping()", returning = "returnValue")
    public void executeMapping(JoinPoint joinPoint, Object returnValue) throws Exception {

        // 第一优先级为集合,否则都按对象处理
        if (returnValue instanceof IPage) {
            IPage page = (IPage) returnValue;
            List list = page.getRecords();
            if (null != list && list.size() > 0)
                for (Object o : list) {
                    mappingObject(o);
                }
        } else if (returnValue instanceof Collection) {

        } else {
            Object o = (Object) returnValue;
            mappingObject(o);
        }
    }

    public void mappingObject(Object o) throws Exception {
        MappingExecutor.executeMapping(o);

    }

}
