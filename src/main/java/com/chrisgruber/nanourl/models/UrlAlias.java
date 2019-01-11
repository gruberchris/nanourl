package com.chrisgruber.nanourl.models;

import org.springframework.data.annotation.Id;

public class UrlAlias {
    @Id
    public int id;

    public String url;
    public String aliasUrl;

    public UrlAlias() {}

    public UrlAlias(int id, String url, String aliasUrl) {
        this.id = id;
        this.url = url;
        this.aliasUrl = aliasUrl;
    }

    public int get_id() { return this.id; }
    public void set_id(int id) { this.id = id; }

    public String get_url() { return this.url; }
    public void set_url(String url) { this.url = url; }

    public String get_aliasUrl() { return this.aliasUrl; }
    public void set_aliasUrl(String aliasUrl) { this.aliasUrl = aliasUrl; }
}