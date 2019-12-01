package com.rwt.arknights.web.exceptionHandler;

public class CustomException extends RuntimeException {
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
