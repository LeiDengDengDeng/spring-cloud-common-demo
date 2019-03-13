package com.example.demo.util;


import com.example.demo.exception.ServiceException;

import java.util.Objects;

/**
 * 在Service层进行断言判断
 * 如果判断失败
 * 则抛出异常，并在Controller层由<tt>ControllerAdvice</tt>捕获。
 * <tt>ControllerAdvice</tt>的配置位于{@link com.example.demo.exception.GlobalExceptionHandler}类中
 *
 * @see com.example.demo.exception.GlobalExceptionHandler
 */
public class AssertUtil {
    public static void assertTrue(boolean bool, ErrorEnum errorEnum) {
        if (!bool) {
            throw new ServiceException(errorEnum.getErrCode(), errorEnum.getErrMessage());
        }
    }

    /**
     * 判断条件是否为真，若为否，则抛出{@link ServiceException}异常
     *
     * @param bool         条件
     * @param errCode      错误码
     * @param falseMessage 错误信息
     * @throws ServiceException
     */
    public static void assertTrue(boolean bool, int errCode, String falseMessage) {
        if (!bool) {
            throw new ServiceException(errCode, falseMessage);
        }
    }

    public static void assertNotNull(Object entity, ErrorEnum errorEnum) {
        if (Objects.isNull(entity)) {
            throw new ServiceException(errorEnum.getErrCode(), errorEnum.getErrMessage());
        }
    }

    /**
     * 判断对象是否非空，如果为Null，抛出{@link ServiceException}异常
     *
     * @param entity       对象
     * @param errCode      错误码
     * @param falseMessage 错误信息
     * @throws ServiceException
     */
    public static void assertNotNull(Object entity, int errCode, String falseMessage) {
        if (Objects.isNull(entity)) {
            throw new ServiceException(errCode, falseMessage);
        }
    }

    public static void assertNull(Object entity, ErrorEnum errorEnum) {
        if (!Objects.isNull(entity)) {
            throw new ServiceException(errorEnum.getErrCode(), errorEnum.getErrMessage());
        }
    }

    /**
     * 判断对象是否为Null，如果非空，抛出{@link ServiceException}异常
     *
     * @param entity       对象
     * @param errCode      错误码
     * @param falseMessage 错误信息
     * @throws ServiceException
     */
    public static void assertNull(Object entity, int errCode, String falseMessage) {
        if (!Objects.isNull(entity)) {
            throw new ServiceException(errCode, falseMessage);
        }
    }
}
