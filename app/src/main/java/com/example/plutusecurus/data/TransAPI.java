package com.example.plutusecurus.data;

import com.example.plutusecurus.dtos.RegisterResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface TransAPI {
    @Multipart
    @POST("user/register")
    Call<RegisterResponse> createUser(
            @Part("profilePic") MultipartBody.Part profilePic,
            @Part("account") MultipartBody.Part account,
            @Part("name") MultipartBody.Part name
    );

}
