package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class all_pakage_model {
    @SerializedName("id")
    private String id;
    @SerializedName("minute")
    private String minute;
    @SerializedName("sms")
    private String sms;
    @SerializedName("gb")
    private String gb;
    @SerializedName("day")
    private String day;
    @SerializedName("offerprice")
    private String offerprice;
    @SerializedName("regularprice")
    private String regularprice;
    @SerializedName("operator")
    private String operator;
    @SerializedName("area")
    private String area;
    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getGb() {
        return gb;
    }

    public void setGb(String gb) {
        this.gb = gb;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOfferprice() {
        return offerprice;
    }

    public void setOfferprice(String offerprice) {
        this.offerprice = offerprice;
    }

    public String getRegularprice() {
        return regularprice;
    }

    public void setRegularprice(String regularprice) {
        this.regularprice = regularprice;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
