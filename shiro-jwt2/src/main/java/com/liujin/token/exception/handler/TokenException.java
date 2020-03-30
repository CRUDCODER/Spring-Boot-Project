package com.liujin.token.exception.handler;

import com.liujin.token.common.RespBean;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liujin
 * @date created in 2020/2/19 18:24
 */
@RestControllerAdvice
public class TokenException {
    @ExceptionHandler(ExpiredJwtException.class)
    public RespBean error(ExpiredJwtException e, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return RespBean.error("登录已过期,请重新登陆!",e.getMessage());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String,Object> error(IllegalArgumentException e, HttpServletResponse response){
        Map<String,Object> map=new HashMap<>(16);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        map.put("message","token为空,无法通过验证");
        map.put("error",e.getMessage());
        return map;
    }
    @ExceptionHandler(SignatureException.class)
    public Map<String,Object> error(SignatureException e, HttpServletResponse response){
        Map<String,Object> map=new HashMap<>(16);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        map.put("message","伪造token，无法验证通过!");
        map.put("error",e.getMessage());
        return map;
    }

    @ExceptionHandler(MalformedJwtException.class)
    public Map<String,Object> error(MalformedJwtException e, HttpServletResponse response){
        Map<String,Object> map=new HashMap<>(16);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        map.put("message","token格式不匹配，无法验证通过");
        map.put("error",e.getMessage());
        return map;
    }
}
