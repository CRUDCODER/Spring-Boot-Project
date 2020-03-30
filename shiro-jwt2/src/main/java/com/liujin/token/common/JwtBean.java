package com.liujin.token.common;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author liujin
 * @date created in 2020/2/19 15:54
 */
public class JwtBean implements AuthenticationToken {

    private String token;

    public JwtBean(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
