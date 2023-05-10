package com.example.plutusecurus.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plutusecurus.databinding.ActivityTransactionSuccessfulBinding

class TransactionSuccessfulActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTransactionSuccessfulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionSuccessfulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transactionHash = intent.getStringExtra("hash").toString()
        binding.orderIdView.text = "Your transaction with transaction hash: $transactionHash has been confirmed!"


        binding.backToHomeBtn.setOnClickListener {
            startActivity(Intent(this@TransactionSuccessfulActivity, MainActivity::class.java))
            finish()
        }
    }
}