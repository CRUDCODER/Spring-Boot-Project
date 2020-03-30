package com.liujin.token.exception;

/**
 * @author liujin
 * @date created in 2020/2/19 16:19
 */
public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }
}
