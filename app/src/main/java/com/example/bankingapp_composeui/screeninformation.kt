package com.example.bankingapp_composeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun newhomescreen(){
    Box(modifier=Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize()){
            TopSection()
            Spacer(modifier = Modifier.height(15.dp))
            CreditCardListInvocation(cards = CardObject.cards)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Finances", fontSize = 22.sp, color = Color.Black, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 5.dp))
            Spacer(modifier = Modifier.height(17.dp))
            FinanceSectionInvocation(financedata = FInanceObject.financedata)
        }
    }
}
@Composable
fun AccountScreen() {
    Box(modifier=Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Account Screen", color = Color.Black)
        }
    }
}

@Composable
fun PayScreen(){
    Box(modifier=Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "PayScreen", color = Color.Black)
        }
    }
}