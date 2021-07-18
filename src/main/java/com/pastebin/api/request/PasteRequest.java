package com.pastebin.api.request;

import com.pastebin.api.Expiration;
import com.pastebin.api.Format;
import com.pastebin.api.Visibility;

import java.util.HashMap;
import java.util.Map;

public class PasteRequest implements Request {

    private final String content;
    private final Format format;
    private final Visibility visibility;
    private final String name;
    private final Expiration expiration;
    private final String folderKey;

    private PasteRequest(String content, Format format, Visibility visibility, String name, Expiration expiration, String folderKey) {
        this.content = content;
        this.format = format;
        this.visibility = visibility;
        this.name = name;
        this.expiration = expiration;
        this.folderKey = folderKey;
    }

    public static Builder content(final String content) {
        return new Builder(content);
    }

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_paste_code", content);
        if (this.format != null) {
            parameters.put("api_paste_format", this.format.getCode());
        }

        if (this.visibility != null) {
            parameters.put("api_paste_private", String.valueOf(this.visibility.getCode()));
        }

        if (this.name != null) {
            parameters.put("api_paste_name", this.name);
        }

        if (this.expiration != null) {
            parameters.put("api_paste_expire_date", this.expiration.getCode());
        }

        if (this.folderKey != null) {
            parameters.put("api_folder_key", this.folderKey);
        }

        return parameters;
    }

    public static class Builder {
        private final String content;
        private Format format;
        private Visibility visibility;
        private String name;
        private Expiration expiration;
        private String folderKey;

        public Builder(String content) {
            this.content = content;
        }

        public Builder format(final Format format) {
            this.format = format;
            return this;
        }

        public Builder visibility(final Visibility visibility) {
            this.visibility = visibility;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder expiration(final Expiration expiration) {
            this.expiration = expiration;
            return this;
        }

        public Builder folderKey(final String folderKey) {
            this.folderKey = folderKey;
            return this;
        }

        public PasteRequest build() {
            return new PasteRequest(content, format, visibility, name, expiration, folderKey);
        }
    }
}
