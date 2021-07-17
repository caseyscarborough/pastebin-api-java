package com.pastebin.api;

public class PastebinException extends RuntimeException {

    public PastebinException(String message) {
        super(message);
    }

    public PastebinException(String message, Throwable cause) {
        super(message, cause);
    }
}
