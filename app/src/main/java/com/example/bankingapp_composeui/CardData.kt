package com.example.bankingapp_composeui

import androidx.compose.ui.graphics.Color


data class CardData(
    val cardnumber:String,
    val cardholdername:String,
    val expirationDate:String,
    val cardtype:String,
    val cardimage:Int,
    val startcolor: Color,
    val endColor:Color
)
