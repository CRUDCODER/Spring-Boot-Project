package com.coder.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liujin
 * @date created in 2020/4/6 18:03
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients//openfeign
@EnableCircuitBreaker//hystrix服务熔断
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
