package com.jack.notepad.exception;

/**
 * 用户操作相关异常
 * Created by Administrator on 2017/1/13.
 */
public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
