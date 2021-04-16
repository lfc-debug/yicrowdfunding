package com.yichou.exception;

/**
 * 禁止访问异常类
 * @author alageek
 */
public class AccessForbiddenException extends RuntimeException {

    private static final long serialVersionUID = 7526324512252691698L;

    public AccessForbiddenException(){
        super();
    }

    public AccessForbiddenException(String message, Throwable cause, Boolean enableSuppression, Boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AccessForbiddenException(String message, Throwable cause){
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause){
        super(cause);
    }

    public AccessForbiddenException(String message){
        super(message);
    }

}
