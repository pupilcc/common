package com.pupilcc.common.rest;

/**
 * REST API 请求异常类
 *
 * @author pupilcc
 * @since 2022-07-02
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -5885155226898287919L;
    private IErrorCode errorCode;

    public BaseException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return this.errorCode;
    }
}

