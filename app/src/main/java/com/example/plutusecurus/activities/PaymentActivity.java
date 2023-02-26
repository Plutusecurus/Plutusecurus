package com.example.plutusecurus.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plutusecurus.R;
import com.example.plutusecurus.data.ApiClient;
import com.example.plutusecurus.data.TransAPI;
import com.example.plutusecurus.databinding.ActivityPaymentBinding;
import com.example.plutusecurus.dtos.DepositETH;
import com.example.plutusecurus.dtos.DepositETHResponse;
import com.example.plutusecurus.utils.SharedPreferencesConfig;
import com.google.android.material.snackbar.Snackbar;

import java.math.BigDecimal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity extends AppCompatActivity {
    private ActivityPaymentBinding binding;
    private TransAPI transAPI;
    SharedPreferencesConfig sharedPreferencesConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.payNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.paymentAmountEditText.getText().toString().isEmpty() && binding.paymentAmountINREditText.getText().toString().isEmpty()) {
                    Snackbar.make(binding.getRoot(), "Please enter amount!", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                binding.payNowBtn.setVisibility(View.GONE);
                binding.loginProgressBar.setVisibility(View.VISIBLE);

                String amount = "";
                if (!binding.paymentAmountEditText.getText().toString().isEmpty()) amount = binding.paymentAmountEditText.getText().toString();
                else {
                    double amt = Double.parseDouble(binding.paymentAmountINREditText.getText().toString());
                    amt = amt/132787.77;
                    amount = String.valueOf(amt);
                }

                depositEth(amount, binding.recieverPublicAddressEditText.getText().toString());
            }
        });
    }

    private void init() {
        transAPI = ApiClient.getApiClient().create(TransAPI.class);
        sharedPreferencesConfig = new SharedPreferencesConfig(this);

        String recipientName = getIntent().getStringExtra("name");
        String recipientPublicKey = getIntent().getStringExtra("publicKey");

        binding.recieverNameEditText.setText(recipientName, TextView.BufferType.NORMAL);
        binding.recieverPublicAddressEditText.setText(recipientPublicKey, TextView.BufferType.NORMAL);


    }

    private void depositEth(String amount, String recipientPublicAddress) {

        Log.d(TAG, "amount: "+amount);

        transAPI.depositETH(new DepositETH(
                amount,
                sharedPreferencesConfig.readPrivateKey(),
                recipientPublicAddress,
                sharedPreferencesConfig.readPublicKey()
        )).enqueue(new Callback<DepositETHResponse>() {
            @Override
            public void onResponse(Call<DepositETHResponse> call, Response<DepositETHResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body()!=null) {
                        Toast.makeText(PaymentActivity.this, "Deposit Successful!", Toast.LENGTH_SHORT).show();
                        transferEth(amount, recipientPublicAddress);
                    }
                } else {
                    Toast.makeText(PaymentActivity.this, "Deposit Successful!", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "depositEth() onResponse(): "+response);

                    startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                    finish();

                    binding.payNowBtn.setVisibility(View.VISIBLE);
                    binding.loginProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<DepositETHResponse> call, Throwable t) {
                Toast.makeText(PaymentActivity.this, "Deposit Successful!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "depositEth() onResponse(): "+t.getMessage());

                startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                finish();

                binding.payNowBtn.setVisibility(View.VISIBLE);
                binding.loginProgressBar.setVisibility(View.GONE);

            }
        });
    }

    private void transferEth(String amount, String recipientPublicAddress) {

        Log.d(TAG, "amount: "+amount);

        transAPI.transferETH(new DepositETH(
                amount,
                sharedPreferencesConfig.readPrivateKey(),
                recipientPublicAddress,
                sharedPreferencesConfig.readPublicKey()
        )).enqueue(new Callback<DepositETHResponse>() {
            @Override
            public void onResponse(Call<DepositETHResponse> call, Response<DepositETHResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null) {
                        Toast.makeText(PaymentActivity.this, "Transfer Successful!", Toast.LENGTH_SHORT).show();
                        binding.payNowBtn.setVisibility(View.GONE);
                        binding.loginProgressBar.setVisibility(View.VISIBLE);
                        startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                        finish();
                    }
                } else {
                    Toast.makeText(PaymentActivity.this, "Transfer Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                    finish();
                    Log.d(TAG, "onResponse(): "+response);
                    binding.payNowBtn.setVisibility(View.GONE);
                    binding.loginProgressBar.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<DepositETHResponse> call, Throwable t) {
                Toast.makeText(PaymentActivity.this, "Transfer Successful!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse(): "+t.getMessage());
                startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private static final String TAG = "PaymentActivity";
}