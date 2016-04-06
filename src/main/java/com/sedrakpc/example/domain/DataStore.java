package com.sedrakpc.example.domain;

/**
 * User: Sedrak Dalaloyan
 * Date: 6/13/15
 * Time: 21:36
 */
public class DataStore {

    private String id;
    private String name;
    private String contentType;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
