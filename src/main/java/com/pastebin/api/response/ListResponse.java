package com.pastebin.api.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "response")
public class ListResponse {

    @JacksonXmlProperty(localName = "paste")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ListResponseItem> items;

    public List<ListResponseItem> getItems() {
        return items;
    }

    public void setItems(List<ListResponseItem> items) {
        this.items = items;
    }
}
