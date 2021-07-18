package com.pastebin.api;

import com.pastebin.api.model.User;
import com.pastebin.api.response.UserResponse;

class UserResponseConverter implements Converter<UserResponse, User> {
    @Override
    public User convert(UserResponse from) {
        User user = new User();
        user.setAccountType(AccountType.find(from.getAccountType()));
        user.setUsername(from.getName());
        user.setExpiration(from.getExpiration());
        user.setAvatarUrl(from.getAvatarUrl());
        user.setPrivacy(Visibility.find(from.getPrivacy()));
        user.setWebsite(from.getWebsite());
        user.setEmail(from.getEmail());
        user.setLocation(from.getLocation());
        return user;
    }
}
