package com.coder.cloud.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author pluviophile
 * @github https://github.com/CRUDCODER
 * @email 710683598@qq.com
 * @create 2020-04-12 11:19
 * @description
 */
@Component
public class GatewayFilter  implements GlobalFilter, Ordered {
    Logger logger= LoggerFactory.getLogger(GatewayFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String methodValue = exchange.getRequest().getMethodValue();
        HttpMethod method = exchange.getRequest().getMethod();
        logger.info("option?:{}",method.matches("OPTIONS"));
        logger.info("methodValue:{}",methodValue);
        logger.info("请求地址为:{}",exchange.getRequest().getURI());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
