package com.example.plutusecurus.model

data class WalletTransactionResponse(
    val message:String,
    val transactions: List<WalletTransaction>?= emptyList()
)
