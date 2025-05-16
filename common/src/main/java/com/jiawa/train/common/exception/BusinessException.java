package com.jiawa.train.common.exception;

/**
 * Author: 陈桂明
 * Date: 2025/5/16 23:18
 * Description: BusinessException
 */
public class BusinessException extends RuntimeException {

    private BusinessExceptionEnum e;

    public BusinessException() {
    }

    public BusinessException(BusinessExceptionEnum e) {
        this.e = e;
    }

    public BusinessExceptionEnum getE() {
        return e;
    }

    public void setE(BusinessExceptionEnum e) {
        this.e = e;
    }
}
