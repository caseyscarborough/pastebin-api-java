package com.pastebin.api;

interface Converter<F, T> {

    T convert(F from);
}
