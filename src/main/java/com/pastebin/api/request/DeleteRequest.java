package com.pastebin.api.request;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest implements Request {

    private final String pasteKey;

    private DeleteRequest(final String pasteKey) {
        this.pasteKey = pasteKey;
    }

    public static DeleteRequest pasteKey(final String pasteKey) {
        return new DeleteRequest.Builder(pasteKey).build();
    }

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_option", "delete");
        parameters.put("api_paste_key", pasteKey);
        return parameters;
    }

    public static class Builder {
        private final String pasteKey;

        public Builder(final String pasteKey) {
            this.pasteKey = pasteKey;
        }

        public DeleteRequest build() {
            return new DeleteRequest(pasteKey);
        }
    }
}
