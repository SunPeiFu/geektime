package com.sunpeifu;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@Slf4j
@MapperScan(basePackages = {"com.sunpeifu.geektime.mapper"})
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})

public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("========== 学习项目启动完毕 ==========");
    }
}
