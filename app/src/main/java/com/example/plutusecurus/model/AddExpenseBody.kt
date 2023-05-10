package com.example.plutusecurus.model

data class AddExpenseBody(
    val address: String,
    val amount: Double,
    val category: String
)