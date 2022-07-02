package com.pupilcc.common.rest;

/**
 * REST API 错误码接口
 *
 * @author pupilcc
 * @since 2022-07-02
 */
public interface IErrorCode {
    /**
     * 错误编码 -1、失败 0、成功
     *
     * @return code
     */
    long getCode();

    /**
     * 错误描述
     *
     * @return msg
     */
    String getMsg();
}
