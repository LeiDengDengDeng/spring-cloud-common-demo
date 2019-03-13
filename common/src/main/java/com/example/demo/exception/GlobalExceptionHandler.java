package com.example.demo.exception;

import com.example.demo.bean.Response;
import com.example.demo.util.ResponseFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * @author deng
 * @date 2018/11/13
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final static String METHOD_ARGUMENT_NOT_VALID_MESSAGE = "Method Argument Not Valid";

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public Response<String> jsonErrorHandler(ServiceException e) {
        return ResponseFactory.errResponse(e);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public Response<String> jsonErrorHandler(ConstraintViolationException e) {
        return ResponseFactory.errResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder errMessage = new StringBuilder();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(System.lineSeparator());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errMessage.append(error.getObjectName()).append(": ").append(error.getDefaultMessage()).append(System.lineSeparator());
        }

        String finalErrMessage = errMessage.length() == 0 ? METHOD_ARGUMENT_NOT_VALID_MESSAGE : errMessage.toString();
        return super.handleExceptionInternal(ex, ResponseFactory.errResponse(status.value(), finalErrMessage), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, ResponseFactory.errResponse(status.value(), ex.getMessage()), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, ResponseFactory.errResponse(status.value(), ex.getMessage()), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, ResponseFactory.errResponse(status.value(), ex.getMessage()), headers, status, request);
    }
}
