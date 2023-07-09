package com.example.plutusecurus.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.plutusecurus.data.ApiClient
import com.example.plutusecurus.data.TransAPI
import com.example.plutusecurus.databinding.ActivityAccountLoginBinding
import com.example.plutusecurus.dtos.GetUserResponse
import com.example.plutusecurus.model.LoginBody
import com.example.plutusecurus.model.LoginResponse
import com.example.plutusecurus.utils.SharedPreferencesConfig
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Response


class AccountLoginActivity : AppCompatActivity() {

    private var transAPI: TransAPI? = null
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
        transAPI = ApiClient.getApiClient().create(TransAPI::class.java)
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
        binding.getPvtKeyBtn.setOnClickListener {
            Toast.makeText(
                this@AccountLoginActivity,
                "Copy and paste your Private Address.",
                Toast.LENGTH_LONG
            ).show()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(metamaskScheme))
            startActivityForResult(intent, REQ_CODE)
        }
        binding.signUpBtn.setOnClickListener{
            val myIntent = Intent(this@AccountLoginActivity, AccountLoginActivity::class.java)
            this@AccountLoginActivity.startActivity(myIntent)
        }
        binding.logInBtn.setOnClickListener {
            val publicAddress= binding.publicAddressEdittext.text.toString()
            val password=binding.password.text.toString()
            val privateKey=binding.privateKeyEdittext.text.toString()
            if(publicAddress.isEmpty() || password.isEmpty()){
                Snackbar.make(binding.root, "Please enter Public Address and Password!!", Snackbar.LENGTH_SHORT).show()
            }
            /*Toast.makeText(getContext(), publicKey, Toast.LENGTH_SHORT).show();*/


            binding.logInBtn.visibility = View.GONE
            binding.otpProgressBar.visibility = View.VISIBLE

            transAPI?.loginUser(LoginBody(publicAddress, password))
                ?.enqueue(object : retrofit2.Callback<LoginResponse>{
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if(response.body()!=null){
                            sharedPreferencesConfig.writePublicKey(publicAddress)
                            sharedPreferencesConfig.writeToken(response.body()!!.token.toString())
                            sharedPreferencesConfig.writePrivateKey(privateKey)
                            setUser()

                        }else{
                            Toast.makeText(this@AccountLoginActivity,response.message().toString(), Toast.LENGTH_SHORT).show()
                            binding.logInBtn.visibility = View.VISIBLE
                            binding.otpProgressBar.visibility = View.GONE
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@AccountLoginActivity,"Error:"+ t.message, Toast.LENGTH_SHORT).show()
                        binding.logInBtn.visibility = View.VISIBLE
                        binding.otpProgressBar.visibility = View.GONE
                    }

                })




        }
    }

    private fun setUser() {
        transAPI?.getUser(sharedPreferencesConfig.readPublicKey())
            ?.enqueue(object: retrofit2.Callback<GetUserResponse>{
                override fun onResponse(
                    call: Call<GetUserResponse?>?,
                    response: Response<GetUserResponse?>
                ) {
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            sharedPreferencesConfig.writeName(response.body()!!.getUser().name)
                            sharedPreferencesConfig.writeImage(response.body()!!.getUser().profilePic)
                            sharedPreferencesConfig.writeUID(response.body()!!.getUser()._id)
                            sharedPreferencesConfig.writeUpiID(response.body()!!.getUser().upiID)

                            Toast.makeText(this@AccountLoginActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    binding.logInBtn.visibility = View.VISIBLE
                    binding.otpProgressBar.visibility = View.GONE
                }

                override fun onFailure(call: Call<GetUserResponse?>?, t: Throwable) {
                    binding.logInBtn.visibility = View.VISIBLE
                    binding.otpProgressBar.visibility = View.GONE
                    //Log.d(LoginActivity.TAG, "onFailure(): " + t.message)
                    Toast.makeText(this@AccountLoginActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}