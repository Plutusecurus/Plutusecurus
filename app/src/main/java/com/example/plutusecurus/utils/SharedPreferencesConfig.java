package com.example.plutusecurus.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Objects;


public class SharedPreferencesConfig {
    private final String TAG = this.getClass().getName();
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferencesConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("com.example.plutusecurus.preferences", Context.MODE_PRIVATE);
    }

    public void clearAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("PRIVATE_KEY");
        editor.remove("PUBLIC_KEY");
        editor.remove("NAME");
        editor.remove("IMAGE");
        editor.apply();
    }

    public void writePrivateKey(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("PRIVATE_KEY", key);
        editor.apply();
    }

    public String readPrivateKey() {
        return sharedPreferences.getString("PRIVATE_KEY", "");
    }

    public void writePublicKey(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("PUBLIC_KEY", key);
        editor.apply();
    }

    public String readPublicKey() {
        return sharedPreferences.getString("PUBLIC_KEY", "");
    }

    public void writeName(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", name);
        editor.apply();
    }

    public String readName() {
        return sharedPreferences.getString("NAME", "");
    }

    public void writeImage(String image) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("IMAGE", image);
        editor.apply();
    }

    public String readImage() {
        return sharedPreferences.getString("IMAGE", "");
    }

//    public void writeCategories(String category) {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("CATEGORY", category);
//        editor.apply();
//    }
//    public void writeAddress(String address) {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("ADDRESS", address);
//        editor.apply();
//    }
//
//    public void writeAmount(String val) {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("AMOUNT", val);
//        editor.apply();
//    }
}
