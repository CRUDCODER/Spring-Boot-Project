package com.coder.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liujin
 * @date created in 2020/4/6 18:14
 */
@Configuration
public class FeignLoggerConfig {
    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }
}
