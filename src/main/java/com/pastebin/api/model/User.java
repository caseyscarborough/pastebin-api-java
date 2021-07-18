package com.pastebin.api.model;

import com.pastebin.api.AccountType;
import com.pastebin.api.Visibility;

public class User {

    private String username;
    private String formatShort;
    private String expiration;
    private String avatarUrl;
    private Visibility privacy;
    private String website;
    private String email;
    private String location;
    private AccountType accountType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFormatShort() {
        return formatShort;
    }

    public void setFormatShort(String formatShort) {
        this.formatShort = formatShort;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Visibility getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Visibility privacy) {
        this.privacy = privacy;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "User{" +
            "username='" + username + '\'' +
            ", formatShort='" + formatShort + '\'' +
            ", expiration='" + expiration + '\'' +
            ", avatarUrl='" + avatarUrl + '\'' +
            ", privacy=" + privacy +
            ", website='" + website + '\'' +
            ", email='" + email + '\'' +
            ", location='" + location + '\'' +
            ", accountType=" + accountType +
            '}';
    }
}
