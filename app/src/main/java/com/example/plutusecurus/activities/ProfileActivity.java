package com.example.plutusecurus.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import android.graphics.Bitmap;

import com.example.plutusecurus.data.ApiClient;
import com.example.plutusecurus.data.TransAPI;
import com.example.plutusecurus.dtos.GetUserResponse;
import com.example.plutusecurus.utils.SharedPreferencesConfig;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


import com.example.plutusecurus.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    CardView profilePicCard,addButton,changePassword,logout;
    ImageView profilePic,myQR,backButton;
    TextView userName,userId;
    public static final int GET_FROM_GALLERY1 = 3,GET_FROM_GALLERY = 4;

    private TransAPI transAPI;

    SharedPreferencesConfig sharedPreferencesConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilePicCard=findViewById(R.id.profile_pic_card);
        profilePic=findViewById(R.id.profile_pic_of_profile);
        addButton=findViewById(R.id.add_image);
        changePassword=findViewById(R.id.change_pass);
        logout=findViewById(R.id.logout_btn);
        myQR=findViewById(R.id.my_qr);
        userId=findViewById(R.id.userid_of_profile);
        userName=findViewById(R.id.profile_name_username);
        backButton=findViewById(R.id.back_button);

        transAPI = ApiClient.getApiClient().create(TransAPI.class);
        sharedPreferencesConfig = new SharedPreferencesConfig(this);

        if (!sharedPreferencesConfig.readImage().isEmpty())
            base64ToBitmap(sharedPreferencesConfig.readImage().substring(sharedPreferencesConfig.readImage().indexOf(",") + 1));


        userName.setText(sharedPreferencesConfig.readName());
        userId.setText(sharedPreferencesConfig.readPublicKey());

        addButton.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_PICK);
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, GET_FROM_GALLERY);
        });
        profilePicCard.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_PICK);
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, GET_FROM_GALLERY1);
        });
        backButton.setOnClickListener(v -> finish());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferencesConfig.clearAll();
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                finish();
            }
        });

        setUserDetails();
    }

    private void setUserDetails() {
        transAPI.getUser(sharedPreferencesConfig.readPublicKey())
                .enqueue(new Callback<GetUserResponse>() {
                    @Override
                    public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                        Log.d(TAG, "setUserDetails(): onResponse(): "+response);
                        if (response.isSuccessful()) {
                            Log.d(TAG, "setUserDetails(): "+response);
                            if (response.body()!=null) {
                                int totalSpending = 0;
                                GetUserResponse.Spending spending = response.body().getUser().getSpending();

                                totalSpending+=spending.getFood()+spending.getGifts()+spending.getLuxury()+spending.getMedical()+spending.getMisc()+spending.getTransport()+spending.getEssentials()+spending.getHousing();
                                /*String balance = String.valueOf(response.body().getUser().getEarning()-totalSpending);
                                balanceView.setText("Balance: ETH "+balance);*/

                                String qrData = response.body().getUser().getName()+","+response.body().getUser().get_id();
                                try {
                                    Bitmap bitmap = generateQrCodeBitmap(qrData, 512, 512);
                                    myQR.setImageBitmap(bitmap);
                                } catch (WriterException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<GetUserResponse> call, Throwable t) {
                        Log.d(TAG, "setUserDetails(): onFailure(): "+t.getMessage());

                    }
                });
    }


    private Bitmap generateQrCodeBitmap(String data, int width, int height) throws WriterException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(data, BarcodeFormat.QR_CODE, width, height);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bitmap.setPixel(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return bitmap;
    }

    private void base64ToBitmap(String base64Url) {

// Decode the Base64 URL into a byte array
        byte[] decodedBytes = Base64.decode(base64Url, Base64.DEFAULT);

// Convert the byte array into a Bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);

// Set the Bitmap to the ImageView

        profilePic.setImageBitmap(bitmap);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==GET_FROM_GALLERY1 || requestCode==GET_FROM_GALLERY){
                assert data != null;
                profilePic.setImageURI(data.getData());
            }
        }
    }

    private static final String TAG = "ProfileActivity";
}