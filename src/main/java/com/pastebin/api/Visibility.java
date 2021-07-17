package com.pastebin.api;

public enum Visibility {

    PRIVATE(2),
    UNLISTED(1),
    PUBLIC(0);

    private final int code;

    Visibility(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
