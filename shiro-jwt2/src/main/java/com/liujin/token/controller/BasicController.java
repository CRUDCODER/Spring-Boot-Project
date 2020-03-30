package com.liujin.token.controller;

import com.liujin.token.exception.LoginException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author liujin
 * @date created in 2020/2/19 16:57
 */
@RestController
@Slf4j
public class BasicController {
    @RequestMapping("/error/rethrow")
    public void rethrow() {
        throw new LoginException("检查到当前账号未登录!");
    }
    @RequestMapping("/error/jwtException")
    public ConcurrentMap<String,Object> userException(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        ConcurrentMap<String,Object> concurrentMap=new ConcurrentHashMap<>();
        Exception exception = (Exception) request.getAttribute("filter.error");
        log.info("{}",exception.getClass());
        log.info("{}",exception.getMessage());
        log.info("{}",exception.getLocalizedMessage());
        log.info("{}",exception.getStackTrace());
        concurrentMap.put("path",request.getAttribute("path"));
        return concurrentMap;
    }


    @RequestMapping("/error/JweException/{message}")
    public void jwtException(@PathVariable("message") String message){
        throw new JwtException(message);
    }

}
