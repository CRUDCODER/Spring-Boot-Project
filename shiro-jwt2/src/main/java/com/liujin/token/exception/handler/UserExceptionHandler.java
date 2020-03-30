package com.liujin.token.exception.handler;

import com.liujin.token.common.RespBean;
import com.liujin.token.exception.UserException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author liujin
 * @date created in 2020/2/19 18:02
 */
@RestControllerAdvice
public class UserExceptionHandler   {
    @ExceptionHandler(UserException.class)
    public RespBean AuthenticationException(UserException e, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
        return RespBean.error("身份验证失败,请重新登陆!",e.getMessage());
    }

    @ExceptionHandler(AuthorizationException.class)
    public RespBean AuthorizationException(AuthorizationException e,HttpServletResponse httpServletResponse){
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return RespBean.error("权限不足,无法操作!",e.getMessage());
    }

}
