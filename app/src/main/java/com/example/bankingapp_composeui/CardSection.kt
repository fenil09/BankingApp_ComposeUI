package com.example.bankingapp_composeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CreditCardSection(card:CardData){

    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ){

        Box(modifier = Modifier.background(
            brush = Brush.horizontalGradient(
                colors = listOf(card.startcolor,card.endColor),
            )
        ).padding(16.dp)){

             Column {
                 Text(
                     text=card.cardtype,
                     fontWeight = FontWeight.Bold,
                     fontSize = 15.sp,
                     color = Color.White
                 )
                 Spacer(modifier = Modifier.height(4.dp))
                 Text(
                     text = card.cardnumber,
                     fontWeight = FontWeight.SemiBold,
                     fontSize = 15.sp,
                     color = Color.White
                 )
                 Spacer(modifier = Modifier.height(4.dp))
                 Text(
                     text = card.cardholdername,
                     fontWeight = FontWeight.Bold,
                     fontSize = 15.sp,
                     color=Color.White
                 )
                 Spacer(modifier = Modifier.height(4.dp))
                 Text(
                     text = card.expirationDate,
                     fontWeight = FontWeight.SemiBold,
                     fontSize = 15.sp,
                     color = Color.White
                 )

             }
        }
    }


}


@Composable
fun CreditCardListInvocation(cards:List<CardData>){
    LazyRow {
        items(cards.size){
            CreditCardSection(card = cards[it])
        }
    }
}

