package com.example.plutusecurus.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plutusecurus.R;
import com.example.plutusecurus.data.ApiClient;
import com.example.plutusecurus.data.TransAPI;
import com.example.plutusecurus.databinding.ActivityPaymentBinding;
import com.example.plutusecurus.dtos.DepositETH;
import com.example.plutusecurus.dtos.DepositETHResponse;
import com.example.plutusecurus.dtos.ETHtoINRPaymentOrder;
import com.example.plutusecurus.model.Amount;
import com.example.plutusecurus.model.ETHtoINRResponse;
import com.example.plutusecurus.utils.SharedPreferencesConfig;
import com.google.android.material.snackbar.Snackbar;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, PaymentResultWithDataListener {
    private ActivityPaymentBinding binding;
    private TransAPI transAPI;
    SharedPreferencesConfig sharedPreferencesConfig;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private String paymentType = "", recipientName="", recipientPublicKey="", recipientUId="", paymentId ="", paymentAmt = "0";

    private String remarkCategory = "";
    private ArrayList<String> listOfCategories = new ArrayList<>(Arrays.asList("essentials", "housing", "food", "medical", "transport", "luxury", "gifts", "misc"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.payNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.paymentAmountEditText.getText().toString().isEmpty()) {
                    Snackbar.make(binding.getRoot(), "Please enter amount!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (remarkCategory.isEmpty()) {
                    Snackbar.make(binding.getRoot(), "Please select remark!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                paymentAmt = binding.paymentAmountEditText.getText().toString();

                binding.payNowBtn.setVisibility(View.GONE);
                binding.loginProgressBar.setVisibility(View.VISIBLE);

                if (paymentType.equals("INR")) {
                    createETHtoINROrder(Double.parseDouble(paymentAmt));
                } else {
                    Intent paymentStatusIntent = new Intent(PaymentActivity.this, PaymentStatusActivity.class);
                    paymentStatusIntent.putExtra("paymentId", "")
                            .putExtra("recipientName", recipientName)
                            .putExtra("recipientPublicKey", recipientPublicKey)
                            .putExtra("recipientUId", recipientUId)
                            .putExtra("paymentType", paymentType)
                            .putExtra("remark", remarkCategory)
                            .putExtra("amount", paymentAmt);

                    binding.payNowBtn.setVisibility(View.VISIBLE);
                    binding.loginProgressBar.setVisibility(View.GONE);
                    startActivity(paymentStatusIntent);
                }
            }
        });
    }

    private void createETHtoINROrder(double amountInETH) {
        transAPI.createETHtoINROrder(new Amount(amountInETH, "INR"))
                .enqueue(new Callback<ETHtoINRPaymentOrder>() {
                    @Override
                    public void onResponse(Call<ETHtoINRPaymentOrder> call, Response<ETHtoINRPaymentOrder> response) {
                        if (response.isSuccessful() && response.body()!=null) {
                            ETHtoINRPaymentOrder paymentOrder = response.body();

                            startPayment(paymentOrder.getAmount(), paymentOrder.getId());
                        }

                        binding.payNowBtn.setVisibility(View.VISIBLE);
                        binding.loginProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<ETHtoINRPaymentOrder> call, Throwable t) {
                        binding.payNowBtn.setVisibility(View.VISIBLE);
                        binding.loginProgressBar.setVisibility(View.GONE);
                        Toast.makeText(PaymentActivity.this, "Failed to convert ETH to INR! Please retry.", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void init() {
        transAPI = ApiClient.getApiClient().create(TransAPI.class);
        sharedPreferencesConfig = new SharedPreferencesConfig(this);

        paymentType = getIntent().getStringExtra("paymentType");

        recipientName = getIntent().getStringExtra("name");
        recipientPublicKey = getIntent().getStringExtra("publicKey");
        recipientUId = getIntent().getStringExtra("uid");


        binding.recieverNameEditText.setText(recipientName, TextView.BufferType.NORMAL);
        binding.recieverPublicAddressEditText.setText(recipientPublicKey, TextView.BufferType.NORMAL);



        initSpinnerView();
    }

    private void initSpinnerView() {
        binding.categorySpinner.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listOfCategories);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.categorySpinner.setAdapter(arrayAdapter);
    }

    private void startPayment(double amount, String orderId) {
        Checkout checkout = new Checkout();
        checkout.setImage(R.drawable.ic_app_logo);

        try {
            JSONObject options = new JSONObject();
            options.put("name", recipientName);
            options.put("description", "INR to ETH Transaction");
            options.put("theme.color", R.color.colorPrimary);
            options.put("currency", "INR");
            options.put("order_id", orderId);

            options.put("amount", String.valueOf((int)Math.ceil(amount*100)));

            checkout.open(PaymentActivity.this, options);

        } catch (Exception e) {
            Toast.makeText(PaymentActivity.this,"Error in payment: "+ e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private static final String TAG = "PaymentActivity";

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        remarkCategory = listOfCategories.get(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        remarkCategory = "";
    }

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        binding.payNowBtn.setVisibility(View.VISIBLE);
        binding.loginProgressBar.setVisibility(View.GONE);

        if (s != null) {
            paymentId = s;
            Intent paymentStatusIntent = new Intent(PaymentActivity.this, PaymentStatusActivity.class);
            paymentStatusIntent.putExtra("paymentId", paymentId)
                    .putExtra("recipientName", recipientName)
                    .putExtra("recipientPublicKey", recipientPublicKey)
                    .putExtra("recipientUId", recipientUId)
                    .putExtra("paymentType", paymentType)
                    .putExtra("remark", remarkCategory)
                    .putExtra("amount", paymentAmt);

            startActivity(paymentStatusIntent);

        } else {
            Toast.makeText(PaymentActivity.this,"Error in payment!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(s);
            JSONObject error = jsonObject.getJSONObject("error");
            Snackbar.make(binding.getRoot(), error.getString("description"), Snackbar.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}