package com.example.plutusecurus.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.plutusecurus.databinding.ActivityAccountLoginBinding
import com.example.plutusecurus.utils.SharedPreferencesConfig

class AccountLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountLoginBinding
    private lateinit var sharedPreferencesConfig: SharedPreferencesConfig
    private val metamaskScheme = "metamask:wallet_getPermissions"
    private val REQ_CODE = 100
    private val messageToSign = "Please sign this message"
    private val TAG = "AccountLoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferencesConfig = SharedPreferencesConfig(this@AccountLoginActivity)

        init()
    }
    private fun init() {
        binding.getPublicKeyBtn.setOnClickListener {
            Toast.makeText(
                this@AccountLoginActivity,
                "Copy and paste your Public Address.",
                Toast.LENGTH_LONG
            ).show()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(metamaskScheme))
            startActivityForResult(intent, REQ_CODE)
        }
        binding.signUpBtn.setOnClickListener{
            val myIntent = Intent(this@AccountLoginActivity, LoginActivity::class.java)
            this@AccountLoginActivity.startActivity(myIntent)
        }
        binding.logInBtn.setOnClickListener {
            // TO BE DONE
        }
    }
}