package com.pastebin.api.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "user")
public class UserResponse {

    @JacksonXmlProperty(localName = "user_name")
    private String name;

    @JacksonXmlProperty(localName = "user_format_short")
    private String formatShort;

    @JacksonXmlProperty(localName = "user_expiration")
    private String expiration;

    @JacksonXmlProperty(localName = "user_avatar_url")
    private String avatarUrl;

    @JacksonXmlProperty(localName = "user_private")
    private int privacy;

    @JacksonXmlProperty(localName = "user_website")
    private String website;

    @JacksonXmlProperty(localName = "user_email")
    private String email;

    @JacksonXmlProperty(localName = "user_location")
    private String location;

    @JacksonXmlProperty(localName = "user_account_type")
    private int accountType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
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

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
}
