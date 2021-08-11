package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class flexiload_history_model {
    @SerializedName("id")
    private String id;
    @SerializedName("number")
    private String number;
    @SerializedName("usernumber")
    private String usernumber;
    @SerializedName("numbertype")
    private String numbertype;
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
    @SerializedName("account")
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

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

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getNumbertype() {
        return numbertype;
    }

    public void setNumbertype(String numbertype) {
        this.numbertype = numbertype;
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
