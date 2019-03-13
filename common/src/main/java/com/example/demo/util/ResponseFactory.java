package com.example.demo.util;

import com.example.demo.bean.Response;
import com.example.demo.exception.ServiceException;

/**
 * @author deng
 * @date 2018/12/13
 */
public class ResponseFactory<T> {
    private static final int OK_CODE = 0;

    private ResponseFactory() {
    }

    public static <T> Response<T> okResponse(Object data) {
        return new Response(OK_CODE, data);
    }

    public static Response<String> errResponse(ServiceException e) {
        return new Response(e.getErrCode(), e.getMessage());
    }

    public static Response<String> errResponse(int errCode, String errMessage) {
        return new Response(errCode, errMessage);
    }

}
