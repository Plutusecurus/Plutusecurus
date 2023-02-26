package com.example.plutusecurus.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plutusecurus.R;
import com.example.plutusecurus.activities.QrActivity;
import com.example.plutusecurus.data.ApiClient;
import com.example.plutusecurus.data.TransAPI;
import com.example.plutusecurus.dtos.GetUserResponse;
import com.example.plutusecurus.model.History;
import com.example.plutusecurus.utils.SharedPreferencesConfig;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WalletFragment extends Fragment {

    ImageView profilePicture,userQr;
    TextView userId, username;
    CardView payButton;
    TextView balanceView;
    RecyclerView historyRecyclerView;

    private TransAPI transAPI;

    SharedPreferencesConfig sharedPreferencesConfig;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_wallet,container,false);
        profilePicture= view.findViewById(R.id.profile_picture);
        userId=view.findViewById(R.id.userid_of_user);
        username=view.findViewById(R.id.profile_name_username);
        userQr=view.findViewById(R.id.qr_button);
        payButton=view.findViewById(R.id.pay_button);
        balanceView=view.findViewById(R.id.balance);
        historyRecyclerView = view.findViewById(R.id.historyRecyclerView);
        transAPI = ApiClient.getApiClient().create(TransAPI.class);
        sharedPreferencesConfig = new SharedPreferencesConfig(requireContext());

        if (!sharedPreferencesConfig.readImage().isEmpty())
            base64ToBitmap(sharedPreferencesConfig.readImage().substring(sharedPreferencesConfig.readImage().indexOf(",") + 1));

//        try {
//            Bitmap bitmap = generateQrCodeBitmap("Hello, Hello!", 512, 512);
//
//            userQr.setImageBitmap(bitmap);
//        } catch (WriterException e) {
//            e.printStackTrace();
//
//        }

        HistoryAdapter historyAdapter = new HistoryAdapter();
        ArrayList<History> arrayList = new ArrayList<>();

        for(int i= 0; i < 20; i++){
            History history = new History("ABCDEF" + i, "12/12/2012", String.valueOf(i));
            arrayList.add(history);
        }

        historyAdapter.updateTransaction(arrayList);
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        historyRecyclerView.setAdapter(historyAdapter);

        setUserDetails();

        /*payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), QrActivity.class);
                startActivity(intent);
            }
        });*/

        return view;

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

        profilePicture.setImageBitmap(bitmap);
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

                                username.setText(response.body().getUser().getName());

                                userId.setText(response.body().getUser().get_id());

                                String qrData = response.body().getUser().getName()+","+response.body().getUser().get_id();
                                try {
                                    Bitmap bitmap = generateQrCodeBitmap(qrData, 512, 512);
                                    userQr.setImageBitmap(bitmap);
                                } catch (WriterException e) {
                                    throw new RuntimeException(e);
                                }

                                payButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(getActivity(), QrActivity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<GetUserResponse> call, Throwable t) {
                        Log.d(TAG, "setUserDetails(): onFailure(): "+t.getMessage());

                    }
                });
    }

    private static final String TAG = "WalletFragment";
} 
