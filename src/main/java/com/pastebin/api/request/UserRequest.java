package com.pastebin.api.request;

import java.util.HashMap;
import java.util.Map;

public class UserRequest implements Request {

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_option", "userdetails");
        return parameters;
    }
}
