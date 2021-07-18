package com.pastebin.api;

import com.pastebin.api.model.Paste;
import com.pastebin.api.model.User;
import com.pastebin.api.request.PasteRequest;

import java.util.List;

final class Example {

    public static void main(String[] args) {
        // Create the new API client.
        final PastebinClient client = PastebinClient
            .builder()
            .developerKey(System.getenv("PASTEBIN_API_KEY"))
            // User Key is optional, this can be used if you would like
            // to associate your pastes with your account. You can additionally
            // set this using the client.login() method on the client if you
            // don't already have a user key.
            .userKey(System.getenv("PASTEBIN_USER_KEY"))
            .build();

        // Login if you don't have a user key already. This will create a user
        // key and set it on your client automatically. This key never expires so you
        // can use it indefinitely without logging in again.
        final String userKey = client.login(
            System.getenv("PASTEBIN_USERNAME"),
            System.getenv("PASTEBIN_PASSWORD")
        );
        System.out.println("User key - " + userKey);

        // Create a new paste
        final PasteRequest pasteRequest = PasteRequest
            .content("print(\"Hello, world!\")")
            .visibility(Visibility.PRIVATE)
            .format(Format.PYTHON)
            .name("Hello World in Python")
            .expiration(Expiration.ONE_HOUR)
            .folderKey("Y4Z9DqQk")
            .build();

        final String url = client.paste(pasteRequest);
        System.out.println("Newly created paste - " + url);

        // Get a list of pastes on your account.
        final List<Paste> pastes = client.list(5);
        for (Paste paste : pastes) {
            System.out.println();
            System.out.println("Paste " + paste.getTitle());
            System.out.println("  - Key: " + paste.getKey());
            System.out.println("  - URL: " + paste.getUrl());
            System.out.println("  - Date: " + paste.getDate());
            System.out.println("  - Expiration Date: " + paste.getExpireDate());
            System.out.println("  - Format: " + paste.getFormat().getName());
            System.out.println("  - Size: " + paste.getSize());
            System.out.println("  - Hits: " + paste.getHits());
            System.out.println("  - Visibility: " + paste.getVisibility().getName());
        }

        // Retrieve your user account's details.
        final User user = client.user();
        System.out.println("User details - " + user);

        // Delete a paste on your account.
        client.delete("qHrK7Tq7");

        // This to retrieve a paste from your account. Can be any public, private, or unlisted paste.
        client.getUserPaste("HWAfaWmg");

        // This is for any public or unlisted paste.
        client.getPaste("BPaf5niB");
    }
}
