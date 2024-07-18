package com.example.bankingapp_composeui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun HomeScreen(){
    ChangeStausBarColor(color = Color.Black)
    Column(modifier = Modifier.fillMaxSize()) {
        TopSection()
        Spacer(modifier = Modifier.height(15.dp))
        CreditCardListInvocation(cards = CardObject.cards)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Finances", fontSize = 22.sp, color = Color.Black, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 5.dp))
        Spacer(modifier = Modifier.height(17.dp))
        FinanceSectionInvocation(financedata = FInanceObject.financedata)
        BottomNavigationMenu()
    }
}


@Composable
fun ChangeStausBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color)
    }

}


