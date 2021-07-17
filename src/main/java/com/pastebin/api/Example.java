package com.pastebin.api;

import com.pastebin.api.request.PasteRequest;

public class Example {

    public static void main(String[] args) {
        final PastebinClient client = PastebinClient
            .builder()
            .developerKey(System.getenv("PASTEBIN_API_KEY"))
            // User Key is optional, this can be used if you would like
            // to associate your pastes with your account. You can additionally
            // set this using the client.login() method on the client if you
            // don't already have a user key.
            .userKey(System.getenv("PASTEBIN_USER_KEY"))
            .build();

        final String userKey = client.login(
            System.getenv("PASTEBIN_USERNAME"),
            System.getenv("PASTEBIN_PASSWORD")
        );
        System.out.println(userKey);

        final PasteRequest request = PasteRequest
            .content("print(\"Hello, world!\")")
            .visibility(Visibility.PRIVATE)
            .format(Format.PYTHON)
            .name("Hello World in Python")
            .build();

        final String url = client.paste(request);
        System.out.println(url);
    }
}
