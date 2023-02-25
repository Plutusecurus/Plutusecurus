package com.example.plutusecurus.data;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://2478-2405-201-801d-90e4-9839-4f54-8f09-87d8.in.ngrok.io/";
    private static final String TAG = ApiClient.class.getName();
    //private static final String BASE_URL = "http://13.59.151.77:4000/";
    private static Retrofit retrofit = null;
    public static Retrofit getApiClient() {
        Log.v(TAG, "getApiClient Initiated");
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static String getBaseUrl() {
        Log.v(TAG, "getBaseUrl Initiated");
        return BASE_URL;
    }
}
