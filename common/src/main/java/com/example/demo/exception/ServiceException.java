package com.example.demo.exception;

import lombok.Data;

/**
 * @author deng
 * @date 2018/11/7
 */
@Data
public class ServiceException extends RuntimeException {
    private int errCode;
    private String message;

    public ServiceException(int errCode, String message) {
        super(message);
        this.errCode = errCode;
        this.message = message;
    }
}