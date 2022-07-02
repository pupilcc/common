package com.pupilcc.common.rest;

/**
 * REST API 错误码
 *
 * @author pupilcc
 * @since 2022-07-02
 */
public enum BaseErrorCode implements IErrorCode {
    /**
     * 失败
     */
    FAILED(-1L, "failed"),
    /**
     * 成功
     */
    SUCCESS(0L, "success"),
    ;

    private final long code;
    private final String msg;

    BaseErrorCode(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return String.format(" ErrorCode:{code=%s, msg=%s} ", this.code, this.msg);
    }
}
