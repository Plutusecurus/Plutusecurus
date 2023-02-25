package com.example.plutusecurus.fragments

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plutusecurus.R
import com.example.plutusecurus.model.History

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    val historyList = ArrayList<History>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        val viewHolder = HistoryViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val currentItem = historyList.get(position)
        holder.amount.text = currentItem.amount
        holder.date.text = currentItem.date
        holder.paymentFomTxtView.text = currentItem.paymentFrom
    }

    class HistoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val paymentFomTxtView = itemView.findViewById<TextView>(R.id.tv_transaction_from)
        val date = itemView.findViewById<TextView>(R.id.date)
        val amount = itemView.findViewById<TextView>(R.id.amount)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateTransaction(upatedList : ArrayList<History>){
        historyList.clear()
        historyList.addAll(upatedList)
        notifyDataSetChanged()
    }
}