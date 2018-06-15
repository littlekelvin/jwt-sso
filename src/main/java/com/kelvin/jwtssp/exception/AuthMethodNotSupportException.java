package com.kelvin.jwtssp.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

public class AuthMethodNotSupportException extends AuthenticationServiceException {
    public AuthMethodNotSupportException(String message) {
        super(message);
    }

    public AuthMethodNotSupportException(String msg, Throwable t) {
        super(msg, t);
    }
}
