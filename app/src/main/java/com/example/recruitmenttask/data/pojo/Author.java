package com.example.recruitmenttask.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("url")
    @Expose
    private String mUrl;

    @SerializedName("href")
    @Expose
    private String mDetailsLink;

    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("slug")
    @Expose
    private String mSlug;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getDetailsLink() {
        return mDetailsLink;
    }

    public void setDetailsLink(String detailsLink) {
        mDetailsLink = detailsLink;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }
}
