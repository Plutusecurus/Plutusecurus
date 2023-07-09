package com.example.plutusecurus.data;

import com.example.plutusecurus.dtos.DepositETH;
import com.example.plutusecurus.dtos.DepositETHResponse;
import com.example.plutusecurus.dtos.GetUserResponse;
import com.example.plutusecurus.dtos.RegisterResponse;
import com.example.plutusecurus.model.Account;
import com.example.plutusecurus.model.AddExpenseBody;
import com.example.plutusecurus.model.AddExpenseResponse;
import com.example.plutusecurus.model.AddIncomeBody;
import com.example.plutusecurus.model.AddIncomeResponse;
import com.example.plutusecurus.model.Amount;
import com.example.plutusecurus.model.ETHtoINRResponse;
import com.example.plutusecurus.model.LoginBody;
import com.example.plutusecurus.model.LoginResponse;
import com.example.plutusecurus.model.WalletTransactionResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface TransAPI {
    @Multipart
    @POST("user/register")
    Call<RegisterResponse> createUser(
            @Part MultipartBody.Part profilePic,
            @Part MultipartBody.Part account,
            @Part MultipartBody.Part password,
            @Part MultipartBody.Part name,
            @Part MultipartBody.Part upiID
    );

    @POST("user/login")
    Call<LoginResponse> loginUser(@Body LoginBody loginBody);



    @POST("user/add-expense")
    Call<AddExpenseResponse> addExpense(@Body AddExpenseBody addExpenseBody );

    @POST("user/add-income")
    Call<AddIncomeResponse> addIncome(@Body AddIncomeBody addIncomeBody );

    @GET("user/{public_key}")
    Call<GetUserResponse> getUser(@Path("public_key") String public_key);

    @POST("user/deposit")
    Call<DepositETHResponse> depositETH(@Body DepositETH depositETH);

    @POST("user/transfer")
    Call<DepositETHResponse> transferETH(@Body DepositETH depositETH);

    @POST("user/transactions")
    Call<WalletTransactionResponse> getAllWalletTransactions(@Body Account account);

    @POST("user/convertETHtoINR")
    Call<ETHtoINRResponse> convertETHtoINR(@Body Amount amount);
}
