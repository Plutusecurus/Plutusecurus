package com.example.plutusecurus.model

data class WalletTransaction(
    val _id: String,
    val createdAt: String,
    val eth: Double,
    val inr: Double,
    val recipient: Recipient,
    val remark: String,
    val sender: Sender,
    val razorpayPaymentId:String?=""
)