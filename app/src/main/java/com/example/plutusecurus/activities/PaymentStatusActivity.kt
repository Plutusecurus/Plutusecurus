package com.example.plutusecurus.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.plutusecurus.R
import com.example.plutusecurus.data.ApiClient.BASE_URL
import com.example.plutusecurus.databinding.ActivityPaymentStatusBinding
import com.example.plutusecurus.utils.SharedPreferencesConfig
import io.socket.client.IO
import io.socket.client.Socket
import okhttp3.OkHttpClient
import org.json.JSONObject
import java.net.URISyntaxException

class PaymentStatusActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPaymentStatusBinding
    private var socket: Socket?=null
    private lateinit var sharedPreferencesConfig: SharedPreferencesConfig

    /*
        senderPublicAddress, senderPrivateKey, recipientPublicAddress, amount, remark
        Intent paymentStatusIntent = new Intent(PaymentActivity.this, PaymentStatusActivity.class);
                    paymentStatusIntent.putExtra("paymentId", "")
                            .putExtra("recipientName", recipientName)
                            .putExtra("recipientPublicKey", recipientPublicKey)
                            .putExtra("recipientUId", recipientUId)
                            .putExtra("paymentType", paymentType)
                            .putExtra("remark", remarkCategory)
                            .putExtra("amount", paymentAmt);
         */
    private var recipientPublicAddress:String = ""
    private var amount:String = "0"
    private var remark:String = ""
    private var paymentId:String = ""
    private var paymentType:String = ""
    private var transactionHash:String = ""

    companion object{
        private const val TAG = "PaymentStatusActivity"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferencesConfig = SharedPreferencesConfig(this@PaymentStatusActivity)

        init()
        setupWebSocketConnection()

        if (paymentType == "INR") {
            val data = JSONObject()
            data.put("senderPublicAddress", sharedPreferencesConfig.readPublicKey())
            data.put("senderPrivateKey", sharedPreferencesConfig.readPrivateKey())
            data.put("recipientPublicAddress", recipientPublicAddress)
            data.put("amountInETH", amount.toDouble())
            data.put("remark", remark)
            data.put("paymentId", paymentId)

            socket?.emit("inr-to-eth", data)
        } else if(paymentType == "ETH") {
            val data = JSONObject()
            data.put("senderPublicAddress", sharedPreferencesConfig.readPublicKey())
            data.put("senderPrivateKey", sharedPreferencesConfig.readPrivateKey())
            data.put("recipientPublicAddress", recipientPublicAddress)
            data.put("amount", amount.toDouble())
            data.put("remark", remark)

            socket?.emit("eth-to-eth", data)
        } else {
            finish()
        }
    }

    private fun init() {
        recipientPublicAddress = if (intent.getStringExtra("recipientPublicKey")!=null)
            intent.getStringExtra("recipientPublicKey")!! else ""
        amount = if (intent.getStringExtra("amount")!=null)
            intent.getStringExtra("amount")!! else ""
        remark = if (intent.getStringExtra("remark")!=null)
            intent.getStringExtra("remark")!! else ""
        paymentId = if (intent.getStringExtra("paymentId")!=null)
            intent.getStringExtra("paymentId")!! else ""
        paymentType = if (intent.getStringExtra("paymentType")!=null)
            intent.getStringExtra("paymentType")!! else ""
    }

    private fun setupWebSocketConnection() {
        val options = IO.Options()
        options.callFactory = OkHttpClient.Builder().build()

        try {
            socket = IO.socket(BASE_URL, options)
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }

        socket?.on(Socket.EVENT_CONNECT) {
            // Connection established
            // Perform any necessary actions on connect
        }?.on(Socket.EVENT_DISCONNECT) {
            // Connection disconnected
            // Perform any necessary actions on disconnect
        }?.on(Socket.EVENT_CONNECT_ERROR) { args ->
            val exception = args[0] as Exception
            // Connection error
            // Handle the error
        }?.on(sharedPreferencesConfig.readPublicKey()) { args ->
            val data = args[0] as JSONObject
            val status = data.optString("status")
            val receivedData = data.optString("data")

            when(status) {
                "TransactionId-E2E"->{
                    runOnUiThread{
                        binding.transactionIdPB.visibility = View.GONE
                        binding.transactionIdTV.setTextColor(resources.getColor(R.color.green))
                        binding.transactionIdTV.text = "TransactionId: $receivedData"
                    }
                }
                "TransactionHash-E2E"->{
                    runOnUiThread{
                        binding.transactionHashPB.visibility = View.GONE
                        binding.transactionHashTV.setTextColor(resources.getColor(R.color.green))
                        transactionHash = receivedData
                        binding.transactionHashTV.text = "TransactionHash: $receivedData"
                    }
                }
                "Success-E2E"->{
                    socket?.disconnect()
                    runOnUiThread{
                        binding.transactionSuccessPB.visibility = View.GONE
                        binding.transactionSuccessTV.setTextColor(resources.getColor(R.color.green))

                        val intent1 = Intent(
                            this@PaymentStatusActivity,
                            TransactionSuccessfulActivity::class.java
                        )
                        intent1.putExtra("hash", transactionHash)
                        startActivity(intent1)
                        finish()
                    }
                }
                "Failure-E2E"->{
                    socket?.disconnect()
                    Log.e(TAG, "Failure-E2E: $receivedData")
                    runOnUiThread{
                        Toast.makeText(this@PaymentStatusActivity, "Failed!", Toast.LENGTH_SHORT)
                            .show()

                        finish()
                    }
                }
                "TransactionId-I2E"->{
                    runOnUiThread{
                        binding.transactionIdPB.visibility = View.GONE
                        binding.transactionIdTV.setTextColor(resources.getColor(R.color.green))
                        binding.transactionIdTV.text = "TransactionId: $receivedData"
                    }
                }
                "TransactionHash-I2E"->{
                    runOnUiThread{
                        binding.transactionHashPB.visibility = View.GONE
                        binding.transactionHashTV.setTextColor(resources.getColor(R.color.green))
                        transactionHash = receivedData
                        binding.transactionHashTV.text = "TransactionHash: $receivedData"
                    }
                }
                "Success-I2E"->{
                    socket?.disconnect()
                    runOnUiThread{
                        binding.transactionSuccessPB.visibility = View.GONE
                        binding.transactionSuccessTV.setTextColor(resources.getColor(R.color.green))

                        val intent1 = Intent(
                            this@PaymentStatusActivity,
                            TransactionSuccessfulActivity::class.java
                        )
                        intent1.putExtra("hash", transactionHash)
                        startActivity(intent1)
                        finish()
                    }
                }
                "Failure-I2E"->{
                    socket?.disconnect()
                    Log.e(TAG, "Failure-I2E: $receivedData")
                    runOnUiThread{
                        Toast.makeText(this@PaymentStatusActivity, "Failed!", Toast.LENGTH_SHORT)
                            .show()

                        finish()
                    }
                }
            }
        }

        socket?.connect()
    }



    override fun onDestroy() {
        super.onDestroy()
        socket?.disconnect()
    }
}