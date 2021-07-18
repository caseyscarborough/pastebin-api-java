package com.pastebin.api;

public enum Visibility {

    PRIVATE(2, "Private"),
    UNLISTED(1, "Unlisted"),
    PUBLIC(0, "Public");

    private final int code;
    private final String name;

    Visibility(int code, String name) {
        this.code = code;
        this.name = name;
    }

    static Visibility find(final int code) {
        for (Visibility value : values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
