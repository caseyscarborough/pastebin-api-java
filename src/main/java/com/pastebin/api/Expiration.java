package com.pastebin.api;

public enum Expiration {

    NEVER("N", "Never"),
    TEN_MINUTES("10M", "10 Minutes"),
    ONE_HOUR("1H", "1 Hour"),
    ONE_DAY("1D", "1 Day"),
    ONE_WEEK("1W", "1 Week"),
    TWO_WEEKS("2W", "2 Weeks"),
    ONE_MONTH("1M", "1 Month"),
    SIX_MONTHS("6M", "6 Months"),
    ONE_YEAR("1Y", "1 Year");

    private final String code;
    private final String description;

    Expiration(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
