package com.yichou.exception;

/**
 * t_admin表添加数据失败异常类
 * @author alageek
 */
public class AdminAddFailedException extends RuntimeException {

    private static final long serialVersionUID = -4508889687029662505L;

    public AdminAddFailedException(){
        super();
    }

    public AdminAddFailedException(String message, Throwable cause, Boolean enableSuppression, Boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AdminAddFailedException(String message, Throwable cause){
        super(message, cause);
    }

    public AdminAddFailedException(Throwable cause){
        super(cause);
    }

    public AdminAddFailedException(String message){
        super(message);
    }

}
