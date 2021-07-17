package com.pastebin.api;

public enum PastebinVisibility {

    PRIVATE(2),
    UNLISTED(1),
    PUBLIC(0);

    private final int code;

    PastebinVisibility(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
