package com.incarcloud.oauth2client.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * MybatisPlus配置
 *
 * @author Aaric, created on 2020-03-30T14:40.
 * @version 0.9.0-SNAPSHOT
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.incarcloud.oauth2client.**.mapper")
public class MybatisPlusConfig {

    /**
     * 使用HikariCP数据库连接池
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
