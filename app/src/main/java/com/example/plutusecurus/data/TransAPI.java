package com.example.plutusecurus.data;

import com.example.plutusecurus.dtos.GetUserResponse;
import com.example.plutusecurus.dtos.RegisterResponse;
import com.example.plutusecurus.model.AddExpenseBody;
import com.example.plutusecurus.model.AddExpenseResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface TransAPI {
    @Multipart
    @POST("user/register")
    Call<RegisterResponse> createUser(
            @Part MultipartBody.Part profilePic,
            @Part MultipartBody.Part account,
            @Part MultipartBody.Part name
    );

    @POST("user/add-expense")
    Call<AddExpenseResponse> addExpense(@Body AddExpenseBody addExpenseBody );

    @GET("user/{public_key}")
    Call<GetUserResponse> getUser();

}
