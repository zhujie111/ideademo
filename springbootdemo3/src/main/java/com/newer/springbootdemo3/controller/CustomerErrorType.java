package com.newer.springbootdemo3.controller;

import java.io.Serializable;

public class CustomerErrorType implements Serializable{

    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public CustomerErrorType() {
    }

    public CustomerErrorType(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
