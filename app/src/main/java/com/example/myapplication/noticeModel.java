package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class noticeModel {
    @SerializedName("id")
    private String id;
    @SerializedName("notice")
    private String notice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public noticeModel(String id, String notice) {
        this.id = id;
        this.notice = notice;
    }

    public noticeModel() {
    }
}
