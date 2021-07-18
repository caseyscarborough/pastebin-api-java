package com.pastebin.api.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "paste")
public class ListResponseItem {

    @JacksonXmlProperty(localName = "paste_key")
    private String key;

    @JacksonXmlProperty(localName = "paste_date")
    private long date;

    @JacksonXmlProperty(localName = "paste_title")
    private String title;

    @JacksonXmlProperty(localName = "paste_size")
    private long size;

    @JacksonXmlProperty(localName = "paste_expire_date")
    private long expireDate;

    @JacksonXmlProperty(localName = "paste_private")
    private int privacy;

    @JacksonXmlProperty(localName = "paste_format_long")
    private String formatLong;

    @JacksonXmlProperty(localName = "paste_format_short")
    private String formatShort;

    @JacksonXmlProperty(localName = "paste_url")
    private String url;

    @JacksonXmlProperty(localName = "paste_hits")
    private int hits;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(long expireDate) {
        this.expireDate = expireDate;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public String getFormatLong() {
        return formatLong;
    }

    public void setFormatLong(String formatLong) {
        this.formatLong = formatLong;
    }

    public String getFormatShort() {
        return formatShort;
    }

    public void setFormatShort(String formatShort) {
        this.formatShort = formatShort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
