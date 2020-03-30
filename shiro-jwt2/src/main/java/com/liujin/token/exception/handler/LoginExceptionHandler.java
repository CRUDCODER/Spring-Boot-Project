package com.liujin.token.exception.handler;

import com.liujin.token.common.RespBean;
import com.liujin.token.exception.LoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author liujin
 * @date created in 2020/2/19 16:20
 */
@RestControllerAdvice
public class LoginExceptionHandler {
    @ExceptionHandler(LoginException.class)
    public RespBean error(LoginException e, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return RespBean.error("请先登录!",e.getMessage());
    }
}
