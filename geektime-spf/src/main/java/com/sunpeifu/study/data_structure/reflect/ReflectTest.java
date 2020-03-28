package com.sunpeifu.study.data_structure.reflect;

import com.sunpeifu.demo.bean.VerifyAmount;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/27
 * 描述:
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        batchCreaeData(VerifyAmount.class, 10).forEach(verifyAmount -> System.out.println(verifyAmount));

    }

    /***
     * 传入T 和 需要造的数据量
     */
    public static <T> List<T> batchCreaeData(Class<T> clazz, int dataSize) {
        ArrayList<T> list = new ArrayList<>(dataSize);

        for (int i = 0; i < dataSize; i++) {
            try {
                list.add(createData(clazz));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return list;
    }


    public static <T> T createData(Class<T> clazz) throws Exception {
        T t = clazz.newInstance();
        // 获取所有私有方法,只能获取当前类,如果想要获取父类,就用非declar的
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            // 设置可以访问
            declaredMethod.setAccessible(true);
            // 获取当前方法参数的数量
            int parameterCount = declaredMethod.getParameterCount();
            // 方法名称
            String methodName = declaredMethod.getName();

            // 造数据,只获取setXXX方法
            if (methodName.startsWith("set")) {
                // 存储多个参数的随机值,T一定是Object
                List<Object> list = new ArrayList<>(declaredMethods.length);

                Parameter[] parameters = declaredMethod.getParameters();
                for (Parameter parameter : parameters) {
                    list.add(createDataByClassType(parameter.getType()));
                    System.out.println("参数类型是:" + parameter.getType() + "方法名称是:" + methodName + "  " + "方法参数的长度是:" + parameterCount + " 参数名称:" + parameter.getName());
                }
                // method.invoket() 里面方法是可变参数Object...paramas,如果想传入多个,传入数组,但是必须是Object数组
                declaredMethod.invoke(t, list.toArray());
                System.out.println("大的循环中方法名称:" + declaredMethod.getName());
            }

        }
        return t;
    }


    public static Object createDataByClassType(Class clazz) {
        // 根据常见类型优先级
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = df.format(LocalDateTime.now());
        Parameter parameter = null;
        if (clazz == String.class) {
            return UUID.randomUUID().toString().replaceAll("-", "");
            // 如果参数类型是String,执行设置数据的方法
        } else if (clazz == Integer.class) {
            return new Random().nextInt(10);
        } else if (clazz == BigDecimal.class) {
            return new BigDecimal((int) (Math.random() * 100 + 1));
        } else if (clazz == Boolean.class) {
            return clazz.getName().hashCode() % 2 == 0;
        } else if (clazz == LocalDateTime.class) {
            return LocalDateTime.parse(nowStr, df);
        }

        // 后续可以补充 参数为List<T> 等等的情况
        return null;
    }


}
