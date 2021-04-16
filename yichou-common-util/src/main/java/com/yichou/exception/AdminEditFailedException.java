package com.yichou.exception;

/**
 * t_admin表修改数据失败异常类
 * @author alageek
 */
public class AdminEditFailedException extends RuntimeException {

    private static final long serialVersionUID = 8799337052658648136L;

    public AdminEditFailedException(){
        super();
    }

    public AdminEditFailedException(String message, Throwable cause, Boolean enableSuppression, Boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AdminEditFailedException(String message, Throwable cause){
        super(message, cause);
    }

    public AdminEditFailedException(Throwable cause){
        super(cause);
    }

    public AdminEditFailedException(String message){
        super(message);
    }

}
