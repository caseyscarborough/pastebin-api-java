# Pastebin API Java Client

This is a easy-to-use and fluet Java API client for the pastebin.com API.

## Dependency

You can use either Jitpack or GitHub Packages for including this in your project. Add either of the following to your `build.gradle` file:

### Jitpack

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.caseyscarborough:pastebin-api-java:0.1.0'
}
```

### GitHub

```groovy
repositories {
    maven { url 'https://maven.pkg.github.com/caseyscarborough/pastebin-api-java' }
}

dependencies {
    implementation 'com.pastebin.api:pastebin-api-java:0.1.0'
}
```

## Usage

See the [Example.java](https://github.com/caseyscarborough/pastebin-api-java/blob/master/src/main/java/com/pastebin/api/Example.java) for a complete API example.

### Create a New Client

Create a new client using the `PastebinClient` builder:

```java
final PastebinClient client = PastebinClient
    .builder()
    .developerKey("my-developer-key")
    // optional
    .userKey("my-user-key")
    .build();
```

### Login/Create User Key

Retrieve a user key if you don't already have one, and you would like to create pastes that are associated with your account. This will automatically assign the user key to the client for reuse in later calls.

```java
final String userKey = client.login("username", "password");
System.out.println(userKey);
```

### Create a New Paste

You can create a new paste here. All fields are optional except for `content`.

```java
final PasteRequest request = PasteRequest
    .content("print(\"Hello, world!\")")
    // the remaining fields are optional
    .visibility(Visibility.PRIVATE)
    .format(Format.PYTHON)
    .name("Hello World in Python")
    .expiration(Expiration.ONE_HOUR)
    // the folder key can be found in the URL of your folder
    .folderKey("N2a8jwyY")
    .build();

// returns the URL of the newly created paste.
final String url = client.paste(request);
System.out.println(url);
```

### List Your Pastes

Retrieve a list of your pastes. This takes a single parameter, the amount of pastes to return. It defaults to 50 with a min of 1 and a max of 100.

```java
// Get a list of pastes on your account.
final List<Paste> pastes = client.list(5);
for (Paste paste : pastes) {
    System.out.println("Title: " + paste.getTitle());
    System.out.println("Key: " + paste.getKey());
    System.out.println("URL: " + paste.getUrl());
    System.out.println("Date: " + paste.getDate());
    System.out.println("Expiration: " + paste.getExpiration());
    System.out.println("Format: " + paste.getFormat().getName());
    System.out.println("Size: " + paste.getSize());
    System.out.println("Hits: " + paste.getHits());
    System.out.println("Visibility: " + paste.getVisibility().getName());
    System.out.println();
}
```

### Get Account Details

Retrieve your accounts information:

```java
client.user();
```

### Delete a Paste

Delete a paste on your account:

```java
client.delete("qHrK7Tq7");
```

### Retrieve a Paste from Your Account

This is used to retrieve a paste from your account. Can be any public, private, or unlisted paste.

```java
client.getUserPaste("HWAfaWmg");
```

### Retrieve a Public or Unlisted Paste

This is for any public or unlisted paste (does not need to be your own account).

```java
client.getPaste("BPaf5niB");
```
