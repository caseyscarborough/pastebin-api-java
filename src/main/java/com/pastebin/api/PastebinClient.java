package com.pastebin.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pastebin.api.model.Paste;
import com.pastebin.api.request.ListRequest;
import com.pastebin.api.request.PasteRequest;
import com.pastebin.api.response.ListResponseItem;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PastebinClient {

    private static final String BASE_API_URL = "https://pastebin.com/api";
    private static final MediaType MEDIA_TYPE = MediaType.get("application/x-www-form-urlencoded");

    private final String developerKey;
    private final OkHttpClient client = new OkHttpClient();
    private final XmlMapper mapper = new XmlMapper();
    private String userKey;

    private PastebinClient(String developerKey, String userKey) {
        this.developerKey = developerKey;
        this.userKey = userKey;
    }

    public static PastebinClient.Builder builder() {
        return new Builder();
    }

    public String login(final String username, final String password) {
        if (this.userKey != null) {
            return this.userKey;
        }

        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_user_name", username);
        parameters.put("api_user_password", password);
        this.userKey = request("api_login.php", parameters);
        return this.userKey;
    }

    public List<Paste> list(ListRequest request) {
        final String xml = request("api_post.php", request.getParameters());
        if (xml.toLowerCase(Locale.ROOT).contains("no pastes found")) {
            return new ArrayList<>();
        }

        try {
            final ListResponseItem[] items = mapper.readValue("<response>" + xml + "</response>", ListResponseItem[].class);
            Converter<List<ListResponseItem>, List<Paste>> converter = new ListResponseConverter();
            return converter.convert(Arrays.asList(items));
        } catch (JsonProcessingException e) {
            throw new PastebinException("Could not parse response from Pastebin API: " + e.getMessage(), e);
        }
    }

    public String paste(final PasteRequest request) {
        return request("api_post.php", request.getParameters());
    }

    private String request(final String endpoint, final Map<String, String> parameters) {
        StringBuilder postBody = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            if (!first) {
                postBody.append("&");
            }
            postBody.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            first = false;
        }

        postBody.append("&api_dev_key=").append(developerKey);

        if (this.userKey != null) {
            postBody.append("&api_user_key=").append(this.userKey);
        }

        final String url = BASE_API_URL + "/" + endpoint;
        final Request request = new Request.Builder()
            .url(url)
            .post(RequestBody.create(postBody.toString(), MEDIA_TYPE))
            .build();

        try (Response response = client.newCall(request).execute()) {
            final ResponseBody responseBody = response.body();
            if (responseBody == null) {
                throw new PastebinException("Could not get response body from " + url);
            }
            final String body = responseBody.string();
            if (body.toLowerCase(Locale.ROOT).startsWith("bad api request")) {
                throw new PastebinException(body.split(", ")[1]);
            }
            return body;
        } catch (IOException e) {
            throw new PastebinException("Unable to make request to to " + url + ": " + e.getMessage(), e);
        }
    }

    public static class Builder {
        private String developerKey;
        private String userKey;

        public Builder() {
        }

        public Builder developerKey(final String developerKey) {
            this.developerKey = developerKey;
            return this;
        }

        public Builder userKey(final String userKey) {
            this.userKey = userKey;
            return this;
        }

        public PastebinClient build() {
            if (this.developerKey == null) {
                throw new IllegalStateException("Developer key is required to create Pastebin Client.");
            }
            return new PastebinClient(developerKey, userKey);
        }
    }
}
