package com.example.recruitmenttask.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Details {

    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("url")
    @Expose
    private String mUrl;
    @SerializedName("sort_key")
    @Expose
    private String mSortKey;
    @SerializedName("description")
    @Expose
    private String mDescription;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getSortKey() {
        return mSortKey;
    }

    public void setSortKey(String sortKey) {
        mSortKey = sortKey;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
