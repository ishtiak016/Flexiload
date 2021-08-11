package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class loginModel {
    @SerializedName("responseoff")
    private String responseoff;


    public loginModel(String responseoff) {
        this.responseoff = responseoff;
    }

    public loginModel() {
    }

    public String getResponseoff() {
        return responseoff;
    }

    public void setResponseoff(String responseoff) {
        this.responseoff = responseoff;
    }
}
