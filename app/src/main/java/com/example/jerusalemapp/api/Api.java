package com.example.jerusalemapp.api;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api INSTANCE;
    private static ApiInterface apiInterface;
    private static final String BASE_URL = "https://newsapi.org/";
    public Api() {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    apiInterface = retrofit.create(ApiInterface.class);
}

    public static ApiInterface getApiInterface() {
        return apiInterface;
    }

    public static Api getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Api();
        }
        return INSTANCE;
    }

}
