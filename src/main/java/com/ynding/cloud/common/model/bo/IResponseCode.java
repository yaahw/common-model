package com.ynding.cloud.common.model.bo;

/**
 * 返回状态码及信息
 *
 * @author ynding
 * @version 2020/08/27
 */
public interface IResponseCode {

    /**
     * 状态码
     * @return
     */
    int getCode();

    /**
     * 信息
     * @return
     */
    String getMessage();
}
