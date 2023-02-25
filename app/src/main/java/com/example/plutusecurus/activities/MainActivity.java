package com.example.plutusecurus.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.plutusecurus.R;
import com.example.plutusecurus.fragments.DashboardFragment;
import com.example.plutusecurus.fragments.NftFragment;
import com.example.plutusecurus.fragments.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.web3j.crypto.ECKeyPair;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;
    ImageView qrScanner,profileButton;
    private String metamaskScheme =  "metamask:wallet_getPermissions";
    private int requestCode = 100;
    private String messageToSign = "Please sign this message";
    private static final String TAG = "MainActivity";
    private static final String APP_KEY = "d58ff2f8-1048-49b4-b3ad-db99474e7c01";
    private static final String BRIDGE_URL = "https://bridge.walletconnect.org";

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new DashboardFragment()).commit();
        bottom_navigation=findViewById(R.id.bottom_nav);
        qrScanner=findViewById(R.id.qr);
        profileButton=findViewById(R.id.profile);

        /*SessionRequest sessionRequest = new SessionRequest.Builder()
                .setBridgeUrl("https://bridge.walletconnect.org")
                .setKey("YOUR_APP_KEY")
                .build();*/



// Create a WalletConnect session
        /*Session session = new Session(sessionRequest);*/

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(metamaskScheme));
        intent.setPackage("io.metamask");
        startActivityForResult(intent, requestCode);

        bottom_navigation.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment =null;

            switch (item.getItemId())
            {
                case R.id.dashboard:

                    selectedFragment=new DashboardFragment();
                    break;

                case R.id.wallet:
                    selectedFragment=new WalletFragment();
                    break;

                case R.id.nft:
                    selectedFragment=new NftFragment();
                    break;


            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        });

        qrScanner.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),QrActivity.class));
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
            }
        });

    }


}