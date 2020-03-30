package com.liujin.token.interceptor;

import com.liujin.token.common.JwtUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liujin
 * @date created in 2020/2/19 16:42
 */
public class TokenInterceptor {


    public static boolean isHasHeader(HttpServletRequest request, JwtUtils jwtUtils){
        String header = request.getHeader(jwtUtils.getHEADER_NAME());
        if (header!=null){
            return true;
        }
        throw new RuntimeException("检测到您未登录,请先进行登录");
    }
}
