package com.example.bankingapp_composeui

import androidx.compose.ui.graphics.vector.ImageVector

data class CurrencyData(
    val currencyname:String,
    val currencyicon: ImageVector,
    val buyamount:String,
    val sellamount:String
)
