package com.newer.springbootdemo3.controller;

import com.newer.springbootdemo3.domain.ErrorInfo;
import com.newer.springbootdemo3.exception.HospitalException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shining
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = HospitalException.class)
    @ResponseBody
    public ErrorInfo<String> exceptionHandler(HttpServletRequest request,HospitalException e){
        ErrorInfo<String> errorInfo=new ErrorInfo<>();
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setUrl(request.getRequestURL().toString());
        errorInfo.setMessage(e.getMessage());
        errorInfo.setData("some data");
        return  errorInfo;
    }
}

