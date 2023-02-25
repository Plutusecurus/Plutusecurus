package com.example.plutusecurus.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


import com.example.plutusecurus.R;

public class ProfileActivity extends AppCompatActivity {
    CardView profilePicCard,addButton,changePassword,logout,payInINR,payInEth;
    ImageView profilePic,myQR,backButton;
    TextView userName,userId;
    public static final int GET_FROM_GALLERY1 = 3,GET_FROM_GALLERY = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilePicCard=findViewById(R.id.profile_pic_card);
        profilePic=findViewById(R.id.profile_pic);
        addButton=findViewById(R.id.add_image);
        changePassword=findViewById(R.id.change_pass);
        logout=findViewById(R.id.logout);
        myQR=findViewById(R.id.my_qr);
        userId=findViewById(R.id.userid);
        userName=findViewById(R.id.profile_name);
        backButton=findViewById(R.id.back_button);
        payInEth=findViewById(R.id.eth_qr_selector);
        payInINR=findViewById(R.id.inr_qr_selector);

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
        try {
            Bitmap bitmap = generateQrCodeBitmap("Hello, HUMANS!", 512, 512);
            myQR.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        payInINR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bitmap bitmap = generateQrCodeBitmap("Hello, World!", 512, 512);
                    myQR.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
        payInEth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bitmap bitmap = generateQrCodeBitmap("Hello, HUMANS!", 512, 512);
                    myQR.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
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
}