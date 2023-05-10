package com.example.plutusecurus.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.example.plutusecurus.R;
import com.example.plutusecurus.data.ApiClient;
import com.example.plutusecurus.data.TransAPI;
import com.example.plutusecurus.databinding.ActivityLoginBinding;
import com.example.plutusecurus.dtos.RegisterResponse;
import com.example.plutusecurus.utils.SharedPreferencesConfig;
import com.google.android.material.snackbar.Snackbar;
import com.kenai.jffi.Main;

import org.web3j.crypto.ECKeyPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Objects;

import jnr.ffi.annotations.In;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    SharedPreferencesConfig sharedPreferencesConfig;
    private TransAPI transAPI;
    private Uri imageUri=null;

    private String metamaskScheme =  "metamask:wallet_getPermissions";
    private int REQ_CODE = 100;
    private String messageToSign = "Please sign this message";
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        transAPI = ApiClient.getApiClient().create(TransAPI.class);
        sharedPreferencesConfig = new SharedPreferencesConfig(this);

        init();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!sharedPreferencesConfig.readPublicKey().isEmpty()){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void init() {

        binding.getPublicKeyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Copy and paste your Public Address.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(metamaskScheme));
                startActivityForResult(intent, REQ_CODE);
            }
        });

        binding.getPvtKeyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Copy and paste your Private Address.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(metamaskScheme));
                startActivityForResult(intent, REQ_CODE);
            }
        });

        binding.addUserProfileImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectProfileImageFromGallery();
            }
        });

        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageUri==null
                        || binding.nameEditText.getText().toString().isEmpty()
                        || binding.publicAddressEdittext.getText().toString().isEmpty()
                        || binding.privateKeyEdittext.getText().toString().isEmpty()
                        || binding.upiIdET.getText().toString().isEmpty()) {
                    Snackbar.make(binding.getRoot(), "All Fields including profile image are mandatory!", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                try {
                    uploadImage(
                            imageUri,
                            binding.publicAddressEdittext.getText().toString(),
                            binding.nameEditText.getText().toString(),
                            binding.privateKeyEdittext.getText().toString(),
                            binding.upiIdET.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG, "uploadImageOnClick: "+e.getMessage());
                }
            }
        });
    }

    private void uploadImage(Uri imageUri, String accountComm, String nameComm, String privateKey, String upiIDComm) throws IOException {
        File filesDir = getApplicationContext().getFilesDir();
        File file = new File(filesDir, "profileImg."+getFileExtension(imageUri));

//        File file = uriToFile(imageUri);

        @SuppressLint("Recycle")
        InputStream inputStream = getContentResolver().openInputStream(imageUri);
        OutputStream outputStream = new FileOutputStream(file);

        byte[] buffer = new byte[1024]; // buffer size
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/"+getFileExtension(imageUri)), file);
        MultipartBody.Part profilePic = MultipartBody.Part.createFormData("profilePic", file.getName(), requestBody);

        MultipartBody.Part name = MultipartBody.Part.createFormData("name", nameComm);
        MultipartBody.Part account = MultipartBody.Part.createFormData("account", accountComm);
        MultipartBody.Part upiID = MultipartBody.Part.createFormData("upiID", upiIDComm);

        binding.signUpBtn.setVisibility(View.GONE);
        binding.otpProgressBar.setVisibility(View.VISIBLE);

        transAPI.createUser(profilePic, account, name, upiID)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.body()!=null) {

                            sharedPreferencesConfig.writePrivateKey(privateKey);
                            sharedPreferencesConfig.writeName(nameComm);
                            sharedPreferencesConfig.writeImage(response.body().getUser().getProfilePic());
                            sharedPreferencesConfig.writePublicKey(accountComm);
                            sharedPreferencesConfig.writeUpiID(upiIDComm);
                            sharedPreferencesConfig.writeUID(response.body().getUser().get_id());

                            Log.d(TAG, "onResponse(): "+response.body().getMessage().toString());
                            Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }



                        binding.signUpBtn.setVisibility(View.VISIBLE);
                        binding.otpProgressBar.setVisibility(View.GONE);

                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        binding.signUpBtn.setVisibility(View.VISIBLE);
                        binding.otpProgressBar.setVisibility(View.GONE);
                        Log.d(TAG, "onFailure(): "+t.getMessage());
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private File uriToFile(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String filePath = cursor.getString(column_index);
        cursor.close();
        return new File(filePath);
    }


    private RequestBody createPartFromString(String stringData) {
        return RequestBody.create(MediaType.parse("text/plain"), stringData);
    }

    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();

        // Return file Extension
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    private void selectProfileImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult(): "+resultCode);
//        Toast.makeText(this, resultCode+" "+requestCode, Toast.LENGTH_SHORT).show();

        if(resultCode == Activity.RESULT_OK && requestCode == 101) {
            if (data!=null) {
                imageUri = data.getData();
                binding.galleryProfilePicView.setImageURI(imageUri);
            }


        }

        else if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            // Get the account details from the Intent
            String address = data.getStringExtra("address");
            String chainId = data.getStringExtra("chainId");

            // Do something with the account details
            // ...

            Log.d(TAG, "address: "+address);
            Log.d(TAG, "chainId: "+chainId);
//            Toast.makeText(this, "address: "+address, Toast.LENGTH_SHORT).show();
        }

        /*else {
            Toast.makeText(this, "Please install Metamask app from Google Playstore.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=metamask&c=apps"));
            startActivity(intent);
        }*/
    }


}