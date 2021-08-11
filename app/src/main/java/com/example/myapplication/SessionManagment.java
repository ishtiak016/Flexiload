package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagment {
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREE_NAME="session";
    String SESSION_KEY="-1";

    public SessionManagment(Context context)
    {
        sharedpreferences=context.getSharedPreferences(SHARED_PREE_NAME,Context.MODE_PRIVATE);
        editor=sharedpreferences.edit();
    }
    public void saveSession(String phone)
    {
        //int token=user.getToken();
        editor.putString(SESSION_KEY,phone).commit();


    }
    public String getSession()
    {

        return sharedpreferences.getString(SESSION_KEY,"0");
    }


    public void removeSession(){
        editor.putString(SESSION_KEY,"0").commit();

    }
}
