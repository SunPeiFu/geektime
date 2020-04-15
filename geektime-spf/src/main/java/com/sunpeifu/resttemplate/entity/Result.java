package com.sunpeifu.resttemplate.entity;

/**
 * 作者:  daike
 * 日期:  2020/4/14
 * 描述:
 */
public class Result<T> extends ResultBase {
    private T data;

    public static <T> Result<T> wrap(boolean success, Integer code, String message, T data) {
        Result<T> result = new Result();
        result.setSuccess(success);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> wrapSuccessfulResult(T data) {
        Result<T> result = new Result();
        result.data = data;
        result.setSuccess(true);
        result.setCode(1);
        return result;
    }

    public static <T> Result<T> wrapSuccess(String message) {
        Result<T> result = new Result();
        result.setSuccess(true);
        result.setMessage(message);
        result.setCode(1);
        return result;
    }

    public static <T> Result<T> wrapSuccess(Integer code, String message, T data) {
        Result<T> result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> wrapSuccessfulResult(String message, T data) {
        Result<T> result = new Result();
        result.data = data;
        result.setSuccess(true);
        result.setCode(1);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> wrapError() {
        Result<T> result = new Result();
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> wrapError(T data) {
        Result<T> result = new Result();
        result.setSuccess(false);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> wrapError(Integer code, String message) {
        Result<T> result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> wrapErrorResult(Integer code, String message, T data) {
        Result<T> result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public T getData() {
        return this.data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Result;
    }


    public Result() {
    }

    public String toString() {
        return "Result(data=" + this.getData() + ")";
    }
}