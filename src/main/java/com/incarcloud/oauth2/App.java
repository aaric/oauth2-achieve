package com.incarcloud.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 项目启动类
 *
 * @author Aaric, created on 2020-03-11T16:06.
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootApplication
@MapperScan(basePackages = "com.incarcloud.oauth2.**.mapper")
public class App {

    /**
     * Main
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
