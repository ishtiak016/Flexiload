package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class add_money_history_model {
    @SerializedName("id")
    private String id;
    @SerializedName("number")
    private String number;
    @SerializedName("txnid")
    private String txnid;
    @SerializedName("ammount")
    private String ammount;
    @SerializedName("status")
    private String status;
    @SerializedName("time")
    private String time;
    @SerializedName("date")
    private String date;
    @SerializedName("type")
    private String type;

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

    public String getTxnid() {
        return txnid;
    }

    public void setTxnid(String txnid) {
        this.txnid = txnid;
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
