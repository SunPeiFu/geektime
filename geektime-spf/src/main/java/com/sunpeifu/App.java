package com.sunpeifu;

import com.sunpeifu.configuratioon.TestConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@Slf4j
@MapperScan(basePackages = {"com.sunpeifu"})
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        TestConfiguration bean = context.getBean(TestConfiguration.class);
        System.out.println(bean);
        System.out.println("tostring:"+ bean.toString());
        log.info("========== 学习项目启动完毕 ==========");
        log.info("========== feature提交 ==========");

    }
}
