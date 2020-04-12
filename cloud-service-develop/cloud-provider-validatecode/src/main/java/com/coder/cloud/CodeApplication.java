package com.coder.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author pluviophile
 * @github https://github.com/CRUDCODER
 * @email 710683598@qq.com
 * @create 2020-04-10 14:18
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScans(@ComponentScan(value = "com.coder.api"))
@EnableFeignClients(value = "com.coder.api.service")
public class CodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeApplication.class,args);
    }
}
