package com.sunpeifu.data_structure;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/30
 * 描述:
 */
public class BigDecimalTest {

    public static void main(String[] args) {

        BigDecimal zero1 = new BigDecimal("0");
        BigDecimal zero2 = new BigDecimal("0.00");
        System.out.println(zero1.compareTo(zero2));  // 0
        System.out.println(zero1.equals(zero2));     // false   此时的equals方法,会调用scale,保留的位数不同,结果当然不同
        System.out.println("上面是使用String构造的结果===================");
        BigDecimal zero3 = new BigDecimal(0);
        BigDecimal zero4 = new BigDecimal(0.0000);
        System.out.println(zero3.compareTo(zero4));  // 0
        System.out.println(zero3.equals(zero4));     // true
        System.out.println("上面是使用int构造的结果===================");





        BigDecimal a = new BigDecimal("0.566");
        BigDecimal b = new BigDecimal("0.00");
        System.out.println(a.compareTo(b));
        System.out.println(a.equals(b));
        // 小数点后面保留1位,四舍五入
        BigDecimal c = a.setScale(1, RoundingMode.HALF_UP);
        System.out.println(c); // 0.6
        BigDecimal d = a.setScale(2, RoundingMode.HALF_UP);
        System.out.println(d); // 0.57
        // 需要注意当我们设置了scale 即小数点后保留几位时,它是在这个位数的基础之上进行四舍五入
        BigDecimal e = new BigDecimal("0.51");
        BigDecimal f = e.setScale(2, RoundingMode.HALF_UP);
        System.out.println(f); // 0.51


    }
}
