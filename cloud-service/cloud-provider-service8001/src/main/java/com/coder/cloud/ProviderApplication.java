package com.coder.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liujin
 * @date created in 2020/4/6 16:03
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//暂时还未连接数据库，所有暂时不使用Datasource自动注入配置
@EnableEurekaClient
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
