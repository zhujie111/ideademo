package com.newer.springbootdemo3.security.domain;

/**
 * 授权异常类
 *
 */
public class AuthenticationException extends RuntimeException {
  public AuthenticationException(String message, Throwable cause) {
    super(message, cause);
  }
}
