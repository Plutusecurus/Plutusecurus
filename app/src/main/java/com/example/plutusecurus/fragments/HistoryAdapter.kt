package com.example.plutusecurus.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.plutusecurus.R
import com.example.plutusecurus.model.WalletTransaction
import java.text.DecimalFormat

class HistoryAdapter(
    private val context:Context,
    private val transactionTypeDetector: TransactionTypeDetector
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    val historyList = ArrayList<WalletTransaction>()
    val decimalFormatINR = DecimalFormat("#.##")
    val decimalFormatETH = DecimalFormat("#.#######")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        val viewHolder = HistoryViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val currentItem = historyList[position]

        holder.amount.text = "Rs. ${decimalFormatINR.format(currentItem.inr)} (${decimalFormatETH.format(currentItem.eth)})"

        if (transactionTypeDetector.isCredit(position)) holder.typeIndicator.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.rectangular_background_2
            )
        ) else holder.typeIndicator.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.rectangular_background_1
            )
        )

        holder.transactionType.text = currentItem.remark

        holder.dateView.text = currentItem.createdAt.split("T")[0]

    }

    class HistoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val typeIndicator = itemView.findViewById<ImageView>(R.id.type_indicator)
        val amount = itemView.findViewById<TextView>(R.id.amount_view)
        val transactionType = itemView.findViewById<TextView>(R.id.transaction_type)
        val dateView = itemView.findViewById<TextView>(R.id.date_view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateTransaction(upatedList : ArrayList<WalletTransaction>){
        historyList.clear()
        historyList.addAll(upatedList)
        notifyDataSetChanged()
    }
}

interface TransactionTypeDetector {
    fun isCredit(position: Int):Boolean
}