package com.pastebin.api;

public enum AccountType {

    NORMAL(0, "Normal"),
    PRO(1, "Pro");

    private final int code;
    private final String name;

    AccountType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    static AccountType find(final int code) {
        for (AccountType value : values()) {
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
