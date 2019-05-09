package com.eddy.health.aide.exception;

/**
 * @Author PuaChen
 * @Create 2019-2-13
 * 登录异常
 */
public class LoginFailureException extends RuntimeException {

    private int code = 401;

    public LoginFailureException(String message) {
        super(message);
        this.code = 401;
    }

    public int getCode() {
        return code;
    }
}
