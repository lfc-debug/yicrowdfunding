package com.yichou.exception;

/**
 * 登录失败异常类
 * @author alageek
 */
public class LoginFailedException extends RuntimeException {

    private static final long serialVersionUID = -1858746373532741422L;

    public LoginFailedException(){
        super();
    }

    public LoginFailedException(String message, Throwable cause, Boolean enableSuppression, Boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LoginFailedException(String message, Throwable cause){
        super(message, cause);
    }

    public LoginFailedException(Throwable cause){
        super(cause);
    }

    public LoginFailedException(String message){
        super(message);
    }

}
