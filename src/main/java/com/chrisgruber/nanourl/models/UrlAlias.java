package com.chrisgruber.nanourl.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urlAlias")
public class UrlAlias {
    @Id
    private long id;
    private String url;
    private String aliasUrl;
    @Indexed(unique = true)
    private String aliasPath;
    private int totalRedirects;
    @DBRef
    private UserProfile ownerUserProfile;

    public UrlAlias() {

    }

    public UrlAlias(long id, String url, String aliasUrl, String aliasPath, int totalRedirects, UserProfile ownerUserProfile) {
        this.id = id;
        this.url = url;
        this.aliasUrl = aliasUrl;
        this.aliasPath = aliasPath;
        this.totalRedirects = totalRedirects;
        this.ownerUserProfile = ownerUserProfile;
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

    public String getAliasPath() {
        return aliasPath;
    }

    public void setAliasPath(String aliasPath) {
        this.aliasPath = aliasPath;
    }

    public int getTotalRedirects() {
        return totalRedirects;
    }

    public void setTotalRedirects(int totalRedirects) {
        this.totalRedirects = totalRedirects;
    }

    public UserProfile getOwnerUserProfile() {
        return ownerUserProfile;
    }

    public void setOwnerUserProfile(UserProfile ownerUserProfile) {
        this.ownerUserProfile = ownerUserProfile;
    }

    @Override
    public String toString() {
        return "UrlAlias{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", aliasUrl='" + aliasUrl + '\'' +
                ", aliasPath='" + aliasPath + '\'' +
                ", totalRedirects=" + totalRedirects +
                ", ownerUserProfile=" + ownerUserProfile +
                '}';
    }
}