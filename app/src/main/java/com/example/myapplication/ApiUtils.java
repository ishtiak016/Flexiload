package com.example.myapplication;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://ptworkers.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
