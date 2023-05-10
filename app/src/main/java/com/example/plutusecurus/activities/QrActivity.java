package com.example.plutusecurus.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.plutusecurus.R;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import java.text.DecimalFormat;

import jnr.ffi.annotations.In;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler, PaymentResultWithDataListener {

    ZXingScannerView scannerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView=new ZXingScannerView(this);
        setContentView(scannerView);

        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                            scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();

    }

    @Override
    public void handleResult(Result rawResult) {

        /*Uri uri = Uri.parse(rawResult.getText()); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        onBackPressed();*/
        String recipientPublicKey = rawResult.getText().split(",")[1];
        String recipientName = rawResult.getText().split(",")[0];
        String uid = rawResult.getText().split(",")[2];

        showPaymentTypeDialog(recipientPublicKey, recipientName, uid);

    }

    private void showPaymentTypeDialog(String recipientPubKey, String recipientName, String uid) {
        Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.select_payment_type_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        RadioGroup rg = dialog.findViewById(R.id.radio_group);
        AppCompatTextView proceed = dialog.findViewById(R.id.select_transaction_type_dialog_btn);
        AppCompatTextView cancel = dialog.findViewById(R.id.cancel_transaction_type_dialog_btn);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.eth_to_eth_transaction:
                        Intent intent1 = new Intent(QrActivity.this, PaymentActivity.class);
                        intent1.putExtra("name", recipientName);
                        intent1.putExtra("publicKey", recipientPubKey);
                        intent1.putExtra("uid", uid);
                        intent1.putExtra("paymentType", "ETH");

                        startActivity(intent1);
                        break;
                    case R.id.inr_to_eth_transaction:
                        Intent intent2 = new Intent(QrActivity.this, PaymentActivity.class);
                        intent2.putExtra("name", recipientName);
                        intent2.putExtra("publicKey", recipientPubKey);
                        intent2.putExtra("uid", uid);
                        intent2.putExtra("paymentType", "INR");

                        startActivity(intent2);
                        break;
                    default:
                        break;
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        dialog.show();
    }



    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {

    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }
}