package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class noticeboardModel {
    @SerializedName("id")
    private String id;
    @SerializedName("noticeheader")
    private String noticeheader;
    @SerializedName("noticedetails")
    private String noticedetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticeheader() {
        return noticeheader;
    }

    public void setNoticeheader(String noticeheader) {
        this.noticeheader = noticeheader;
    }

    public String getNoticedetails() {
        return noticedetails;
    }

    public void setNoticedetails(String noticedetails) {
        this.noticedetails = noticedetails;
    }
}
