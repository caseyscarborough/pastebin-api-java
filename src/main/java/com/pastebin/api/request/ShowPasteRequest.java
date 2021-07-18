package com.pastebin.api.request;

import java.util.HashMap;
import java.util.Map;

public class ShowPasteRequest implements Request {

    private final String pasteKey;

    private ShowPasteRequest(String pasteKey) {
        this.pasteKey = pasteKey;
    }

    public static ShowPasteRequest pasteKey(final String pasteKey) {
        return new Builder(pasteKey).build();
    }

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_paste_key", pasteKey);
        parameters.put("api_option", "show_paste");
        return parameters;
    }

    public static class Builder {
        private final String pasteKey;

        public Builder(String pasteKey) {
            this.pasteKey = pasteKey;
        }

        public ShowPasteRequest build() {
            return new ShowPasteRequest(pasteKey);
        }
    }
}
