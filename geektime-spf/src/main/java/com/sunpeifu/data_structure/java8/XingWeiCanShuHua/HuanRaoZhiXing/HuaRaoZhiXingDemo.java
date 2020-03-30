package com.sunpeifu.data_structure.java8.XingWeiCanShuHua.HuanRaoZhiXing;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.function.Predicate;

/**
 * 作者:  sunpeifu
 * 日期:  2020/3/29
 * 描述:  环绕执行
 */
public class HuaRaoZhiXingDemo {
    public static void main(String[] args) throws Exception {
        // 使用lambda的方式调用下面代码,注意lambda有3部分组成 ()参数,  -> 分隔符    {}方法体
        // 下面这种方式明显编译报错,因为我们的processFile是没有参数的
        //String a = processFile((BufferedReader br) -> br.readLine() + br.readLine());


        String result = processFile((BufferedReader br) -> br.readLine());
        // 如果想要读取两行,则继续谁家即可
        String result2 = processFile((BufferedReader br) -> br.readLine() + br.readLine());



    }

    public static String processFile() throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader("a.txt"))) {
            return br.readLine();
        }
    }

    // 注意,这个重载方法,接受的参数是接口,里面是抽象方法processFile
    public static String processFile(BufferReaderProcessor br) throws Exception {

        try (BufferedReader b = new BufferedReader(new FileReader("a.txt"))) {
            return b.readLine();
        }
    }
}
