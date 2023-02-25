package com.example.plutusecurus.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.plutusecurus.R;
import com.example.plutusecurus.activities.PlannerActivity;
import com.example.plutusecurus.activities.ProfileActivity;
import com.example.plutusecurus.activities.QrActivity;

public class WalletFragment extends Fragment {

    ImageView profilePicture,userQr;
    TextView userId, username;
    CardView payButton;
    TextView balance;
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
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), QrActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }
} 
