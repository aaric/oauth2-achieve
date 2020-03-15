package com.incarcloud.oauth2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * OAuth2客户端启动类
 *
 * @author Aaric, created on 2020-03-15T20:07.
 * @version 0.3.0-SNAPSHOT
 */
@SpringBootApplication
@MapperScan(basePackages = "com.incarcloud.oauth2client.**.mapper")
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
