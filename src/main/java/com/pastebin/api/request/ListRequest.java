package com.pastebin.api.request;

import java.util.HashMap;
import java.util.Map;

public class ListRequest implements Request {

    private final Integer limit;

    public ListRequest() {
        this(null);
    }

    private ListRequest(Integer limit) {
        this.limit = limit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ListRequest limit(int limit) {
        return new Builder().limit(limit).build();
    }

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> output = new HashMap<>();
        output.put("api_option", "list");
        if (this.limit != null) {
            output.put("api_results_limit", String.valueOf(this.limit));
        }
        return output;
    }

    public static class Builder {
        private Integer limit;

        Builder() {
        }

        public Builder limit(final int limit) {
            this.limit = limit;
            return this;
        }

        public ListRequest build() {
            if (this.limit < 1) {
                throw new IllegalArgumentException("Limit minimum is 1");
            }

            if (this.limit > 100) {
                throw new IllegalArgumentException("Limit maximum is 100");
            }

            return new ListRequest(this.limit);
        }
    }
}
