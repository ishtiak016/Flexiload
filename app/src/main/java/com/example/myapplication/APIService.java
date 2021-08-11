package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @FormUrlEncoded
    @POST("registration.php")
    Call<loginModel> getStringScalar(@Field("name") String name, @Field("phone")
            String phone, @Field("email") String email , @Field("reference") String reference ,
                                 @Field("pin") String pin );

    @GET("login.php")
    Call<loginModel> performUserLogin(@Query("name") String name, @Query("pin") String pin);

    @FormUrlEncoded
    @POST("bkash.php")
    Call<loginModel> transaction(@Field("number") String number, @Field("usernumber")
            String usernumber, @Field("ammount") String ammount , @Field("title") String title ,
                                 @Field("pin") String pin,@Field("account") String account);

    @GET("balance.php")
    Call<loginModel> balanceCheck(@Query("phone") String phone);

    @GET("history.php")
    Call<List<historyModel>> historyfunction(@Query("phone") String phone);

    @FormUrlEncoded
    @POST("billpay.php")
    Call<loginModel> billpaytransaction(@Field("number") String number, @Field("bill_month")
            String bill_month, @Field("bill_number") String bill_number , @Field("ammount") String ammount ,
                             @Field("pin") String pin,@Field("title") String title );

    @FormUrlEncoded
    @POST("flexiload.php")
    Call<loginModel> flexiLoadTransaction(@Field("number") String number, @Field("usernumber")
            String usernumber, @Field("numbertype") String numbertype , @Field("ammount") String ammount ,
                                    @Field("pin") String pin,@Field("title") String title );

    @GET("flexiloadhistory.php")
    Call<List<flexiload_history_model>> flexiloadhistoryfunction(@Query("phone") String phone);

    @GET("allpakage.php")
    Call<List<all_pakage_model>> allpakageQuery(@Query("operator") String operator);

    @FormUrlEncoded
    @POST("pakagebillapi.php")
    Call<loginModel> pakagebilltransaction(@Field("minute") String minute, @Field("internet")
            String internet, @Field("sms") String sms , @Field("day") String day ,
                                      @Field("area") String area,@Field("operator") String operator
            ,@Field("regularprice") String regularprice,@Field("offerprice") String offerprice,
                                       @Field("number") String number
            ,@Field("usernumber") String usernumber,@Field("pin") String pin);

    @GET("notice.php")
    Call<noticeModel> noticeT();

    @FormUrlEncoded
    @POST("addmoneynotify.php")
    Call<loginModel> addmoney(@Field("number") String number, @Field("txnid")
            String txnid, @Field("ammount") String ammount,@Field("type") String type);

    @GET("addmoneyhistory.php")
    Call<List<add_money_history_model>> addmoneyhist(@Query("number") String number);

    @GET("billhistory.php")
    Call<List<bill_history_model>> billhistory(@Query("number") String number);
    @GET("pakagehistory.php")
    Call<List<pakageHistoryModel>> pakagehistory(@Query("number") String number);

    @GET("numberdisplay.php")
    Call<noticeModel> numberdisplay();
    @GET("profile.php")
    Call<profileModel>profilequery(@Query("phone") String phone);
    @GET("referencenumber.php")
    Call<noticeModel>referencenumber(@Query("phone") String phone);
    @GET("noticeboardall.php")
    Call<List<noticeboardModel>> allnotice();
}
