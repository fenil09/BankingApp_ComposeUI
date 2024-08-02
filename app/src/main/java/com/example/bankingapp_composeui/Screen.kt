package com.example.bankingapp_composeui

sealed class Screen (val route:String){
    object Home: Screen("new")
    object Account:Screen("account")
    object pay:Screen("pay")
}