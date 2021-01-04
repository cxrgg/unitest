package com.hbsf.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    /**
     * 配置阿里巴巴的Druid连接池
     * 用来和数据库连接
     *  @Bean spring整合将创建对象的权利交给spring框架
     * @ConfigurationProperties配置内容
     * (prefix = "spring.datasource") 前缀
     *
     * 开启这个后，可以配置了连接池其他的东西
     * 比如最大连接数
     *
     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DruidDataSource dataSource() {
//        return new DruidDataSource();
//    }
}
