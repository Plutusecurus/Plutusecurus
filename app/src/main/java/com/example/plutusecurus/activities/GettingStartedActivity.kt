package com.example.plutusecurus.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.plutusecurus.R
import com.example.plutusecurus.adapters.OnboardingItemAdapter
import com.example.plutusecurus.data.OnboardingItem
import java.lang.Boolean
import kotlin.Int
import kotlin.arrayOfNulls
import kotlin.let

class GettingStartedActivity : AppCompatActivity() {

    var prevStarted = "yes"
    override fun onResume() {
        super.onResume()
        val sharedpreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            val editor = sharedpreferences.edit()
            editor.putBoolean(prevStarted, Boolean.TRUE)
            editor.apply()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private lateinit var onboardingItemAdapter: OnboardingItemAdapter
    private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_started)
        setOnboardingItem()
        setupIndicators()
        setCurrentIndicator(0)

    }

    private fun setOnboardingItem(){
        onboardingItemAdapter= OnboardingItemAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.page1,
                    title = "Sign Up",
                    description = "Once you are done filling all the fields, hit the SIGN UP button!!"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.page2,
                    title = "Dashboard",
                    description = "This is your landing page whenever you open the application."
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.page3,
                    title = "Add Your Earnings and Spending",
                    description = "You can add all your offline deposits and spending here!!"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.page4,
                    title = "Get Insights of your Expenses",
                    description = "You can keep a track of all your expenses both online and offline using our expense tracker"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.page5,
                    title = "Wallet",
                    description = "In this section you can perform transactions just by clicking the 'Tap to Pay' button and by scanning the QR. You can also keep a track of your previous transactions"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.page6,
                    title = "Make Payments",
                    description = "Select how you want to perform the transaction and fill in the amount."
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.page7,
                    title = "Payment Successful",
                    description = "Wait for a few seconds for the transaction to complete."
                ),OnboardingItem(
                    onboardingImage = R.drawable.plutusecurusbanner,
                    title = "Contact Us",
                    description = "We are currently in our first stage of development, so you might encounter a lot of bugs. Do consider reporting those bugs to us so that we can improve your user experiences. You can come back to this tutorial any time you want!! \n Feel free to contact us @: suswan.biswas@gmail.com"
                )

            )
        )
        val onboardingViewPager=findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter=onboardingItemAdapter
        onboardingViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
                if(onboardingViewPager.currentItem+1<onboardingItemAdapter.itemCount){
                    findViewById<ImageView>(R.id.next_btn).visibility=View.VISIBLE
                    findViewById<TextView>(R.id.get_started_btn).visibility=View.GONE
                }else{
                    findViewById<ImageView>(R.id.next_btn).visibility=View.GONE
                    findViewById<TextView>(R.id.get_started_btn).visibility=View.VISIBLE
                }

            }
        })
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode=
            RecyclerView.OVER_SCROLL_NEVER


        findViewById<TextView>(R.id.skipBtn).setOnClickListener {
            val myIntent = Intent(this@GettingStartedActivity, LoginActivity::class.java)
            this@GettingStartedActivity.startActivity(myIntent)
            finish()
        }

        findViewById<CardView>(R.id.move_forward_btn).setOnClickListener{
            if(onboardingViewPager.currentItem+1<onboardingItemAdapter.itemCount){
                onboardingViewPager.currentItem +=1
            }else{
                val myIntent = Intent(this@GettingStartedActivity, LoginActivity::class.java)
                this@GettingStartedActivity.startActivity(myIntent)
                finish()
            }
        }
    }

    private fun setupIndicators(){
        indicatorsContainer=findViewById(R.id.indicatorsContainer)
        val indicators= arrayOfNulls<ImageView>(onboardingItemAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams=
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for(i in indicators.indices){
            indicators[i]= ImageView(applicationContext)
            indicators[i]?.let{
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams=layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }
    private fun setCurrentIndicator(position:Int){
        val childCount=indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView=indicatorsContainer.getChildAt(i) as ImageView
            if(i== position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,R.drawable.indicator_active_background
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}