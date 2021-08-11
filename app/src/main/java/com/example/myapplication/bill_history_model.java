package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class bill_history_model {

    @SerializedName("id")
    private String id;
    @SerializedName("number")
    private String number;
    @SerializedName("bill_month")
    private String bill_month;
    @SerializedName("bill_number")
    private String bill_number;
    @SerializedName("ammount")
    private String ammount;
    @SerializedName("title")
    private String title;
    @SerializedName("status")
    private String status;
    @SerializedName("time")
    private String time;
    @SerializedName("date")
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBill_month() {
        return bill_month;
    }

    public void setBill_month(String bill_month) {
        this.bill_month = bill_month;
    }

    public String getBill_number() {
        return bill_number;
    }

    public void setBill_number(String bill_number) {
        this.bill_number = bill_number;
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
