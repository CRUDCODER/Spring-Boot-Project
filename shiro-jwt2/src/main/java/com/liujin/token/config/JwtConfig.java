package com.liujin.token.config;

import com.liujin.token.common.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liujin
 * @date created in 2020/2/19 15:38
 */
@Configuration
public class JwtConfig {
    @Bean
    public JwtUtils jwtUtils(){
        return new JwtUtils();
    }
}
