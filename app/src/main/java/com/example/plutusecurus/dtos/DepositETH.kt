package com.example.plutusecurus.dtos

data class DepositETH(
    val amount: String,
    val privateKey: String,
    val recipient: String,
    val sender: String
)