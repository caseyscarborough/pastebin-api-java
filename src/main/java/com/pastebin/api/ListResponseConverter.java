package com.pastebin.api;

import com.pastebin.api.model.Paste;
import com.pastebin.api.response.ListResponseItem;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

class ListResponseConverter implements Converter<List<ListResponseItem>, List<Paste>> {

    @Override
    public List<Paste> convert(List<ListResponseItem> from) {
        List<Paste> output = new ArrayList<>();
        for (ListResponseItem item : from) {
            Paste paste = new Paste();
            paste.setKey(item.getKey());
            paste.setTitle(item.getTitle());
            paste.setSize(item.getSize());
            paste.setFormat(Format.find(item.getFormatShort()));
            paste.setUrl(item.getUrl());
            paste.setHits(item.getHits());
            if (item.getExpireDate() != 0) {
                paste.setExpireDate(getTimeFromEpoch(item.getExpireDate()));
            }
            paste.setVisibility(Visibility.find(item.getPrivacy()));
            paste.setDate(getTimeFromEpoch(item.getDate()));
            output.add(paste);
        }
        return output;
    }

    private LocalDateTime getTimeFromEpoch(long epoch) {
        return Instant.ofEpochSecond(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
