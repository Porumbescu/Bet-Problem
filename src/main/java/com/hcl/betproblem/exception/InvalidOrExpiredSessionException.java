package com.hcl.betproblem.exception;

public class InvalidOrExpiredSessionException extends RuntimeException{
    public InvalidOrExpiredSessionException(String message) {
        super(message);
    }
}
