package com.yichou.util;

/**
 * 统一整个项目中Ajax请求返回的结果（未来也可以用于分布式架构各个模块间调用时返回统一类型）
 * @author alageek
 * @param <T>
 */
public class ResultEntity<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    /**
     * 用来封装当前请求处理的结果是成功还是失败
     */
    private String result;

    /**
     * 请求处理失败时返回的错误消息
     */
    private String message;

    /**
     * 要返回的数据
     */
    private T data;


    public static <E> ResultEntity<E> successWithoutData(){
        return new ResultEntity<>(SUCCESS, null, null);
    }

    public static <E> ResultEntity<E> successWithData(E data){
        return new ResultEntity<>(SUCCESS, null, data);
    }

    public static <E> ResultEntity<E> failed(String msg){
        return new ResultEntity<>(FAILED, msg, null);
    }

    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
