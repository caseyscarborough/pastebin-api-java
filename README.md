# Pastebin API Java Client

This is a simple Java API client for the pastebin.com API.

## Dependency

Add the following to your build.gradle:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.caseyscarborough:pastebin-api-java:0.0.1'
}
```

## Usage

Create a new client using the `PastebinClient` builder:

```java
final PastebinClient client = PastebinClient
    .builder()
    .developerKey("my-developer-key")
    // optional
    .userKey("my-user-key") 
    .build();
```

Retrieve a user key if you don't already have one, and you would like to create pastes that are associated with your account. This will automatically assign the user key to the client for reuse in later calls.

```java
final String userKey = client.login("username", "password");
System.out.println(userKey);
```

Create a new paste.

```java
final PasteRequest request = PasteRequest
    .content("print(\"Hello, world!\")")
    .visibility(Visibility.PRIVATE)
    .format(Format.PYTHON)
    .name("Hello World in Python")
    .build();

// returns the URL of the newly created paste.
final String url = client.paste(request);
System.out.println(url);
```

## TODO

- Add support for listing pastes for a specific user.
- Add paste deletion.
- Retrieving user information and settings.
- Get raw output of user's pastes including 'private' pastes.
