package com.liujin.token.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @author liujin
 * @date created in 2020/2/19 17:41
 */
public class UserException extends AuthenticationException {
    public UserException(String message) {
        super(message);
    }

}
