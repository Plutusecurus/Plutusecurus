package com.example.plutusecurus.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plutusecurus.R;
import com.example.plutusecurus.activities.PlannerActivity;
import com.example.plutusecurus.activities.ProfileActivity;
import com.example.plutusecurus.activities.QrActivity;
import com.example.plutusecurus.model.History;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.ArrayList;

public class WalletFragment extends Fragment {

    ImageView profilePicture,userQr;
    TextView userId, username;
    CardView payButton;
    TextView balance;
    RecyclerView historyRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_wallet,container,false);
        profilePicture= view.findViewById(R.id.profile_picture);
        userId=view.findViewById(R.id.userid);
        username=view.findViewById(R.id.profile_name);
        userQr=view.findViewById(R.id.qr_button);
        payButton=view.findViewById(R.id.pay_button);
        balance=view.findViewById(R.id.balance);
        historyRecyclerView = view.findViewById(R.id.historyRecyclerView);
        try {
            Bitmap bitmap = generateQrCodeBitmap("Hello, Hello!", 512, 512);

            userQr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();

        }

        HistoryAdapter historyAdapter = new HistoryAdapter();
        ArrayList<History> arrayList = new ArrayList<>();

        for(int i= 0; i < 20; i++){
            History history = new History("ABCDEF" + i, "12/12/2012", String.valueOf(i));
            arrayList.add(history);
        }

        historyAdapter.updateTransaction(arrayList);
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        historyRecyclerView.setAdapter(historyAdapter);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), QrActivity.class);
                startActivity(intent);
            }
        });

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
} 
