package com.chrisgruber.nanourl.models;

import org.springframework.data.annotation.Id;

public class UrlAlias {
    @Id
    private int id;
    private String url;
    private String aliasUrl;
    private String aliasPath;

    public String getAliasPath() {
        return aliasPath;
    }

    public void setAliasPath(String aliasPath) {
        this.aliasPath = aliasPath;
    }

    public UrlAlias() {}

    public UrlAlias(int id, String url, String aliasUrl, String aliasPath) {
        this.id = id;
        this.url = url;
        this.aliasUrl = aliasUrl;
        this.aliasPath = aliasPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAliasUrl() {
        return aliasUrl;
    }

    public void setAliasUrl(String aliasUrl) {
        this.aliasUrl = aliasUrl;
    }
}