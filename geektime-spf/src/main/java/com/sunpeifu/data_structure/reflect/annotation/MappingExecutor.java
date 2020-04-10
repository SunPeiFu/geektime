package com.sunpeifu.data_structure.reflect.annotation;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/10
 * 描述:
 */
@Component
public class MappingExecutor implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void executeMapping(Object source) throws Exception {
        execute(source);
    }

    public static void execute(Object source) throws Exception {

        // 存储映射的键值
        Map<String, Object> map = new HashMap<>();
        if (null != source) {
            Class<?> clazz = source.getClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                // 打开访问权限
                declaredField.setAccessible(true);

                MappingCondition mappingCondition = declaredField.getAnnotation(MappingCondition.class);
                if (null != mappingCondition) {
                    // key 为columName value 为对应字段的存储至
                    String fieldName = declaredField.getName();
                    Object FieldValue = declaredField.get(source);
                    map.put(fieldName, FieldValue);
                }
                MappingField annotation = declaredField.getAnnotation(MappingField.class);
                if (null == annotation) {
                    continue;
                }
                // TODO 如何拿到xxMapper中的实体
                // TODO xxMapper中加一个接口,给一个默认实现,这里调用一个默认方法,只查一个字段
                Class<?> mapperClazz = annotation.mapperClass();
                // 获取关联条件id的值
                String targetField = annotation.targetMappingField();
                // 数据库关联的colum
                String condition = annotation.targetMappingFieldValue();
                // 对应colum的value
                Object conditonValue = map.get(targetField);

                String colums = annotation.targetColumnName();

                // 获取Mapper对应的bean强转
//                BaseMapper baseMapper = (BaseMapper) applicationContext.getBean(mapperClazz);
//                QueryWrapper<Object> wrapper = new QueryWrapper<>();
//                wrapper.select(colums);
//                wrapper.eq(condition, conditonValue);
//                // TODO 这里会有一个问题 假设一个Vo返回的可能是一个List 那么如果id相同,则循环了10次,所以需要再次定义一个map, key 为 id  value 为查询出来的实体对象
//                Object targetEntity = baseMapper.selectOne(wrapper);

                // 这里还有一个实现的方法是用MP的selectById方法
                // 获取注解中的方法名称,注意mapper中的方法签名是:T selectById(Serializable var1);
                String methodName = annotation.method();
                Method method = mapperClazz.getMethod(methodName, Serializable.class);
                // 获取mapper实例
                Object mapperBean = applicationContext.getBean(mapperClazz);
                Object targetEntity = method.invoke(mapperBean, conditonValue);


                String targetFieldName = annotation.targetFieldName();
                // 关联实体的field
                Field field = targetEntity.getClass().getDeclaredField(targetFieldName);
                // 打开私有属性访问权限,否则can not access a member
                field.setAccessible(true);
                Object sourceFieldValue = field.get(targetEntity);
                // 重新设置值
                declaredField.set(source, sourceFieldValue);

            }
        }

    }
}
