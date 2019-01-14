package com.chrisgruber.nanourl.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urlAlias")
public class UrlAlias {
    @Id
    private long id;
    private String url;
    private String aliasUrl;
    private String aliasPath;
    private int totalRedirects;

    public String getAliasPath() {
        return aliasPath;
    }

    public void setAliasPath(String aliasPath) {
        this.aliasPath = aliasPath;
    }

    public UrlAlias() {
    }

    public UrlAlias(long id, String url, String aliasUrl, String aliasPath, int totalRedirects) {
        this.id = id;
        this.url = url;
        this.aliasUrl = aliasUrl;
        this.aliasPath = aliasPath;
        this.totalRedirects = totalRedirects;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getTotalRedirects() {
        return totalRedirects;
    }

    public void setTotalRedirects(int totalRedirects) {
        this.totalRedirects = totalRedirects;
    }

    @Override
    public String toString() {
        return "UrlAlias{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", aliasUrl='" + aliasUrl + '\'' +
                ", aliasPath='" + aliasPath + '\'' +
                ", totalRedirects=" + totalRedirects +
                '}';
    }
}