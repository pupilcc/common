package com.pupilcc.common.rest;

import java.io.Serializable;
import java.util.Optional;

/**
 * REST API 返回结果
 *
 * @author pupilcc
 * @since 2022-07-02
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 业务错误码
     */
    private long code;

    /**
     * 描述
     */
    private String msg;

    /**
     * 结果集
     */
    private T data;

    public Result() {
    }

    public Result(IErrorCode errorCode) {
        errorCode = Optional.ofNullable(errorCode).orElse(BaseErrorCode.FAILED);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public static <T> Result<T> restResult(T data, IErrorCode errorCode) {
        return restResult(data, errorCode.getCode(), errorCode.getMsg());
    }

    private static <T> Result<T> restResult(T data, long code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    /* success */

    public static <T> Result<T> success() {
        return restResult(null, BaseErrorCode.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        BaseErrorCode aec = BaseErrorCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            aec = BaseErrorCode.FAILED;
        }

        return restResult(data, aec);
    }

    /* failed */

    public static <T> Result<T> failed(String msg) {
        return restResult(null, BaseErrorCode.FAILED.getCode(), msg);
    }

    public static <T> Result<T> failed(IErrorCode errorCode) {
        return restResult(null, errorCode);
    }

    public boolean failed() {
        return BaseErrorCode.SUCCESS.getCode() != this.code;
    }

    /**
     * 服务间调用非业务正常，异常直接释放
     *
     * @return data
     */
    public T serviceData() {
        if (!this.failed()) {
            throw new BaseException(this.msg);
        } else {
            return this.data;
        }
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
