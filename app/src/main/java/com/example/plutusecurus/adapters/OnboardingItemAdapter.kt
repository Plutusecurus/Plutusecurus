package com.example.plutusecurus.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plutusecurus.R
import com.example.plutusecurus.data.OnboardingItem

class OnboardingItemAdapter (private val onboardingItem: List<OnboardingItem>):
RecyclerView.Adapter<OnboardingItemAdapter.OnboardingItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboarding_items_container,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onboardingItem[position])
    }

    override fun getItemCount(): Int {
       return onboardingItem.size
    }

    inner class OnboardingItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val imageOnboarding=view.findViewById<ImageView>(R.id.imageOnboarding)
        private val title=view.findViewById<TextView>(R.id.textTitle)
        private val description=view.findViewById<TextView>(R.id.textDescription)

        fun bind(onboardingItem: OnboardingItem){
            imageOnboarding.setImageResource(onboardingItem.onboardingImage)
            title.text=onboardingItem.title
            description.text=onboardingItem.description

        }
    }
}