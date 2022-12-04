package com.example.common;

public class CommonException extends RuntimeException{
    private String code;
    private String message;
    private Object[] args;

    public CommonException() {
    }

    public CommonException(ExceptionState ExceptionState, Object... orgs) {
        this(ExceptionState.getCode(), ExceptionState.getMsg(), orgs);
    }

    public CommonException(String message) {
        super(message);
        this.message = message;
        this.code = BaseState.ResponseCode.BUSINESS_EXCEPTION.getCode();
    }

    public CommonException(String code, String message, Object... args) {
        super(message);
        this.message = message;
        this.args = args;
        this.code = code;
    }

    public CommonException(Integer code, String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.code = code.toString();
    }

    public CommonException(String code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public CommonException(String code, String message, Throwable throwable) {
        super(throwable);
        this.message = message;
        this.code = code;
    }

    public CommonException(Integer code, Throwable throwable) {
        super(throwable);
        this.code = code.toString();
    }

    public CommonException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public Object[] getArgs() {
        return this.args;
    }
}
