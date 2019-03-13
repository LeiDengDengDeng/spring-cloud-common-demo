package com.example.demo.bean;

import lombok.Data;

/**
 * @author deng
 * @date 2018/11/7
 */
@Data
public class Response<T> {
    /**
     * 数据
     */
    private T res;
    /**
     * 状态码
     */
    private int code;

    public Response(int code, T res) {
        this.res = res;
        this.code = code;
    }
}
