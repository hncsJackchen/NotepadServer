package com.jack.notepad.exception;

/**
 * 用户登录是信息错误异常
 * Created by Administrator on 2017/1/13.
 */
public class LoginInfoErrorException extends UserException {

    public LoginInfoErrorException(String message) {
        super(message);
    }

    public LoginInfoErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
